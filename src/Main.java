import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

import Data.*;
import Data.Character;;


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
        float health = 0;
        float attackPower = 0;

        switch (choice) {
            case 1:
                health = 120f;
                attackPower = 15f;
                break;
            case 2:
                health = 150f;
                attackPower = 10f;
                break;
            case 3:
                health = 100f;
                attackPower = 20f;
                break;
        }

        Player player = new Player(playerName, health, attackPower, true); // Change to class Hero
        System.out.println("Welcome " + player.getName() + "!");


        while (player.isAlive()){
            Character enemy = new Character("Goblin", 50f, 5f, true); // change to class Enemy
            System.out.printf("A wild %s appears!%n", enemy.getName());

            boolean fighting = true;
            while (fighting) {

                choice = -1;
                cValid = false;
                while (!cValid) {
                    try {
                        System.out.println("Your turn! Choose an action:");
                        System.out.println("1. Attack");
                        System.out.println("2. Run Away");
                        System.out.println("3. Check Info");
                        System.out.println("4. Heal");
                        System.out.println("0. Exit Game");

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
                        System.out.println();
                        break;
                    case 2:
                        if (player.runAway()) {
                            System.out.println("You successfully ran away!%n");
                            fighting = false;
                        } else {
                            System.out.println("You couldn't escape!%n");
                        }
                        break;
                    case 3:
                        System.out.println(player.Info());
                        break;
                    case 4:
                        //fixme
                        break;
                    case 0:
                        System.out.println("Exiting game...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose again.%n");
                }

                if (enemy.getHealth() <= 0) {
                    System.out.println("You defeated the " + enemy.getName() + "!%n");
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
