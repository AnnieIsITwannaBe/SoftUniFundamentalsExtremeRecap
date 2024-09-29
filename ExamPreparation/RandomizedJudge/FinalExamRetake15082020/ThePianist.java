package ExamPreparation.RandomizedJudge.FinalExamRetake15082020;

import java.util.*;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        Map<String, List<Composition>> musicCompositions = new LinkedHashMap<>();

        while (!line.equals("Stop")) {

            String[] tokens = line.split("\\|");
            String command = tokens[0];

            switch (command) {
                case "Add":
                    handleAddition(tokens, musicCompositions);
                    break;

                case "Remove":
                    handleRemoval(tokens, musicCompositions);

                    break;
                case "ChangeKey":
                    handleChangeKey(tokens, musicCompositions);

                    break;
            }
            line = scanner.nextLine();
        }
    }

    private static void handleChangeKey(String[] tokens, Map<String, List<Composition>> musicCompositions) {
        String piece = tokens[1];
        String newKey = tokens[2];

        for (Map.Entry<String, List<Composition>> entry : musicCompositions.entrySet()) {
            List<Composition> compositions = entry.getValue();
            Composition targetComposition = compositions.stream().filter(composition -> composition.getPiece().equals(piece)).findFirst().orElse(null);

            assert targetComposition != null;
            targetComposition.setKey(newKey);
        }
    }

    private static void handleRemoval(String[] tokens, Map<String, List<Composition>> musicCompositions) {
        String pieceToBeRemoved = tokens[1];
        String keyToBeRemovedBy = " ";
        boolean encountered = false;

        //how can I achieve this with string api:
        //и това ще е валидно според начина по който в действителност трябва да се реши задачата
        //но начина по който ние трява да я решим, за да отговаря на персонализираното ни
        //според нас по-добро условие е друг:
        //само премахваме the piece от списъка с композиции и не трием самия композитор,
        //защото може да има други песни
        //ако няма, може да го изтрием
//        for (Map.Entry<String, List<Composition>> entry : musicCompositions.entrySet()) {
//            String key = entry.getKey();
//            List<Composition> value = entry.getValue();
//            for (Composition composition : value) {
//                if (composition.getPiece().equals(pieceToBeRemoved)) {
//                    keyToBeRemovedBy = key;
//                    encountered = true;
//                    break;
//                }
//            }
//        }
//        if (encountered) {
//            musicCompositions.remove(keyToBeRemovedBy);
//        }

        for (Map.Entry<String, List<Composition>> entry : musicCompositions.entrySet()) {
            List<Composition> compositions = entry.getValue();


            Composition targetComposition = compositions.stream().filter(composition -> composition.getPiece().equals(pieceToBeRemoved)).findFirst().orElse(null);

            assert targetComposition != null;
            compositions.remove(targetComposition);

            String key = entry.getKey();
            if (compositions.isEmpty()) {
                musicCompositions.remove(key);
            }
        }
    }

    private static void handleAddition(String[] tokens, Map<String, List<Composition>> musicCompositions) {
        String piece = tokens[1];
        String composer = tokens[2];
        String key = tokens[3];

        Composition composition = new Composition(piece, key);

        musicCompositions.putIfAbsent(composer, new ArrayList<>());
        List<Composition> compositionsUpdated = musicCompositions.get(piece);
        compositionsUpdated.add(composition);
        musicCompositions.put(composer, compositionsUpdated);
    }
}
