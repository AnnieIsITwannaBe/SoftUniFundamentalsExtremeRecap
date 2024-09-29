package ExamPreparation.second;

import java.util.Date;

public class Product {
    public String name;
    public Date date;
    public int calories;

    public Product(String name, Date date, int calories) {
        this.name = name;
        this.date = date;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
