package AssociativeArraysMoreExercises.начиИтакаНеСтаваПУУУУУУУУУУУ;

import java.util.LinkedHashMap;
import java.util.Map;

public class Player {
    public String name;
    public Map<String, Integer> skillPerPosition;

    public Player(String name) {
        this.name = name;
        this.skillPerPosition = new LinkedHashMap<>();
    }

    //When you receive a player and his position and skill,
    // add him to the player pool, if he isn't present, else add his position and skill or update his skill,
    // only if the current position skill is lower than the new value.
    public void addOrUpdatePosition(String position, int skill) {
        // Check if the position already exists
        if (this.skillPerPosition.containsKey(position)) {
            // Update the skill only if the new skill is higher
            if (this.skillPerPosition.get(position) < skill) {
                this.skillPerPosition.put(position, skill);
            }
        } else {
            // Add the new position and skill
            this.skillPerPosition.put(position, skill);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getSkillPerPosition() {
        return skillPerPosition;
    }

    public void setSkillPerPosition(Map<String, Integer> skillPerPosition) {
        this.skillPerPosition = skillPerPosition;
    }
}
