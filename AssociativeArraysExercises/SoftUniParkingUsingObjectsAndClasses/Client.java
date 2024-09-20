package AssociativeArraysExercises.SoftUniParkingUsingObjectsAndClasses;

public class Client {
    public String name;
    public String carModel;

    @Override
    public String toString() {
        return STR."\{this.name} ->\{this.carModel}";
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Client(String name, String carModel) {
        this.name = name;
        this.carModel = carModel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
