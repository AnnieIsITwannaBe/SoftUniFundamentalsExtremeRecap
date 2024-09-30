package ObjectsAndClassesExercises.ArticlesAnotherOne;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Article> articles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(", ");
            String title = tokens[0];
            String content = tokens[1];
            String author = tokens[2];

            Article article = new Article(title, content, author);
            articles.add(article);
        }

        //this is tottally btw and has zero impact on the output display at the end, therefore idk
        //maybe we can edit it to our preference
        String targetField = scanner.nextLine();
        printSelectedField(articles, targetField);
    }

    private static void printSelectedField(List<Article> articles, String targetField) {

        for (int i = 0; i < articles.size(); i++) {

            switch (targetField) {
                case "title":


                    break;
                case "content":

                    break;
                case "author":

                    break;
            }

        }
    }
}
