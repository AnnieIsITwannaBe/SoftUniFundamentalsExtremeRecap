package ObjectsAndClassesExercises.AdEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdvertisementMessageMain {
    //extol: praise enthusiastically
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfMessages = Integer.parseInt(scanner.nextLine());

        new ArrayList<>();

        List<String> phrases = List.of("Excellent product.", "Such a great product.",
                "I always use that product.", "Best product of its category.",
                "Exceptional product.", "I can’t live without this product.");

        List<String> events = List.of("Now I feel good.",
                "I have succeeded with this product.", "Makes miracles. " +
                        "I am happy of the results!", "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.", "I feel great!");

        List<String> authors =
                List.of("Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva");

        List<String> cities = List.of("Burgas", "Sofia", "Plovdiv", "Varna", "Ruse");

        while (numberOfMessages-- > 0) {
            //    List<Advertisement> allAdds = populateAddsList(phrases, events, authors, cities);

        }
    }

//    private static List<Advertisement> populateAddsList(List<String> phrases,
//                                                        List<String> events,
//                                                        List<String> authors,
//                                                        List<String> cities) {
//
//
//    }

}
