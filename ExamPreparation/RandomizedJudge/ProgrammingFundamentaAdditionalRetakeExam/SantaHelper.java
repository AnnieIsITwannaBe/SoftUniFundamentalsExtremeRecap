package ExamPreparation.RandomizedJudge.ProgrammingFundamentaAdditionalRetakeExam;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantaHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decryptionKey = Integer.parseInt(scanner.nextLine());

        List<String> goodChildren = filterGoodChildrenOnly(scanner, decryptionKey);

        handlePrintingOutput(goodChildren);
    }

    private static void handlePrintingOutput(List<String> goodChildren) {
        goodChildren.forEach(kid -> System.out.printf("%s\n", kid));
    }

    private static List<String> filterGoodChildrenOnly(Scanner scanner, int key) {
        List<String> goodChildren = new LinkedList<>();
        String line = scanner.nextLine();
        while (!line.equals("end")) {
            String toBeDecrypted = line;

            String decrypted = decrypt(toBeDecrypted, key);

            addToListIfGood(decrypted, goodChildren);

            line = scanner.nextLine();
        }
        return goodChildren;
    }

    private static void addToListIfGood(String decrypted, List<String> goodChildren) {
        Pattern pattern = Pattern.compile("(?<childName>[A-Z][a-z]+)[^@,\\-!:>]+(!)(?<behaviouralType>[GN])\\2");

        Matcher matcher = pattern.matcher(decrypted);

        if (matcher.find()) {
            String name = matcher.group("childName");
            String behaviouralType = matcher.group("behaviouralType");
            if (behaviouralType.equals("G")) {
                goodChildren.add(name);
            }
        }
    }

    private static String decrypt(String toBeDecrypted, int key) {
        char[] charArray = toBeDecrypted.toCharArray();
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] -= (char) key;
            decrypted.append(charArray[i]);
        }
        return decrypted.toString();
    }
}
