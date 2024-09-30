package ObjectsAndClasses.definingSimpleClasses.Songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSongs = readUserInput(scanner);

        List<Song> allSongs = populateUserPlayList(numberOfSongs, scanner);

        String typeListPreference = scanner.nextLine();

        List<String> songsNames = handleRoutingLogic(allSongs, typeListPreference);

        printOutput(songsNames);

    }

    private static void printOutput(List<String> songsNames) {
        System.out.println(listToString(songsNames));
    }

    private static String listToString(List<?> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object o : list) {
            stringBuilder.append(o);
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    private static List<String> handleRoutingLogic(List<Song> allSongs, String typeListPreference) {
        List<String> selectedSongs = new ArrayList<>();

        //make a research on whether it makes any difference not use the get
        for (Song currentSong : allSongs) {
            if (currentSong.getTypeList().equals(typeListPreference) || typeListPreference.equals("all")) {
                selectedSongs.add(currentSong.getName());
            }
        }

        return selectedSongs;
    }

    private static List<Song> populateUserPlayList(int numberOfSongs, Scanner scanner) {
        List<Song> allSongs = new ArrayList<>();

        for (int i = 0; i < numberOfSongs; i++) {
            String[] tokens = scanner.nextLine().split("_");
            String listType = tokens[0];
            String name = tokens[1];
            String time = tokens[2];

            Song song = new Song(listType, name, time);
            allSongs.add(song);
        }

        return allSongs;
    }

    private static int readUserInput(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }
}
