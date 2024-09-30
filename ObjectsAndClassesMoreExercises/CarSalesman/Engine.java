package ObjectsAndClassesMoreExercises.CarSalesman;

public class Engine {
    //An Engine has a model, power, displacement, and efficiency.
    //its Engine’s displacements and efficiency are optional
    String model;
    int power;
    int displacement;
    int efficiency;

    // you really need to read some more about how the things work with the constructor chaining
    // constructor chaining is the process of calling one constructor in the body of another
    //with respect to current object
    //one of the main uses of constructor chaining is to avoid duplicate code
    //by having multiple constructors, utilizing constructor chaining
    public Engine(String model, int power, int displacement, int efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }
    //special method that is used to initialize objects
    // a constructor is called when an instance of a class is being created
    // at the time of calling the constructor memory for the object is allocated in the memory
    //everytime an object is created using the new() key word at least one constructor is called

    public Engine(String model, int power, int displacement) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
    }

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;

    }
}
