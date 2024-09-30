package ObjectsAndClassesExercises.OrderByAge;

public class Person {
    String name;
    String id;
    int age;

    //Stephan with ID: 524244 is 10 years old
    @Override
    public String toString() {
        return this.name + " with ID: " + this.id + " is " + this.age + " years old";
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(String name) {
        return this.name;
    }


}
