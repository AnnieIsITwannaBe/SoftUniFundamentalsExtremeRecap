package AssociativeArraysMoreExercises.AnnieCameUpWithSomeIdea;

public class Student {
    public String username;

    public String contest;
    public int points;

    public String getContest() {
        return contest;
    }

    public void setContest(String contest) {
        this.contest = contest;
    }

    public Student(String username, String contest, int points) {
        this.username = username;
        this.contest = contest;
        this.points = points;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
