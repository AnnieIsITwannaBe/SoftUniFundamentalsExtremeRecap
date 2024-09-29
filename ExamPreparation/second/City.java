package ExamPreparation.second;

public class City {
    public String city;
    public int population;
    public int gold;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public City(String city, int population, int gold) {
        this.city = city;
        this.population = population;
        this.gold = gold;
    }
}
