package ObjectsAndClassesExercises.VehicleCatalouge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        List<Vehicle> allVehicles = populateCatalouge(line, scanner);

        line = scanner.nextLine();

        List<Vehicle> selectedVehicles = selectVehicles(line, allVehicles, scanner);

        printOutcome(selectedVehicles);
    }

    private static void printOutcome(List<Vehicle> selectedVehicles) {
        selectedVehicles.forEach(System.out::println);
    }

    private static List<Vehicle> selectVehicles(String line, List<Vehicle> allVehicles, Scanner scanner) {
        List<Vehicle> selectedVehicles = new ArrayList<>();
        while (!line.equals("Close the Catalogue")) {
            String selectedModel = line;

            for (Vehicle allVehicle : allVehicles) {
                if (allVehicle.getModel().equals(selectedModel)) {
                    selectedVehicles.add(allVehicle);
                }
            }
            line = scanner.nextLine();
        }
        return selectedVehicles;
    }

    private static List<Vehicle> populateCatalouge(String line, Scanner scanner) {
        List<Vehicle> vehicles = new ArrayList<>();
        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");
            String vehicleType = tokens[0];
            String model = tokens[1];
            String color = tokens[2];
            double horsePower = Double.parseDouble(tokens[3]);

            Vehicle vehicle = new Vehicle(vehicleType, model, color, horsePower);
            vehicles.add(vehicle);

            line = scanner.nextLine();
        }
        return vehicles;
    }
}
