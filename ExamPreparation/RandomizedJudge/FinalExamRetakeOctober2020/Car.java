package ExamPreparation.RandomizedJudge.FinalExamRetakeOctober2020;

public class Car {
    public String carName;
    public int mileage;
    public int fuel;

    public Car(String car, int mileage, int fuel) {
        this.carName = car;
        this.mileage = mileage;
        this.fuel = fuel;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }
}
