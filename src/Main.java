import java.util.Random;
import java.util.Scanner;

import Data.World;

class Character {
    private String name = "temp";
    private float health = 1f;
    private float attackPower = 1f;
    private boolean isAlive = true;

    public Character(String name, float health, float attackPower, boolean isAlive) {
        this.setName(name);
        this.setHealth(health);
        this.setAttackPower(attackPower);
        this.setAlive(isAlive);
    }

    public boolean runAway() {
        Random rand = new Random();
        return rand.nextBoolean();
    }

    public String Info() {
        return String.format("%s: %.1f HP, %.1f AP.", getName(), getHealth(), getAttackPower());    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public float getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(float attackPower) {
        this.attackPower = attackPower;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}

class Item{
    private String name;
    private int healingPower;

    public Item(String name, int healingPower) {
        this.setName(name);
        this.setHealingPower(healingPower);
    }

    public String Info() {
        return String.format("%s: Heals %d HP.", getName(), getHealingPower());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealingPower() {
        return healingPower;
    }

    public void setHealingPower(int healingPower) {
        this.healingPower = healingPower;
    }
}

public class Main {
    public static void main(String[] args) {
        World world = new World();
        System.out.printf("%s: a game created by %s%n", world.getGameName(), world.getPublisher());

        System.out.println("What is Your Name?");
        Scanner scanner = new Scanner(System.in);
        String playerName = "";
        while (playerName.isEmpty()) {
            playerName = scanner.nextLine();
            if (playerName.isEmpty()) {
                System.out.println("Please enter a valid name.");
            }
        }

        Character player = new Character(playerName, 100f, 10f, true); // Change to class Hero
        System.out.println("Welcome " + player.getName() + "!");


        while (player.isAlive()){
            Character enemy = new Character("Goblin", 50f, 5f, true); // change to class Enemy
            System.out.printf("A wild %s appears!%n", enemy.getName());

            boolean fighting = true;
            while (fighting) {
                System.out.println("Your turn! Choose an action:");
                System.out.println("1. Attack");
                System.out.println("2. Run Away");
                System.out.println("3. Check Info");
                System.out.println("4. Heal");
                System.out.println("0. Exit Game");

                int choice = -1;
                boolean cValid = false;
                while (!cValid) {
                    try {
                        choice = Integer.parseInt(scanner.nextLine());
                        cValid = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Please input an integer. Try Again.");
                    }
                }

                switch (choice) {
                    case 1:
                        System.out.println("You attack the enemy!");
                        // Implement attack logic here
                        break;
                    case 2:
                        if (player.runAway()) {
                            System.out.println("You successfully ran away!");
                            fighting = false;
                        } else {
                            System.out.println("You couldn't escape!");
                        }
                        break;
                    case 3:
                        System.out.println(player.Info());
                        break;
                    case 4:
                        Item healthPotion = new Item("Health Potion", 20);
                        player.setHealth(player.getHealth() + healthPotion.getHealingPower());
                        System.out.println("You used a " + healthPotion.getName() + ". " + healthPotion.Info());
                        break;
                    case 0:
                        System.out.println("Exiting game...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose again.");
                }

                if (enemy.getHealth() <= 0) {
                    System.out.println("You defeated the " + enemy.getName() + "!");
                    fighting = false;
                }

                if (player.getHealth() <= 0) {
                    System.out.println("You have been defeated!");
                    player.setAlive(false);
                    fighting = false;
                }
            }
        }




    }
}
