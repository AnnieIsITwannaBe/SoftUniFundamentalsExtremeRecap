package ExamPreparation.second;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Pirates {

    public static final String TOWN_PLUNDERED_MESSAGE = "%s plundered! %d gold stolen, %d citizens killed.";

    public static final String TOWN_WIPED_OFF_MAP_MESSAGE = "%s has been wiped off the map!";

    public static final String TOWN_PROSPERED_MESSAGE = "%d gold added to the city treasury. %s now has %d gold.";

    public static final String NEGATIVE_GOLD_ERROR_MESSAGE = "Gold added cannot be a negative number!";

    public static void main(String[] args) {

        //almost finished but overall that's it

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        List<City> cities = addTargetCities(line, scanner);


        line = scanner.nextLine();
        while (!line.equals("End")) {
            String[] tokens = line.split("=>");
            String command = tokens[0];

            switch (command) {
                case "Plunder":
                    handlePlunder(tokens, cities);
                    break;

                case "Prosper":
                    handleProsper(tokens, cities);
                    break;
            }
            line = scanner.nextLine();
        }
    }

    private static void handleProsper(String[] tokens, List<City> cities) {
        String cityName = tokens[1];
        int gold = Integer.parseInt(tokens[2]);

        City cityProspering = cities.stream().filter(currentCity -> currentCity.getCity().equals(cityName)).findFirst().orElse(null);

        assert cityProspering != null;
        if (gold > 0) {
            cityProspering.setGold(cityProspering.getGold() + gold);
            System.out.printf(TOWN_PROSPERED_MESSAGE, gold, cityName, cityProspering.getGold());
        } else {
            System.out.println(NEGATIVE_GOLD_ERROR_MESSAGE);
        }
    }
    private static void handlePlunder(String[] tokens, List<City> cities) {
        String cityName = tokens[1];
        int peopleKilled = Integer.parseInt(tokens[2]);
        int goldStolen = Integer.parseInt(tokens[3]);

        City cityPlundered = cities.stream().filter(currentCity -> currentCity.getCity().equals(cityName)).findFirst().orElse(null);

        assert cityPlundered != null;
        cityPlundered.setPopulation(cityPlundered.getPopulation() - peopleKilled);
        cityPlundered.setGold(cityPlundered.getGold() - goldStolen);

        if (cityPlundered.getGold() <= 0 || cityPlundered.getPopulation() <= 0) {
            cities.remove(cityPlundered);
            System.out.printf(TOWN_WIPED_OFF_MAP_MESSAGE, cityName);
        }

        System.out.printf(TOWN_PLUNDERED_MESSAGE, cityName, goldStolen, peopleKilled);
    }

    private static List<City> addTargetCities(String line, Scanner scanner) {
        List<City> cities = new LinkedList<>();
        while (!line.equals("Sail")) {
            String[] tokens = line.split("\\||");
            String city = tokens[0];
            int population = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);

            City currentCity = new City(city, population, gold);
            cities.add(currentCity);

            line = scanner.nextLine();
        }
        return cities;
    }
}
