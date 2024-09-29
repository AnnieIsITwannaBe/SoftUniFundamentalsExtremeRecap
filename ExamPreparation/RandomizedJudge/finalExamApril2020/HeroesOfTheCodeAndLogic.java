package ExamPreparation.RandomizedJudge.finalExamApril2020;

import javax.swing.text.TabExpander;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HeroesOfTheCodeAndLogic {
    private static final String CAST_SPELL_SUCCESSFULLY = "%s has successfully cast %s and now has %d MP!";

    private static final String CAST_SPELL_UNAVAILABLE = "%s does not have enough MP to cast %s!";

    private static final String TOOK_DAMAGE_BUT_LIVES = "%s was hit for %d HP by %s and now has %d HP left!";

    private static final String TOOK_DAMAGE_IS_NOW_DEAD = "%s has been killed by %s!";

    private static final int MAX_AMOUNT_MANA_POINTS = 200;

    private static final String RECHARGED = "%s recharged for %d MP!";

    private static final int MAX_AMOUNT_HP_POINTS = 100;

    private static final String HEALED = "%s healed for %d HP!";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Hero> heroList = addHeroesToList(n, scanner);

        String userInput = scanner.nextLine();

        handleGameProcess(userInput, heroList, scanner);

        displaySurvivors(heroList);
    }

    private static void displaySurvivors(List<Hero> heroList) {
        heroList.forEach(hero -> System.out.printf("%s\nMP: %d\nHP: %d\n", hero.getName(), hero.getMP(), hero.getMP()));
    }

    private static void handleGameProcess(String userInput, List<Hero> heroList, Scanner scanner) {
        while (!userInput.equals("End")) {
            String[] tokens = userInput.split("\\s+-\\s+");
            String command = tokens[0];

            switch (command) {
                case "CastSpell":
                    handleCastSpell(tokens, heroList);
                    break;

                case "TakeDamage":
                    handleTakeDamage(tokens, heroList);
                    break;

                case "Recharge":
                    handleRecharge(tokens, heroList);

                    break;
                case "Heal":
                    handleHealing(tokens, heroList);
                    break;
            }
            userInput = scanner.nextLine();
        }
    }

    private static void handleHealing(String[] tokens, List<Hero> heroList) {
        String name = tokens[1];
        int HPtoAdd = Integer.parseInt(tokens[2]);

        Hero selectedHero = getSelectedHero(heroList, name);
        assert selectedHero != null;
        int temp = selectedHero.getHP();

        selectedHero.setHP(selectedHero.getHP() + HPtoAdd);
        if (selectedHero.getHP() > MAX_AMOUNT_HP_POINTS) {
            //to get the actual points that need to be utilized fo healing:
            HPtoAdd = MAX_AMOUNT_HP_POINTS - temp;
            selectedHero.setHP(MAX_AMOUNT_HP_POINTS);
        }
        System.out.printf(HEALED, name, HPtoAdd);
    }

    private static void handleRecharge(String[] tokens, List<Hero> heroList) {
        String name = tokens[1];
        int MPtoAdd = Integer.parseInt(tokens[2]);

        Hero selectedHero = getSelectedHero(heroList, name);
        assert selectedHero != null;

        int temp = selectedHero.getMP();
        selectedHero.setMP(selectedHero.getMP() + MPtoAdd);
        if (selectedHero.getMP() > MAX_AMOUNT_MANA_POINTS) {
            MPtoAdd = MAX_AMOUNT_MANA_POINTS - temp;
            selectedHero.setMP(MAX_AMOUNT_MANA_POINTS);
        }
        System.out.printf(RECHARGED, name, MPtoAdd);
    }

    private static void handleTakeDamage(String[] tokens, List<Hero> heroList) {
        String name = tokens[1];
        int damage = Integer.parseInt(tokens[2]);
        String attacker = tokens[3];

        Hero selectedHero = getSelectedHero(heroList, name);

        assert selectedHero != null;

        selectedHero.setHP(selectedHero.getHP() - damage);
        if (selectedHero.getHP() > 0) {
            System.out.printf(TOOK_DAMAGE_BUT_LIVES, name, damage, attacker, selectedHero.getHP());
        } else {
            heroList.remove(selectedHero);
            System.out.printf(TOOK_DAMAGE_IS_NOW_DEAD, name, attacker);
        }
    }

    private static void handleCastSpell(String[] tokens, List<Hero> heroList) {
        String name = tokens[1];
        int MPNeeded = Integer.parseInt(tokens[2]);
        String spellName = tokens[3];

        Hero selectedHero =
                getSelectedHero(heroList, name);

        assert selectedHero != null;
        if (selectedHero.getMP() >= MPNeeded) {
            selectedHero.setMP(selectedHero.getMP() - MPNeeded);
            System.out.printf(CAST_SPELL_SUCCESSFULLY, name, spellName, selectedHero.getHP());
        } else {
            System.out.printf(CAST_SPELL_UNAVAILABLE, name, spellName);
        }
    }

    private static Hero getSelectedHero(List<Hero> heroList, String name) {
        return heroList.stream().filter(hero -> hero.getName().equals(name)).findFirst().orElse(null);
    }

    private static List<Hero> addHeroesToList(int n, Scanner scanner) {
        List<Hero> heroList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int HP = Integer.parseInt(tokens[1]);
            int MP = Integer.parseInt(tokens[2]);

            Hero hero = new Hero(name, HP, MP);
            heroList.add(hero);
        }
        return heroList;
    }
}
