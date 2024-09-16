package BasicSyntaxConditionalStatementsLoops;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());
        String result = "";
        Map<Integer, String> newHour = new HashMap<>();

        if (minutes + 30 > 59) {
            newHour = getTimeIn30Min(minutes, hour);

        } else {
            minutes += 30;
            result = hour + ":" + minutes;
        }

        printMapFormat(newHour);
        System.out.println(result);
    }

    private static void printMapFormat(Map<Integer, String> newHour) {
        for (Map.Entry<Integer, String> num : newHour.entrySet()) {
            int key = num.getKey();
            String value = num.getValue();
            System.out.println(key + ":" + value);
        }
    }

    private static Map<Integer, String> getTimeIn30Min(int minutes, int hour) {
        Map<Integer, String> hourAndMinutes = new HashMap<>();
        int minutesLeftToHour = 60 - minutes;
        int newMinutes = 30 - minutesLeftToHour;
        String min = String.valueOf(newMinutes);
        if (min.length() == 1) {
            min = "0" + min;
        }
        int newHour = 0;

        if (hour != 23) {
            newHour = hour + 1;
        }

        hourAndMinutes.put(newHour, min);


        return hourAndMinutes;
    }
}
