package ObjectsAndClassesExercises.VehicleCatalouge;

public class Vehicle {

    String vehicleType;
    String model;
    String color;
    double horsePower;

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Type: " + this.getVehicleType() +
                System.lineSeparator() +
                "Model: " + this.getModel() +
                System.lineSeparator() +
                "Color: " + this.getColor() +
                System.lineSeparator() +
                "Horsepower: " + String.format("%.2f", this.getHorsePower());
    }


    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(double horsePower) {
        this.horsePower = horsePower;
    }

    public Vehicle(String vehicleType, String model, String color, double horsePower) {
        this.vehicleType = vehicleType;
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
    }

    public String getVehicleType() {
        return this.vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

}
