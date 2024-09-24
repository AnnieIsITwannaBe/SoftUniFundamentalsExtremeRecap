package MethodsLaB;

import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String variableType = scanner.nextLine();
        String valueA = scanner.nextLine();
        String valueB = scanner.nextLine();
        String result = " ";

        switch (variableType) {
            case "int":
                int intA = Integer.parseInt(valueA);
                int intB = Integer.parseInt(valueB);
                result = String.valueOf(getMax(intA, intB));
                break;
            case "char":
                char charA = valueA.charAt(0);
                char charB = valueB.charAt(0);
                result = String.valueOf(getMax(charA, charB));
                break;
            default:
                result = getMax(valueA, valueB);
        }

        printFormat(result);


    }

    private static void printFormat(String result) {
        System.out.println(result);
    }

    private static String getMax(String a, String b) {
        if (a.length() > b.length()) {
            return a;
        } else {
            return b;
        }
    }

    private static char getMax(char a, char b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }

    }
    //this is comparison by the ASCI values using normal math operations

    private static int getMax(int a, int b) {
        return Math.max(a, b);
    }
}
