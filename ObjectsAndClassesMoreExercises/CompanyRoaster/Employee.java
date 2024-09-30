package ObjectsAndClassesMoreExercises.CompanyRoaster;

public class Employee {
    //name, salary, position, department, email, and age.
    // The name, salary, position, and department are mandatory while the rest are optional.
    String name;
    double salary;
    String position;
    String departmentName;
    String email;
    int age;

    //think about what does it mean for a field to be mandatory
    //think about how to invoke a constructor from another constructor
    //there was this rule that you should always call from the one with the more arguments
    //withing it's scope the one with less arguments in it's scope

    public Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.departmentName = position;
    }

    //(name, salary, position, department, age
    public Employee(String name, double salary, String position, String department, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.departmentName = department;
        this.age = age;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Employee(String name, double salary, String position, String department, String email) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.departmentName = department;
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.departmentName = department;
        this.email = email;
        this.age = age;
    }


}
