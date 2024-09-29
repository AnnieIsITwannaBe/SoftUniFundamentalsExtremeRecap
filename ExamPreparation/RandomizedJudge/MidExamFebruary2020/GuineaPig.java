package ExamPreparation.RandomizedJudge.MidExamFebruary2020;

import java.util.Scanner;

//Every day Puppy eats 300 gr of food. Every second day Merry first feeds the pet, then gives it a certain amount of hay equal to 5% of the rest of the food. On every third day, Merry puts Puppy cover with a quantity of 1/3 of its weight.
//Calculate whether the quantity of food, hay, and cover, will be enough for a month.
//If Merry runs out of food, hay, or cover, stop the program!


public class GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double foodInKg = Double.parseDouble(scanner.nextLine());
        double hayInKg = Double.parseDouble(scanner.nextLine());
        double coverInKg = Double.parseDouble(scanner.nextLine());
        double guineaPigWeightInKg = Double.parseDouble(scanner.nextLine());


        int currentMonthDays = 30;
        //in order to track number of day
        int dayCounter = 0;
        double foodInGrams = foodInKg * 1000;

        while (currentMonthDays-- > 0) {
            dayCounter++;
            foodInGrams -= 300;
            //maybe we can do this with a single if with logical operators
            if (reachedLimit(foodInGrams)) {
                break;
            }

            hayInKg = handleEverySecondDay(dayCounter, foodInGrams, hayInKg);
            if (reachedLimit(hayInKg)) {
                break;
            }

            coverInKg = handleEveryThirdDay(dayCounter, guineaPigWeightInKg, coverInKg);
            if (reachedLimit(coverInKg)) {
                break;
            }

            //in order to somehow somewhen we reach the end of the month
            currentMonthDays--;
        }
    }

    private static boolean reachedLimit(double value) {
        return value == 0;
    }

    private static double handleEveryThirdDay(int dayCounter, double guineaPigWeightInKg, double coverInKg) {
        if (dayCounter % 3 == 0) {
            double oneThirdOfWeight = guineaPigWeightInKg * (1.0 / 3.0);
            coverInKg -= oneThirdOfWeight;

        }
        return coverInKg;
    }

    private static double handleEverySecondDay(int dayCounter, double foodInGrams, double hayInKg) {
        if (dayCounter % 2 == 0) {
            double hayToBeGiven = foodInGrams * 0.5;
            hayInKg -= hayToBeGiven;
        }
        return hayInKg;
    }
}
