package AssociativeArraysMoreExercises.readyToBeJustFinished;

public class Student {
    public String username;
    public int pointPerCurrentContest;
    public int totalPointFromAllContest;

    public Student(String username, int pointPerCurrentContest) {
        this.username = username;
        this.pointPerCurrentContest = pointPerCurrentContest;
        //i really do not know if this will be an efficient way of keeping score
        //of all the points from all the contest, but it doesn't hurt to try, right?
        //also if i have done it here, do i have to do it in other places as well
        this.totalPointFromAllContest += pointPerCurrentContest;
    }

    //Issues with the Current Approach:
    //totalPointFromAllContest Initialization:
    //
    //In the constructor, you're trying to accumulate the pointPerCurrentContest into totalPointFromAllContest. However, this variable is initialized to 0 by default. When you create a new Student object, totalPointFromAllContest will always be 0 at that moment, so adding pointPerCurrentContest to it in the constructor works correctly only once.
    //Accumulation Across Contests:
    //
    //If you create a new Student object for each contest, the totalPointFromAllContest will only reflect the points from the current contest because it's a new instance. Therefore, you won't be able to track the points across multiple contests effectively.
    //Object Re-creation:
    //
    //If you're re-creating Student objects for every contest, you'll lose track of the previous points, as each Student instance only reflects the state for a single contest.
    //Improved Approach:
    //To efficiently keep track of each student's total points across multiple contests, consider the following strategies:
    //
    //Persisting Student Objects:
    //
    //Instead of creating a new Student object for each contest, create and maintain a single Student object per student throughout the program's lifecycle. You can then update their totalPointFromAllContest as new contest results are processed.
    //Updating Points:
    //
    //Provide a method to update totalPointFromAllContest each time the student participates in a new contest.


    public int getTotalPointFromAllContest() {
        return totalPointFromAllContest;
    }

    public void setTotalPointFromAllContest(int totalPointFromAllContest) {
        this.totalPointFromAllContest = totalPointFromAllContest;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public int getPointPerCurrentContest() {
        return pointPerCurrentContest;
    }

    public void setPointPerCurrentContest(int pointPerCurrentContest) {
        this.pointPerCurrentContest = pointPerCurrentContest;
    }
}
