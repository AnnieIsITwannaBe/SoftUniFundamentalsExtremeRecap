package AssociativeArraysExercises;

public class Student {
    public String name;

    public String language;

    public int score;

    public Student(String name, String language, int score) {
        this.name = name;
        this.language = language;
        this.score = score;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
