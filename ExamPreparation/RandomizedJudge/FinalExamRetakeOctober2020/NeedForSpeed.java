package ExamPreparation.RandomizedJudge.FinalExamRetakeOctober2020;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class NeedForSpeed {
    private static final String NOT_ENOUGH_FUEL = "Not enough fuel to make that ride";

    private static final String CAR_DRIVEN = "%s driven for %d kilometers. %d liters of fuel consumed.";

    private static final String TIME_FOR_SALE = "Time to sell the %s!";

    private static final String REFUELED = "%s refueled with %d liters";

    private static final String REVERT_KILOMETERS = "%s mileage decreased by %d kilometers";

    private static final int MILEAGE_MAX_LIMIT = 100000;

    private static final int MILEAGE_REVERT_MAX = 10000;

    private static final int TANK_MAX_LIMIT = 75;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> carList = addCars(n, scanner);

        String line = scanner.nextLine();

        handleManipulationOperations(line, carList, scanner);

        carList.forEach(entry -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.\n",
                entry.getCarName(), entry.getMileage(), entry.getFuel()));

    }

    private static void handleManipulationOperations(String line, List<Car> carList, Scanner scanner) {
        while (!line.equals("Stop")) {
            String[] tokens = line.split("\\s+:\\s+");
            String command = tokens[0];
            switch (command) {
                case "Drive":
                    handleDrive(tokens, carList);
                    break;

                case "Refuel":
                    handleRefuelTank(tokens, carList);
                    break;

                case "Revert":
                    handleRevertKilometers(tokens, carList);
                    break;
            }
            line = scanner.nextLine();
        }
    }

    private static void handleRevertKilometers(String[] tokens, List<Car> carList) {
        String carName = tokens[1];
        int kilometers = Integer.parseInt(tokens[2]);

        Car selectedCar = getSelectedCar(carList, carName);

        assert selectedCar != null;

        selectedCar.setMileage(selectedCar.getMileage() - kilometers);

        if (selectedCar.getMileage() < MILEAGE_REVERT_MAX) {
            selectedCar.setMileage(MILEAGE_REVERT_MAX);
        } else {
            System.out.printf(REVERT_KILOMETERS, carName, kilometers);
        }
    }

    private static void handleRefuelTank(String[] tokens, List<Car> carList) {
        String carName = tokens[1];
        int fuelToAdd = Integer.parseInt(tokens[2]);

        Car selectedCar = getSelectedCar(carList, carName);

        assert selectedCar != null;

        int currentFuel = selectedCar.getFuel();

        selectedCar.setFuel(selectedCar.getFuel() + fuelToAdd);

        boolean reachedMaxCapacity = selectedCar.getFuel() > TANK_MAX_LIMIT;
        int utilizedFuel = 0;
        if (reachedMaxCapacity) {
            selectedCar.setFuel(TANK_MAX_LIMIT);

            utilizedFuel = TANK_MAX_LIMIT - currentFuel;
        }

        System.out.printf(REFUELED, carName, utilizedFuel);
    }

    private static void handleDrive(String[] tokens, List<Car> carList) {
        String carName = tokens[1];
        int distance = Integer.parseInt(tokens[2]);
        int fuel = Integer.parseInt(tokens[3]);

        Car selectedCar = getSelectedCar(carList, carName);

        assert selectedCar != null;
        if (selectedCar.getFuel() >= fuel) {
            selectedCar.setFuel(selectedCar.getFuel() - fuel);
            selectedCar.setMileage(selectedCar.getMileage() + distance);
            System.out.printf(CAR_DRIVEN, selectedCar.getCarName(), selectedCar.getMileage(), selectedCar.getFuel());
        } else {
            System.out.println(NOT_ENOUGH_FUEL);
        }

        boolean reachedLimitMileage = selectedCar.getMileage() == MILEAGE_MAX_LIMIT;
        if (reachedLimitMileage) {
            System.out.printf(TIME_FOR_SALE, selectedCar.getCarName());
        }
    }

    private static Car getSelectedCar(List<Car> carList, String carName) {
        return carList.stream().filter(car -> car.getCarName().equals(carName)).findFirst().orElse(null);
    }

    private static List<Car> addCars(int n, Scanner scanner) {
        List<Car> carList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\|\\s+");
            String carName = tokens[0];
            int mileage = Integer.parseInt(tokens[1]);
            int fuel = Integer.parseInt(tokens[2]);

            Car currentCar = new Car(carName, mileage, fuel);
            carList.add(currentCar);
        }
        return carList;
    }

}
