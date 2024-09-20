package AssociativeArraysMoreExercises.ThisMobaMightBeForTheBin;

public class Player {
    public String name;
    public String position;
    public int skill;

    public Player(String name, String position, int skill) {
        this.name = name;
        this.position = position;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }
}
