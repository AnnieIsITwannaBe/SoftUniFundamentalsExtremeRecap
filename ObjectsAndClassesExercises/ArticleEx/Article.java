package ObjectsAndClassesExercises.ArticleEx;

import javax.xml.transform.sax.SAXResult;

public class Article {
    String title;
    String content;
    String author;

    public Article(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    //The class should have a constructor and the following methods:
    //•	Edit (new content) – change the old content with the new one
    //•	ChangeAuthor (new author) – change the author
    //•	Rename (new title) – change the title of the article
    //•	override ToString – print the article in the following format:
    //"{title} - {content}:{author}"

    public void edit(String content) {
        this.content = content;
    }

    public void changeAuthor(String author) {
        this.author = author;
    }

    public void rename(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title + " - " + this.content + ":" + this.author;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return this.title;
    }
}
