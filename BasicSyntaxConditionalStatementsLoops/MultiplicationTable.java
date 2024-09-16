package BasicSyntaxConditionalStatementsLoops;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numToMultiply = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= 10; i++) {
            System.out.println(numToMultiply + " X " + i + " = " + numToMultiply * i);
        }
    }
}
