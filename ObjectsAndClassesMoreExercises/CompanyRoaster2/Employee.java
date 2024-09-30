package ObjectsAndClassesMoreExercises.CompanyRoaster2;

public class Employee {
    String name;
    double salary;
    String department;
    String position;
    String email;
    int age;

    //learn about constructor chaining when you get home
    public Employee() {
    }

    public Employee(String name, double salary, String department, String position, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.position = position;
        this.email = email;
        this.age = age;
    }

    public Employee(String name, double salary, String department, String position, String email) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.position = position;
        this.email = email;
    }

    public Employee(String name, double salary, String department, String position, int age) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.position = position;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employee(String name, double salary, String department, String position) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.position = position;
    }


}
