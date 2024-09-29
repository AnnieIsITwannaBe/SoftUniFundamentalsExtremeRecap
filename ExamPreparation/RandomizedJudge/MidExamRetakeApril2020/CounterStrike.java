package ExamPreparation.RandomizedJudge.MidExamRetakeApril2020;

import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initialCapacity = Integer.parseInt(scanner.nextLine());

        int wonBattles = 0;
        String line = scanner.nextLine();
        while (!line.equals("end of game")){
            int distance = Integer.parseInt(line);
            initialCapacity -= distance;
            wonBattles++;

            if(initialCapacity == 0){
                System.out.printf("Not enough energy, u end game with %d won battles.", wonBattles);
                break;
            }
            line = scanner.nextLine();
        }

        System.out.printf("won game with %d", wonBattles);

    }
}
