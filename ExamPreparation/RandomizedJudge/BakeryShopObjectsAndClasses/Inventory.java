package ExamPreparation.RandomizedJudge.BakeryShopObjectsAndClasses;

public class Inventory {
    public String food;
    public int quantity;

    public Inventory(String food, int quantity) {
        this.food = food;
        this.quantity = quantity;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
