package MethodsExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String result;
        boolean isInbound;

        String input = scanner.nextLine();
        while (!input.equals("end")) {

            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {

                case "exchange":
                    int index = Integer.parseInt(tokens[1]);
                    isInbound = checkIndexValidity(index, array);
                    if (isInbound) {
                        result = handleExchangeAtGivenIndex(index, array);
                    } else {
                        result = "Invalid index";
                    }
                    break;

                case "max":
                    String numberTypeMax = tokens[1];
                    int maxNum = handleFindMaxNumOfGivenType(numberTypeMax, array);
                    result = String.valueOf(maxNum);
                    break;

                case "min":
                    String numberTypeMin = tokens[1];
                    int min = handleFindMinNumOfGivenType(numberTypeMin, array);
                    result = String.valueOf(min);

                    break;
                case "first":
                    String numberTypeFist = tokens[1];
                    int count = handleFindFirstTwoOfGivenType(numberTypeFist, array);
                    result = String.valueOf(count);

                    break;
                case "last":

                    break;
            }

            input = scanner.nextLine();
        }


    }

    private static int handleFindFirstTwoOfGivenType(String numberTypeFist, int[] array) {
        int count = 0;
        switch (numberTypeFist) {
            case "even":
                count = countFirstTwoEven(array);

                break;
            case "odd":
                count = countFirstTwoOdd(array);

                break;
        }


        return count;

    }

    private static int countFirstTwoOdd(int[] array) {


        return 0;
    }

    private static int countFirstTwoEven(int[] array) {


        return 0;
    }

    private static int handleFindMinNumOfGivenType(String numberType, int[] array) {

        return switch (numberType) {
            case "even" -> findMinEven(array);
            case "odd" -> findMinOdd(array);
            default -> 0;
        };
    }

    private static int findMinOdd(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int j : array) {
            if (j % 2 != 0) {
                if (j < min) {
                    min = j;
                }
            }

        }
        return min;
    }

    private static int findMinEven(int[] array) {

        int min = Integer.MAX_VALUE;
        for (int j : array) {
            if (j % 2 == 0) {
                if (j < min) {
                    min = j;
                }
            }

        }
        return min;

    }

    private static int handleFindMaxNumOfGivenType(String numberType, int[] array) {

        return switch (numberType) {
            case "even" -> findMaxEvenNum(array);
            case "odd" -> findMaxOdd(array);
            default -> 0;
        };
    }

    private static int findMaxOdd(int[] array) {

        int max = Integer.MIN_VALUE;
        for (int j : array) {
            if (j % 2 != 0) {
                if (j > max) {
                    max = j;
                }
            }
        }
        return max;
    }

    private static int findMaxEvenNum(int[] array) {
        int max = Integer.MIN_VALUE;

        for (int j : array) {
            if (j % 2 == 0) {
                if (j > max) {
                    max = j;
                }
            }
        }
        return max;
    }

    private static boolean checkIndexValidity(int index, int[] array) {
        return index >= array.length;
    }

    private static String handleExchangeAtGivenIndex(int index, int[] array) {
        StringBuilder sb = new StringBuilder();
        List<Integer> firstSubList = new ArrayList<>();
        List<Integer> secondSubList = new ArrayList<>();

        fillInFirst(index, array, firstSubList);
        fillInSecond(index, array, secondSubList);

        return String.valueOf(sb.append(listToString(secondSubList)).append(listToString(firstSubList)));
    }

    private static String listToString(List<?> list) {
        StringBuilder sb = new StringBuilder();
        for (Object o : list) {
            sb.append(o).append(" ");

        }
        return sb.toString();
    }

    private static void fillInSecond(int index, int[] array, List<Integer> secondSubList) {
        for (int i = index + 1; i < array.length - 1; i++) {
            secondSubList.add(array[i]);
        }
    }

    private static void fillInFirst(int index, int[] array, List<Integer> subList) {
        for (int i = 0; i < array.length; i++) {
            if (i <= index) {
                subList.add(array[i]);
            } else {
                break;
            }


        }
    }
}
