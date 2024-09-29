package ExamPreparation.RandomizedJudge.finalExamApril2020;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    private static final String VALID = "Product group: %s";

    private static final String INVALID = "Invalid barcode";

    private static final String DEFAULT = "00";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String barcodeCandidate = scanner.nextLine();

            Pattern pattern = Pattern.compile("/@#+(?<nonSpecialSymbolls>[A-Z][A-Za-z0-9]+[A-Z])@#+");

            Matcher matcher = pattern.matcher(barcodeCandidate);

            boolean isValid = false;

            if (matcher.find()) {
                //excluding the @# symbols that must not be included in the obligatory 6 symbols requirement
                String nonSpecialSymbols = matcher.group("nonSpecialSymbols");
                if (nonSpecialSymbols.length() >= 6) {
                    isValid = true;
                }

                StringBuilder digitsGroupConcatenated = new StringBuilder();
                boolean hasDigits = false;
                if (isValid) {
                    char[] charArray = nonSpecialSymbols.toCharArray();
                    for (char c : charArray) {
                        if (Character.isDigit(c)) {
                            hasDigits = true;
                            digitsGroupConcatenated.append(c);
                        }
                    }
                    if (hasDigits) {
                        System.out.printf(VALID, digitsGroupConcatenated);
                    } else {
                        System.out.printf(VALID, DEFAULT);
                    }
                } else {
                    System.out.println(INVALID);
                }
            }
        }
    }
}
//if matched and nonSpecialSymbols are eligible, then add it to valid barcodes:
//                if (isValid) {
//                    validBarcodes.add(matcher.group());
//                }