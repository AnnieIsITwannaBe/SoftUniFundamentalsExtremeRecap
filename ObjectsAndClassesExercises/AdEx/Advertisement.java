package ObjectsAndClassesExercises.AdEx;

public class Advertisement {
    String phrase;
    String event;
    String author;
    String city;

    public Advertisement(String phrase, String event, String author, String city) {
        this.phrase = phrase;
        this.event = event;
        this.author = author;
        this.city = city;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhrase() {
        return this.phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    @Override
    public String toString() {
        return this.phrase + " " + this.event + " " + this.author + "-" + this.city + ".";
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
