package AssociativeArraysExercises.OrderUsingObjectsAndClasses;

public class Product {
    public String name;
    public double price;

    @Override
    public String toString() {
        return " " + this.name + " -> " + String.format("%.2f", this.price) + " " + this.quantity;
        //plus new line нали очевидно
        //така ще принтираш само цената и грамажа, в другата задача изискват от теб да калкулираш цената
        //ползвайки листове
    }

    public int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
