package ExamPreparation.first;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HeroesOfCodeAndLogic {
    private static final String SUCCESSFULLY_CASTED_SPELL = "%s has successfully cast %s and now has %d MP!";
    private static final String INSUFFICIENT_MP_TO_CAST_SPELL = "%s does not have enough MP to cast %s!";
    private static final String HERO_TOOK_DAMAGE_BUT_LIVES = " %s was hit for %d HP by %s and now has %d HP left!";
    private static final String HERO_IS_DEAD = "%s has been killed by %s!";
    private static final String HERO_RECHARGED = "%s recharged for %d MP!";
    private static final String HERO_HEALED = "%s healed for %s HP!";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Hero> heroes = handleHeroAddition(n, scanner);

        handleBattlefield(heroes, scanner);

        heroes.forEach(System.out::println);
    }
    private static void handleBattlefield(List<Hero> heroes, Scanner scanner) {
        String line = scanner.nextLine();
        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "CastSpell":
                    handleCastSpell(tokens, heroes);
                    break;

                case "TakeDamage":
                    handleTakeDamage(tokens, heroes);
                    break;

                case "Recharge":
                    handleRecharge(tokens, heroes);
                    break;

                case "Heal":
                    handleHeal(tokens, heroes);
                    break;
            }
            line = scanner.nextLine();
        }
    }
    private static void handleHeal(String[] tokens, List<Hero> heroes) {
        String name = tokens[0];
        int amount = Integer.parseInt(tokens[1]);

        Hero targetHero = heroes.stream().filter(hero -> hero.getName().equals(name)).findFirst().orElse(null);

        assert targetHero != null;

        targetHero.setHP(targetHero.getHP() + amount);
        if (targetHero.getHP() > 100) {
            targetHero.setHP(100);
            System.out.printf(HERO_HEALED, name, amount);
        }
    }

    private static void handleRecharge(String[] tokens, List<Hero> heroes) {
        String name = tokens[0];
        int amount = Integer.parseInt(tokens[1]);
        Hero targethero = heroes.stream()
                .filter(hero -> hero.getName().equals(name)).findFirst().orElse(null);

        assert targethero != null;
        targethero.setMP(targethero.getMP() + amount);
        if (targethero.getMP() > 200) {
            targethero.setMP(200);
            System.out.printf(HERO_RECHARGED, targethero, amount);
        }
    }

    private static void handleTakeDamage(String[] tokens, List<Hero> heroes) {
        String name = tokens[1];
        int damage = Integer.parseInt(tokens[2]);
        String attacker = tokens[3];

        Hero targetHero = heroes.stream().filter(hero -> hero.getName().equals(name)).findFirst().orElse(null);

        assert targetHero != null;
        targetHero.setHP(targetHero.getHP() - damage);
        if (targetHero.getHP() > 0) {
            System.out.printf(HERO_TOOK_DAMAGE_BUT_LIVES, name, damage, attacker, targetHero.getHP());
        } else {
            heroes.remove(targetHero);
            System.out.printf(HERO_IS_DEAD, name, attacker);
        }
    }
    private static void handleCastSpell(String[] tokens, List<Hero> heroes) {
        String name = tokens[1];
        int neededMP = Integer.parseInt(tokens[2]);
        String spellName = tokens[3];

        Hero targetHero =
                heroes.stream().filter(hero -> hero.getName().equals(name)).findFirst().orElse(null);

        assert targetHero != null;
        int currentHeroMp = targetHero.getMP();
        if (currentHeroMp >= neededMP) {
            targetHero.setMP(targetHero.getMP() - neededMP);
            System.out.printf(SUCCESSFULLY_CASTED_SPELL, name, spellName, targetHero.getMP());
        } else {
            System.out.printf(INSUFFICIENT_MP_TO_CAST_SPELL, name, spellName);
        }
    }

    private static List<Hero> handleHeroAddition(int n, Scanner scanner) {
        List<Hero> heroes = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int HP = Integer.parseInt(tokens[1]);
            int MP = Integer.parseInt(tokens[2]);

            Hero hero = new Hero(name, HP, MP);
            heroes.add(hero);
        }
        return heroes;
    }
}
//Here's a detailed review and rating of your code:
//
//### **1. Code Structure and Organization (4.5/5)**
//- **Pros:**
//  - The code is well-structured and logically organized into clear methods, making it easy to read and maintain.
//  - Methods are single-responsibility: each method handles one specific task (e.g., `handleBattlefield`, `handleHeroAddition`).
//  - Constants are used for strings that are repeatedly used, which is good for maintainability.
//
//- **Cons:**
//  - There’s a slight inconsistency in the use of method names (`targethero` vs `targetHero` in `handleRecharge`). Consistency in naming conventions is important.
//  - The method `handleHeroAddition` could potentially benefit from better naming (e.g., `initializeHeroes`) to better reflect its purpose.
//
//### **2. Code Efficiency (4/5)**
//- **Pros:**
//  - The use of streams for filtering is efficient and modern.
//  - Using a `LinkedList` for storing heroes is reasonable since the code often iterates over the list and sometimes removes elements.
//
//- **Cons:**
//  - The `stream().filter(...).findFirst()` operation is called multiple times. If the list of heroes is large, this might become inefficient. A `Map<String, Hero>` could provide O(1) access to heroes by name instead of O(n) with a list.
//  - `assert` statements are used for null checks, which is not a best practice for production code. `assert` is more suited for testing assumptions during development rather than handling runtime scenarios. Using an `if` statement with proper error handling would be better.
//
//### **3. Error Handling (3.5/5)**
//- **Pros:**
//  - The code uses assertions to ensure that `targetHero` is not null before proceeding.
//
//- **Cons:**
//  - As mentioned above, relying on assertions for null checks is not ideal. In a production environment, this could lead to crashes if assertions are disabled (which they often are). A better approach would be to handle these cases explicitly, potentially logging an error or throwing an appropriate exception.
//  - Some edge cases might not be handled, such as what happens if an invalid command is entered.
//
//### **4. Readability and Maintainability (4/5)**
//- **Pros:**
//  - The code is highly readable due to the clear method separation and use of meaningful variable names.
//  - The use of constants for message formats improves maintainability and avoids hard-coding.
//
//- **Cons:**
//  - Some method names could be slightly improved for clarity (e.g., `handleHeroAddition` could be more descriptive).
//  - The logic in methods like `handleRecharge` and `handleHeal` has a bit of repetition, which could be refactored to reduce duplication.
//
//### **5. Correctness and Functionality (4.5/5)**
//- **Pros:**
//  - The code seems to correctly implement the logic described and handles various game mechanics effectively.
//  - It correctly updates the heroes' attributes based on the input commands and prints the appropriate messages.
//
//- **Cons:**
//  - Minor issues like the potential for exceeding max HP or MP are handled but could be more explicitly defined (e.g., explicitly capping values rather than just printing and setting).
//
//### **Overall Rating: 4.2/5**
//
//**Summary:** Your code is well-structured, fairly efficient, and easy to understand. The main areas for improvement are in handling potential edge cases, improving the efficiency with a different data structure, and refining some of the method names for clarity. Additionally, replacing assertions with more robust error handling would make the code more production-ready.