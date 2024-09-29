package ExamPreparation.RandomizedJudge.FinalExamApril2020New;

public class Town {
    public String town;
    public int population;
    public int gold;

    public Town(String town, int population, int gold) {
        this.town = town;
        this.population = population;
        this.gold = gold;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}