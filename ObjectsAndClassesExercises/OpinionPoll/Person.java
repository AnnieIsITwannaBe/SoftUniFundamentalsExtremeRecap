package ObjectsAndClassesExercises.OpinionPoll;

public class Person {
    String name;
    int age;

    @Override
    public String toString() {
        return this.name + " - " + this.age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
