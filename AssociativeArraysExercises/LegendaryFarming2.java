//package AssociativeArraysExercises;
//
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Scanner;
//
//public class LegendaryFarming2 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String[] items = scanner.nextLine().split("\\s+");
//        int quantity = Integer.parseInt(items[0]);
//        String resource = items[1];
//
//        Map<String, Integer> resourceQuantity = new LinkedHashMap<>();
//        resourceQuantity.putIfAbsent(resource, quantity);
//        if (quantity == 250) {
//
//            printWinner(resource);
//        }else {
//            while ()
//        }
//    }
//
//    //•	"Shadowmourne" - requires 250 Shards
//    //•	"Valanyr" - requires 250 Fragments
//    //•	"Dragonwrath" - requires 250 Motes
//
//    private static void printWinner(String resource) {
//        switch (resource) {
//            case "shards":
//                System.out.println("Shadowmourne won");
//
//                break;
//            case "fragments":
//                System.out.println("Valanyr won");
//
//                break;
//            case "motes":
//                System.out.println("Dragonwrath won");
//
//                break;
//        }
//    }
//
//
