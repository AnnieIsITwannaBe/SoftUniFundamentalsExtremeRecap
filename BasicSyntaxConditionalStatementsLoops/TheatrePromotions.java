package BasicSyntaxConditionalStatementsLoops;

import java.util.Scanner;

public class TheatrePromotions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dayType = scanner.nextLine();
        int ageGroup = Integer.parseInt(scanner.nextLine());

        int ticketPrice = switch (dayType) {
            case "WeekDay", "Weekend", "Holiday" -> accommodatePriceInRelationToAgeGroup(ageGroup, dayType);
            default -> -1;
        };

        if (ticketPrice == 0) {
            System.out.println("Error!");
        } else {
            System.out.println(ticketPrice + "$");
        }


    }

    private static int accommodatePriceInRelationToAgeGroup(int ageGroup, String dayType) {
        int price = 0;
        price = switch (dayType) {
            case "WeekDay" -> getPrice(ageGroup, price, 12, 12, 18);
            case "Weekend" -> getPrice(ageGroup, price, 15, 15, 20);
            case "Holiday" -> getPrice(ageGroup, price, 5, 10, 12);
            default -> 0;
        };
        return price;
    }

    private static int getPrice(int ageGroup, int price, int price1, int price11, int price2) {
        if (ageGroup >= 0 && ageGroup <= 18) {
            price = price1;
        } else if (ageGroup > 18 && ageGroup <= 64) {
            price = price2;
        } else if (ageGroup > 64 && ageGroup <= 122) {
            price = price11;

        }
        return price;
    }
}
