package ExamPreparation.RandomizedJudge;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();


        String line = scanner.nextLine();
        while (!line.equals("Register")) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Letters":
                    username = handleLetters(tokens, username);
                    break;

                case "Reverse":
                    username = handleReverse(tokens, username);
                    break;

                case "Substring":
                    String targetSubstring = tokens[1];
                    username = handleSubstring(username, targetSubstring);

                    break;

                case "Replace":
                    username = handleReplaceAll(tokens, username);
                    break;

                case "isValid":
                    handleIsValid(tokens, username);

                    break;
            }

            line = scanner.nextLine();
        }
    }

    private static void handleIsValid(String[] tokens, String username) {
        String obligatorySymbol = tokens[1];

        boolean isValid = username.contains(obligatorySymbol);

        if (isValid) {
            System.out.println("Yes, it's valid");
        } else {
            System.out.println("Not valid");
        }
    }

    private static String handleReplaceAll(String[] tokens, String username) {
        String symbol = tokens[1];

        username = username.replaceAll(symbol, "-");
        return username;
    }

    private static String handleSubstring(String username, String targetSubstring) {
        if (username.contains(targetSubstring)) {
            int startIndex = username.indexOf(targetSubstring);

            String before = username.substring(0, startIndex);
            String after = username.substring(startIndex + targetSubstring.length());

            username = before + after;
        }
        return username;
    }

    private static String handleReverse(String[] tokens, String username) {
        int startIndex = Integer.parseInt(tokens[1]);
        int endIndex = Integer.parseInt(tokens[2]);

        //because we want to include the end index, we do not want it to be exclusive
        String before = username.substring(0, startIndex);
        String toBeReversed = username.substring(startIndex, endIndex + 1);

        StringBuilder reverse = new StringBuilder();
        reverse.append(toBeReversed).reverse();
        String reversed = reverse.toString();

        String after = username.substring(endIndex + 2);

        username = before + reversed + after;

        return username;
    }

    private static String handleLetters(String[] tokens, String username) {
        String caseSensitivityMarker = tokens[1];
        if (caseSensitivityMarker.equals("Upper")) {
            username = username.toUpperCase();
        } else {
            username = username.toLowerCase();
        }
        return username;
    }
}

//Your code is well-written and closely follows the problem's requirements. Here’s a detailed breakdown and rating of your code:
//
//### **1. Code Structure and Organization (4.5/5)**
//- **Pros:**
//  - The code is modular, with each command having its own dedicated method. This makes it easy to read, understand, and maintain.
//  - Good use of descriptive method names that clearly indicate the purpose of each method (`handleLetters`, `handleReverse`, etc.).
//  - The main loop is clean, with the `switch` statement clearly directing the flow of the program based on the command.
//
//- **Cons:**
//  - Some minor redundancy in method naming (`handleReplaceAll` could just be `handleReplace` as per the problem statement).
//
//### **2. Code Efficiency (4/5)**
//- **Pros:**
//  - The code is efficient for the problem's scope. String manipulations are handled well without unnecessary complexity.
//  - The use of `StringBuilder` in the `handleReverse` method is a good choice for reversing the substring efficiently.
//
//- **Cons:**
//  - In the `handleSubstring` method, when removing the substring, the `substring()` method is called twice (once for `before` and once for `after`). This could be optimized by using one call if necessary.
//  - The program reassigns the `username` variable multiple times, which is fine for this problem's scope but could be slightly optimized to minimize unnecessary reassignments.
//
//### **3. Error Handling (3.5/5)**
//- **Pros:**
//  - The `handleReverse` method mentions that it checks for valid indices, which is good.
//
//- **Cons:**
//  - The actual index validation in `handleReverse` is missing. If the indices are out of bounds, the program should skip the command, but this is not implemented. Adding this validation would prevent potential `StringIndexOutOfBoundsException`.
//  - The code assumes the input is always correctly formatted (e.g., valid commands and parameters). If this is guaranteed by the problem statement, it's fine, but otherwise, some input validation would be helpful.
//
//### **4. Readability and Maintainability (4.5/5)**
//- **Pros:**
//  - The code is very readable. The methods are concise, and the logic is straightforward.
//  - Use of descriptive variable names and comments helps in understanding the purpose of each section.
//  - Good use of early returns in methods like `handleSubstring`, making it clear when the method is complete.
//
//- **Cons:**
//  - The comment in the `handleReverse` method about the end index being inclusive is helpful but could be more explicit in checking bounds and explaining what happens if the indices are out of range.
//
//### **5. Correctness and Functionality (4/5)**
//- **Pros:**
//  - The code seems to correctly implement the required functionality for each command.
//  - It handles string manipulations like uppercase/lowercase conversion, substring removal, and character replacement effectively.
//
//- **Cons:**
//  - As mentioned, the index validation in `handleReverse` is not fully implemented. Without this, the code may produce unexpected results if the user inputs invalid indices.
//  - The `handleIsValid` method returns `"Yes, it's valid"` instead of `"Valid username."`, which is a minor inconsistency with the problem description.
//
//### **Overall Rating: 4.1/5**
//
//**Summary:** Your code is well-structured and generally efficient, with good readability and adherence to the problem's requirements. The primary areas for improvement are error handling, particularly in index validation for the `Reverse` command, and ensuring consistent output messages as per the problem description. Fixing these issues would make the code more robust and aligned with the problem's expectations.
