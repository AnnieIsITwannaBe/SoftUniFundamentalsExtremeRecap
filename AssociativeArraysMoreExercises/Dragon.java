package AssociativeArraysMoreExercises;

public class Dragon {
    public String name;
    public int damage;
    public int health;
    public int armor;

    public Dragon(String name, int damage, int health, int armor) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.armor = armor;
    }

    //"-{Name} -> damage: {damage}, health: {health}, armor: {armor}"
    @Override
    public String toString() {
        return STR."\{this.name}-> damage: \{this.damage},  health:\{this.health}, armor: \{this.armor}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}
