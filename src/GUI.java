import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Data.*;

public class GUI {
    private static JFrame frame;
    private static JTextArea outputArea;
    private static JTextField inputField;
    private static JButton submitButton;
    private static World world;
    private static Player player;
    private static Enemy enemy;
    private static String currentState = "START";

    public static void main(String[] args) {
        world = new World();
        setupGUI();
        startGame();
    }

    private static void setupGUI() {
        frame = new JFrame("Cairn RPG");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        inputField = new JTextField();
        submitButton = new JButton("Submit");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleInput(inputField.getText());
                inputField.setText("");
                inputField.requestFocusInWindow(); // Auto-select the text box
            }
        });

        inputField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    handleInput(inputField.getText());
                    inputField.setText("");
                    inputField.requestFocusInWindow(); // Auto-select the text box
                }
            }
        });

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(submitButton, BorderLayout.EAST);

        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
        inputField.requestFocusInWindow(); // Auto-select the text box on startup
    }

    private static void startGame() {
        appendOutput(String.format("%s: a game created by %s%n", world.getGameName(), world.getPublisher()));
        appendOutput("What is Your Name?");
        currentState = "NAME";
    }

    private static void handleInput(String input) {
        switch (currentState) {
            case "NAME":
                handleNameInput(input);
                break;
            case "CLASS_SELECTION":
                handleClassSelection(input);
                break;
            case "BATTLE":
                handleBattle(input);
                break;
            case "ITEM_SELECTION":
                handleItemUse(input);
                break;
            case "WEAPON_CHOICE":
                handleWeaponChoice(input);
                break;
            case "HEALING_ITEM_CHOICE":
                handleHealingItemChoice(input);
                break;
            default:
                appendOutput("Invalid state. Please restart the game.");
        }
    }

    private static void handleNameInput(String input) {
        if (input.isEmpty()) {
            appendOutput("Please enter a valid name.");
        } else {
            player = new Player(input, 100, 10, true, world.randomWeapon());
            appendOutput("Welcome " + player.getName() + "!");
            showClassSelection();
        }
    }

    private static void showClassSelection() {
        appendOutput("What is Your Class?");
        appendOutput("1. Warrior");
        appendOutput("2. Knight");
        appendOutput("3. Rogue");
        currentState = "CLASS_SELECTION";
    }

    private static void handleClassSelection(String input) {
        try {
            int choice = Integer.parseInt(input);
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
                default:
                    appendOutput("Please input a valid class. Try Again.");
                    return;
            }

            player.setHealth(health);
            player.setAttackPower(attackPower);
            player.setEquippedWeapon(startingWeapon);
            appendOutput("Class selected. Starting game...");

            startBattle();
        } catch (NumberFormatException e) {
            appendOutput("Please input an integer. Try Again.");
        }
    }

    private static void startBattle() {
        enemy = new Enemy("Goblin", 50, 5, true, world.returnWeapon(6));
        appendOutput(String.format("A wild %s appears!%n", enemy.getName()));
        showBattleOptions();
    }

    private static void showBattleOptions() {
        appendOutput("Your turn! Choose an action:");
        appendOutput("1. Attack");
        appendOutput("2. Run Away");
        appendOutput("3. Check Info");
        appendOutput("4. Use Item");
        appendOutput("0. Exit Game");
        currentState = "BATTLE";
    }

    private static void handleBattle(String input) {
        try {
            int choice = Integer.parseInt(input);
            switch (choice) {
                case 1:
                    appendOutput("You attack the enemy!");
                    enemy.setHealth(enemy.getHealth() - player.damage());
                    appendOutput(String.format("The %s now has %d Health!%n", enemy.getName(), enemy.getHealth()));
                    if (enemy.getHealth() <= 0) {
                        appendOutput(String.format("You defeated the %s!%n", enemy.getName()));
                        enemy = null;
                        startBattle();
                    }
                    break;
                case 2:
                    if (player.runAway()) {
                        appendOutput("You successfully ran away!");
                        enemy = null;
                        startBattle();
                    } else {
                        appendOutput("You couldn't escape!");
                    }
                    break;
                case 3:
                    appendOutput(player.Info());
                    break;
                case 4:
                    showItemOptions();
                    break;
                case 0:
                    appendOutput("Exiting game...");
                    System.exit(0);
                    break;
                default:
                    appendOutput("Invalid choice. Please choose again.");
            }
        } catch (NumberFormatException e) {
            appendOutput("Please input an integer. Try Again.");
        }
    }

    private static void showItemOptions() {
        appendOutput("Use:");
        appendOutput("1. Weapons");
        appendOutput("2. Healing Items");
        currentState = "ITEM_SELECTION";
    }

    private static void handleItemUse(String input) {
        try {
            int choice = Integer.parseInt(input);
            switch (choice) {
                case 1:
                    for (int i = 0; i < player.getWeapons().size(); i++) {
                        Weapon weapon = player.getWeapons().get(i);
                        appendOutput(String.format("%d. %s (Damage: %d)", i + 1, weapon.getItemName(), weapon.getDamage()));
                    }
                    appendOutput("Choose a weapon to equip:");
                    currentState = "WEAPON_CHOICE";
                    break;
                case 2:
                    for (int i = 0; i < player.getHealingItems().size(); i++) {
                        HealingItem healingItem = player.getHealingItems().get(i);
                        appendOutput(String.format("%d. %s (Heals: %d HP)", i + 1, healingItem.getItemName(), healingItem.getHealingPower()));
                    }
                    appendOutput("Choose a healing item to use:");
                    currentState = "HEALING_ITEM_CHOICE";
                    break;
                default:
                    appendOutput("Invalid choice. Please choose again.");
            }
        } catch (NumberFormatException e) {
            appendOutput("Please input an integer. Try Again.");
        }
    }

    private static void handleWeaponChoice(String input) {
        try {
            int weaponChoice = Integer.parseInt(input) - 1;
            if (weaponChoice >= 0 && weaponChoice < player.getWeapons().size()) {
                player.setEquippedWeapon(player.getWeapons().get(weaponChoice));
                appendOutput(String.format("Equipped %s.", player.getEquippedWeapon().getItemName()));
                showBattleOptions();
            } else {
                appendOutput("Invalid choice. Please choose again.");
            }
        } catch (NumberFormatException e) {
            appendOutput("Please input an integer. Try Again.");
        }
    }

    private static void handleHealingItemChoice(String input) {
        try {
            int healingItemChoice = Integer.parseInt(input) - 1;
            if (healingItemChoice >= 0 && healingItemChoice < player.getHealingItems().size()) {
                HealingItem healingItem = player.getHealingItems().get(healingItemChoice);
                player.setHealth(player.getHealth() + healingItem.getHealingPower());
                if (player.getHealth() > player.getMaxHealth()) {
                    player.setHealth(player.getMaxHealth());
                }
                player.removeHealingItems(healingItem, 1);
                appendOutput(String.format("Used %s. Your health is now %d.", healingItem.getItemName(), player.getHealth()));
                showBattleOptions();
            } else {
                appendOutput("Invalid choice. Please choose again.");
            }
        } catch (NumberFormatException e) {
            appendOutput("Please input an integer. Try Again.");
        }
    }

    private static void appendOutput(String text) {
        outputArea.append(text + "\n");
    }
}