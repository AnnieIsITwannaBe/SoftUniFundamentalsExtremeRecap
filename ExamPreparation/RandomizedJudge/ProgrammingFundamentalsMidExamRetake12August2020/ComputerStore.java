package ExamPreparation.RandomizedJudge.ProgrammingFundamentalsMidExamRetake12August2020;

import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        double priceTotal = 0.0;
        //String customerType = " ";
        //handlePriceBreakdown:
        while (!(line.equals("special") || line.equals("regular"))) {
            //we need to calculate 20% of this sum = price part * 0.20;
            priceTotal = handleEachPaymentTaxation(scanner, priceTotal);

            line = scanner.nextLine();
        }

        double discount = 0.0;
        if (line.equals("special")) {
            discount = priceTotal * 0.10;
            priceTotal -= discount;
        }

        System.out.println(priceTotal);


    }

    private static double handleEachPaymentTaxation(Scanner scanner, double priceTotal) {
        double pricePart = Double.parseDouble(scanner.nextLine());
        double tax = pricePart * 0.20;
        priceTotal += tax + pricePart;
        return priceTotal;
    }

//    public double calculatePercentage(double sum){
//        return sum * 100 /
//    }
}
//тъй като да пресмяташ проценти е тотално нещо, което така и не усвои гледай тва по три пъти на ден:
//https://www.wikihow.com/Calculate-Percentage-in-Java
//In mathematics, a percentage is a number or ratio expressed as a fraction of 100.
// It’s often denoted using the percent sign, “%”.
//btw какво прави notify?

//Your code is well-structured and functional, but there are a few improvements that can be made for clarity, correctness, and efficiency. I'll provide a detailed review and suggest some improvements.
//
//Code Review and Feedback:
//Handling Invalid Prices:
//
//The problem statement requires you to check if a given price is a positive number. If the price is not positive, you should print "Invalid price!" and skip processing that price.
//Currently, your code does not handle this case, which is a significant issue because it can lead to incorrect calculations.
//Loop Structure:
//
//The loop structure is generally fine, but handling the input within the handleEachPaymentTaxation method is unconventional. Typically, you'd process input outside of such methods to maintain clear separation of concerns.
//Discount Calculation:
//
//Your discount calculation is correct, but it should only be applied if the priceTotal is greater than zero. If the priceTotal is zero, you should print "Invalid order!" instead of applying the discount or printing the total price.
//Output Format:
//
//The output should include the total price without taxes, the total taxes, the final price, and the discount (if applicable). This gives a complete receipt format.
//Minor Code Improvements:
//
//The variable discount can be directly calculated inside the conditional block where the customer type is checked.
//Consider improving method names to be more descriptive of their purpose, such as calculateTotalPriceWithTax.