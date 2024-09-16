package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amountOfMoney = Integer.parseInt(scanner.nextLine());
        int countOfStudents = Integer.parseInt(scanner.nextLine());
        double priceForLightSaber = Double.parseDouble(scanner.nextLine());
        double priceForRobes = Double.parseDouble(scanner.nextLine());
        double priceForBelts = Double.parseDouble(scanner.nextLine());

        //10% more of the lightSabers ->
        double lightSabersPriceUnadulterated = priceForLightSaber * countOfStudents;
        double lightSabersPriceIncrease = lightSabersPriceUnadulterated * 0.1;
        double lightSabersPriceAdulterated = lightSabersPriceUnadulterated + lightSabersPriceIncrease * countOfStudents;

        //this can be simplified like that:
        // double lightSabersPriceAdulterated = priceForLightSaber * countOfStudents * 1.1;
        //but I do not fully understand that

        //every 6th belt is free:
        double beltsPrice = ((double) countOfStudents / 6) * priceForBelts;

        //no requirement for robes
        double robesPrice = priceForRobes * countOfStudents;

        double totalPrice = lightSabersPriceAdulterated + robesPrice + beltsPrice;
        if (totalPrice > amountOfMoney) {
            totalPrice -= amountOfMoney;
            System.out.printf("George Lucas will need %.2flv more.", totalPrice);
        } else {
            System.out.printf("The money is enough - it would cost %.2f", totalPrice);
        }


    }
}
