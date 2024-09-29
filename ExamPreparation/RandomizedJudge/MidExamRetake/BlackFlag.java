package ExamPreparation.RandomizedJudge.MidExamRetake;

import java.util.Scanner;

public class BlackFlag {
    private static final String CAPTAINED_REACHED_TARGET = "Ahoy! %.2f plunder gained.";

    private static final String PERCENTAGE_OF_PLUNDER = "Collected only %.2f of the plunder.";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Calculate how much plunder the pirates manage to gather. Each day they gather the plunder.
        // Keep in mind that they attack more ships every third day and add additional plunder to their total gain,
        // which is 50% of the daily plunder. Every fifth day the pirates encounter a warship, and after the battle,
        // they lose 30% of their total plunder.
        //If the gained plunder is more or equal to the target, print the following:
        //"Ahoy! {totalPlunder} plunder gained."

        int daysOfPlunder = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Integer.parseInt(scanner.nextLine());


        int currentDay = 0;
        double totalPlunder = 0.0;
        while (daysOfPlunder-- > 0) {
            currentDay++;

            if (currentDay % 3 == 0) {
                double additionalPlunder = dailyPlunder * 0.5;
                totalPlunder += (totalPlunder + additionalPlunder);
            } else {
                totalPlunder += dailyPlunder;
            }

            if (currentDay % 5 == 0) {
                double lost = totalPlunder * 0.3;
                totalPlunder -= lost;
            }
            daysOfPlunder--;
        }

        if (totalPlunder >= expectedPlunder) {
            System.out.printf(CAPTAINED_REACHED_TARGET, totalPlunder);
        } else {
            //check if this is the correct way of handling it:
            double percentage = (expectedPlunder / totalPlunder) * 100;
            System.out.printf(PERCENTAGE_OF_PLUNDER, percentage);

        }
    }
}
