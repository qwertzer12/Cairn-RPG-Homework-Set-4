import java.util.Scanner;
import java.util.ArrayList;

import Data.*;

@SuppressWarnings("BusyWait")
public class Main {
    static int choice = -1;
    static boolean cValid = false;
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

        choice = -1;
        cValid = false;
        while (!cValid) {
            try {
                System.out.println("What is Your Class?");
                System.out.println("1. Warrior");
                System.out.println("2. Knight");
                System.out.println("3. Rogue");

                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 3) {
                    System.out.println("Please input a valid class. Try Again.");
                    choice = -1;
                    continue;
                }
                cValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Please input an integer. Try Again.");
            }
        }
        int health = 0;
        int attackPower = 0;
        Weapon startingWeapon = null;

        switch (choice) {
            case 1:
                health = 120;
                attackPower = 15;
                startingWeapon = world.returnWeapon(3);
                break;
            case 2:
                health = 150;
                attackPower = 10;
                startingWeapon = world.returnWeapon(0);
                break;
            case 3:
                health = 100;
                attackPower = 20;
                startingWeapon = world.returnWeapon(6);
                break;
        }

        Player player = new Player(playerName, health, attackPower, true, startingWeapon); // Change to class Hero
        System.out.println("Welcome " + player.getName() + "!");

        while (player.isAlive()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Enemy enemy = new Enemy("Goblin", 50, 5, true, world.returnWeapon(6)); // change to class Enemy
            System.out.printf("A wild %s appears!%n", enemy.getName());

            boolean fighting = true;
            while (fighting) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                choice = -1;
                cValid = false;
                while (!cValid) {
                    try {
                        System.out.println("Your turn! Choose an action:");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("1. Attack");
                        System.out.println("2. Run Away");
                        System.out.println("3. Check Info");
                        System.out.println("4. Use Item");
                        System.out.println("0. Exit Game");

                        choice = Integer.parseInt(scanner.nextLine());
                        cValid = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Please input an integer. Try Again.");
                    }
                }

                switch (choice) {
                    case 1:
                        System.out.printf("You attack the enemy!%n%n");

                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        enemy.setHealth(enemy.getHealth() - player.damage());
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        System.out.printf("The %s now has %d Health!%n", enemy.getName(), enemy.getHealth());
                        System.out.println();
                        break;
                    case 2:
                        if (player.runAway()) {
                            System.out.printf("You successfully ran away!%n%n");
                            fighting = false;
                        } else {
                            System.out.printf("You couldn't escape!%n%n");
                        }
                        break;
                    case 3:
                        System.out.println(player.Info());
                        break;
                    case 4:
                        choice = -1;
                        cValid = false;
                        while (!cValid) {
                            try {
                                System.out.printf("Use:%n1. Weapons%n2. Healing Items%n");

                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }

                                choice = Integer.parseInt(scanner.nextLine());
                                cValid = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Please input an integer. Try Again.");
                            }
                        }

                        switch (choice) {
                            case 1:
                                for (int i = 0; i < player.getWeapons().size(); i++) {
                                    Weapon weapon = player.getWeapons().get(i);
                                    System.out.printf("%d. %s (Damage: %d)%n", i + 1, weapon.getItemName(), weapon.getDamage());
                                }
                                System.out.println("Choose a weapon to equip:");
                                int weaponChoice = Integer.parseInt(scanner.nextLine()) - 1;
                                if (weaponChoice >= 0 && weaponChoice < player.getWeapons().size()) {
                                    player.setEquippedWeapon(player.getWeapons().get(weaponChoice));
                                    System.out.printf("Equipped %s.%n", player.getEquippedWeapon().getItemName());
                                } else {
                                    System.out.println("Invalid choice. Please choose again.");
                                }
                                break;
                            case 2:
                                for (int i = 0; i < player.getHealingItems().size(); i++) {
                                    HealingItem healingItem = player.getHealingItems().get(i);
                                    System.out.printf("%d. %s (Amount: %d)%n", i + 1, healingItem.getItemName(), healingItem.getAmount());
                                }
                                System.out.println("Choose a healing item to use:");
                                int healingItemChoice = Integer.parseInt(scanner.nextLine()) - 1;
                                if (healingItemChoice >= 0 && healingItemChoice < player.getHealingItems().size()) {
                                    HealingItem healingItem = player.getHealingItems().get(healingItemChoice);
                                    player.setHealth(player.getHealth() + healingItem.getHealingPower());
                                    if (player.getHealth() > player.getMaxHealth()) {
                                        player.setHealth(player.getMaxHealth());
                                    }
                                    player.removeHealingItems(healingItem, 1);
                                    System.out.printf("Used %s. Your health is now %d.%n", healingItem.getItemName(), player.getHealth());
                                } else {
                                    System.out.println("Invalid choice. Please choose again.");
                                }
                                break;
                            default:
                                System.out.println("Invalid choice. Please choose again.");
                                break;
                        }
                        break;
                    case 0:
                        System.out.println("Exiting game...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose again.");
                }

                if (enemy.getHealth() <= 0) {
                    System.out.printf("You defeated the %s!%n%n", enemy.getName());
                    ArrayList<Item> loot = enemy.getLoot();
                    System.out.println("You found the following items:");
                    for (Item item : loot) {
                        System.out.printf("- %s%n", item.getItemName());
                    }

                    player.addWeapon((Weapon) loot.get(0), 1);
                    player.addHealingItems((HealingItem) loot.get(1), 3);

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