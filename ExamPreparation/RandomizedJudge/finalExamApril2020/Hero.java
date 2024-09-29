package ExamPreparation.RandomizedJudge.finalExamApril2020;

public class Hero {
    public String name;
    public int HP;
    public int MP;


    public Hero(String name, int HP, int MP) {
        this.name = name;
        this.HP = HP;
        this.MP = MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public int getMP() {
        return MP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }
}
