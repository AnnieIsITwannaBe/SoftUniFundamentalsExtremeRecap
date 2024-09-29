package ExamPreparation.first;

public class Hero {
    public String name;
    public int MP;
    public int HP;

    @Override
    public String toString() {
        return String.format("%s\n HP: %d\n MP: %d", this.name, this.MP, this.HP);
    }

    public Hero(String name, int MP, int HP) {
        this.name = name;
        this.MP = MP;
        this.HP = HP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMP() {
        return MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }
}
