package ExamPreparation.RandomizedJudge.FinalExamApril2020New;

import java.util.Scanner;

public class ActivationKeys {
    private static final String DOES_CONTAIN_SUBSTRING_OUTPUT_MESSAGE = "%s contains %s.";

    private static final String SUBSTRING_NOT_FOUND_OUTPUT_MESSAGE = "Substring not found!";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rawActivationKey = scanner.nextLine();
        String line = scanner.nextLine();

        while (!line.equals("Generate")) {
            String[] tokens = line.split("<<<");
            String command = tokens[0];

            switch (command) {
                case "Contains":
                    handleContains(tokens, rawActivationKey);
                    break;
                case "Flip":
                    rawActivationKey = handleFlip(tokens, rawActivationKey);


                    break;
                case "Slice":
                    rawActivationKey = handleSlice(tokens, rawActivationKey);

                    break;
            }
            line = scanner.nextLine();
        }
    }

    private static String handleSlice(String[] tokens, String rawActivationKey) {
        int startIndex = Integer.parseInt(tokens[1]);
        int endIndex = Integer.parseInt(tokens[2]);

        //but here what will happen if the start index is 0?
        String before = rawActivationKey.substring(0, startIndex);
        String after = rawActivationKey.substring(endIndex + 1);

        rawActivationKey = before + after;
        return rawActivationKey;
    }

    private static void handleContains(String[] tokens, String rawActivationKey) {
        String substring = tokens[1];
        if (contains(rawActivationKey, substring)) {
            System.out.printf(DOES_CONTAIN_SUBSTRING_OUTPUT_MESSAGE, rawActivationKey, substring);
        } else {
            System.out.printf(SUBSTRING_NOT_FOUND_OUTPUT_MESSAGE);
        }
    }

    private static String handleFlip(String[] tokens, String rawActivationKey) {
        //i have this little curling sense in my stomach that this will cause some problems
        String caseSensitivity = tokens[1];
        int startIndex = Integer.parseInt(tokens[2]);
        int endIndex = Integer.parseInt(tokens[3]);

        String toBeModified = rawActivationKey.substring(startIndex, endIndex);
        boolean isUppercase = caseSensitivity.equals("Upper");

        if (isUppercase) {
            toBeModified = toBeModified.toUpperCase();
        } else {
            toBeModified = toBeModified.toLowerCase();
        }

        String restOfActivationKey = rawActivationKey.substring(endIndex + 1);

        String before = rawActivationKey.substring(0, startIndex);

        //so that we ¶don't repeat the first letter if the index is 0:
        if (startIndex != 0) {
            rawActivationKey = before + toBeModified + restOfActivationKey;
        } else {
            rawActivationKey = toBeModified + restOfActivationKey;
        }
        return rawActivationKey;
    }

    private static boolean contains(String rawActivationKey, String substring) {
        return rawActivationKey.contains(substring);
    }
}
