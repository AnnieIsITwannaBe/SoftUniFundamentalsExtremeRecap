package MethodsLaB;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TribonacciSequence {
    //generalization of the Fibonacci sequence
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sequenceSize = Integer.parseInt(scanner.nextLine());

        printTrib(sequenceSize);
    }

    static void printTrib(int n) {
        for (int i = 1; i < n; i++)
            System.out.print(printTribRec(i)
                    + " ");
    }


    static int printTribRec(int n) {
        if (n == 0 || n == 1 || n == 2)
            return 0;
        if (n == 3)
            return 1;
        else
            return printTribRec(n - 1) +
                    printTribRec(n - 2) +
                    printTribRec(n - 3);
    }
}
