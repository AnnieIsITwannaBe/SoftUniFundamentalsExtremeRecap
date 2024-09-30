package ObjectsAndClasses;

import java.util.*;

public class RandomizeJavaWords {
    public static void main(String[] args) {
        // learn about threads, multithreading, thread-safety
        //what is seed, wht does it mean to use something as a seed
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+")).toList();

        Random randomizer = new Random();

        int length = input.size();

        //nextInt(int bound): Generates a pseudorandom integer between 0 (inclusive) and bound (exclusive).
        int i = randomizer.nextInt(length + 1); //because the bound is exclsuive
        List<String> currentRandomSequence = new ArrayList<>();

        while (!(currentRandomSequence.size() == input.size())) {
            currentRandomSequence = getRandomElement(input, i);

        }


    }

    private static List<String> getRandomElement(List<String> input, int i) {
        List<String> randomizedOrder = new ArrayList<>();
        randomizedOrder.add(input.get(i));
        input.remove(i);

        return randomizedOrder;
    }
}
