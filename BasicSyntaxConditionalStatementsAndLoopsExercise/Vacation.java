package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.*;

public class Vacation {
    public static void main(String[] args) {
        Map<Integer, List<String>> data = getConsoleInput();
        double totalPrice = preparePriceForGuestBasedOnData(data);
        printFormat(totalPrice);
    }

    private static void printFormat(double totalPrice) {
        String finalMessage = "Total price: " + totalPrice;
        System.out.println(finalMessage);
    }

    private static double preparePriceForGuestBasedOnData(Map<Integer, List<String>> data) {
        double price = 0.0;
        for (Map.Entry<Integer, List<String>> unitPoint : data.entrySet()) {
            int countOfGuests = unitPoint.getKey();
            List<String> groupRequirements = unitPoint.getValue();
            String guestType = groupRequirements.get(0);
            String dayType = groupRequirements.get(1);

            price = accommodateStudentsPriceInRelationToDayType(dayType, guestType, countOfGuests);
        }

        return price;
    }


    private static double accommodateStudentsPriceInRelationToDayType(String dayType, String guestType, int countOfGuests) {
        double pricePerPerson = 0;
        pricePerPerson = switch (guestType) {
            case "Student" -> switch (dayType) {
                case "Friday" -> 8.45;
                case "Saturday" -> 9.80;
                case "Sunday" -> 10.46;
                default -> pricePerPerson;
            };
            case "Regular" -> switch (dayType) {
                case "Friday" -> 10.90;
                case "Saturday" -> 15.60;
                case "Sunday" -> 16;
                default -> pricePerPerson;
            };
            case "Business" -> switch (dayType) {
                case "Friday" -> 15;
                case "Saturday" -> 20;
                case "Sunday" -> 22.50;
                default -> pricePerPerson;
            };
            default -> 0;
        };

        double priceUnadulterated = pricePerPerson * countOfGuests;

        return handlePossibleDiscounts(priceUnadulterated, guestType, countOfGuests);
    }

    private static double handlePossibleDiscounts(double priceUnadulterated, String guestType, int countOfGuests) {
        double priceAdulterated = 0.0;
        switch (guestType) {
            case "Student":
                if (countOfGuests >= 30) {
                    double percent = priceUnadulterated * 1.5;
                    priceAdulterated = priceUnadulterated - percent;
                }
                break;
            case "Business":
                if (countOfGuests >= 100) {
                    double pricePerEachPerson = priceUnadulterated / countOfGuests;
                    double pricePerTenPeople = pricePerEachPerson * 10;
                    priceAdulterated = priceUnadulterated - pricePerTenPeople;
                }
                break;
            case "Regular":
                if (countOfGuests >= 10 && countOfGuests <= 20) {
                    double percent = priceUnadulterated * 0.5;
                    priceAdulterated = priceUnadulterated - percent;
                }
                break;
        }

        if (priceAdulterated != 0.0) {
            return priceAdulterated;
        } else {
            return priceUnadulterated;
        }
    }

    private static Map<Integer, List<String>> getConsoleInput() {
        Scanner scanner = new Scanner(System.in);
        int numberOfGuests = Integer.parseInt(scanner.nextLine());
        String guestType = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();

        Map<Integer, List<String>> data = new HashMap<>();
        List<String> guestTypePlusDayType = List.of(guestType, dayOfWeek);
        data.put(numberOfGuests, guestTypePlusDayType);

        return data;
    }
}
