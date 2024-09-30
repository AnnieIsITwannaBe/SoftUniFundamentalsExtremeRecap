package ObjectsAndClassesExercises.ArticleEx;

import ObjectsAndClassesExercises.ArticleEx.Article;

import java.util.Scanner;

public class ArticlesMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Article article = getArticle(scanner);

        int n = Integer.parseInt(scanner.nextLine());

        handleArticleModification(n, scanner, article);

        printOutput(article);
    }

    private static void printOutput(Article article) {
        System.out.println(article.toString());
    }

    private static void handleArticleModification(int n, Scanner scanner, Article article) {
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(":");
            String command = tokens[0];
            String replacement = tokens[1];

            switch (command) {
                case "Edit":
                    article.edit(replacement);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(replacement);
                    break;
                case "Rename":
                    article.rename(replacement);
                    break;
            }
        }
    }

    //what could be wrong hm
    private static Article getArticle(Scanner scanner) {
        String[] tokens = scanner.nextLine().split(", ");
        String title = tokens[0];
        String content = tokens[1];
        String author = tokens[2];
        return new Article(title, content, author);
    }
}
