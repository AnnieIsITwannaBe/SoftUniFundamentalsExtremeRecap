package BasicSyntaxConditionalStatementsLoops;

import java.util.Map;
import java.util.Scanner;

public class EvenNumber {
    //To find a number's absolute value, Java's Math class has the abs() function.
    // The abs() function accepts an integer data type parameter and returns the value's positive value. The abs() function in Java is used to
    // calculate the absolute value of a number. It returns the absolute value of the argument passed to it.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        if (num % 2 == 0) {
            int absoluteValue = Math.abs(num);
            System.out.println("The number is: " + absoluteValue);
        } else {
            System.out.println("Please write an even number!");
        }


        ;
    }
}
