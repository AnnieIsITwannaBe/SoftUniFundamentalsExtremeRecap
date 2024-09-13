package ArraysExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zig_ZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String[] array1 = new String[n];
        String[] array2 = new String[n];

        populateArrays(n, scanner, array1, array2);

        List<String> first = getZigZagMergedArrayFirst(array1, array2);
        List<String> second = getZigZagMergedArraySecond(array1, array2);

        printFormat(first);
        printFormat(second);
    }

    private static List<String> getZigZagMergedArraySecond(String[] array1, String[] array2) {
        List<String> merged = new ArrayList<>();
        int indexArr1 = 1;
        int indexArr2 = 0;
        while (indexArr1 < array1.length || indexArr2 < array2.length) {
            merged.add(array1[indexArr1]);
            merged.add(array2[indexArr2]);
            indexArr1 += 2;
            indexArr2 += 2;
        }

        return merged;
    }

    private static void printFormat(List<String> merged) {
        System.out.println(String.join(",", merged));
    }

    private static List<String> getZigZagMergedArrayFirst(String[] array1, String[] array2) {
        int arr1Index = 0;
        int arr2Index = 1;
        List<String> merged1 = new ArrayList<>();
        while (arr1Index < array1.length || array2.length > arr2Index) {
            merged1.add(array1[arr1Index]);
            merged1.add(array2[arr2Index]);
            arr1Index += 2;
            arr2Index += 2;
        }
        return merged1;
    }

//    private static void getZigZagMergedArray(String[] array1, String[] array2) {
//        List<String> merged1 = new ArrayList<>();
//        for (int i = 0; i < array1.length; i += 2) {
//            merged1.add(array1[i]);
//            for (int j = 1; j <= array2.length; j++) {
//                merged1.add(array2[j]);
//
//            }
//        }
//    }

    private static void populateArrays(int n, Scanner scanner, String[] array1, String[] array2) {
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String num1 = tokens[0];
            String num2 = tokens[1];

            array1[i] = num1;
            array2[i] = num2;
        }
    }
}
