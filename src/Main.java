import java.util.Random;

class World {
    String gameName;
    String publisher;

    public World() {
        this.gameName = "Cairn RPG";
        this.publisher = "AJ Chabin, ...";
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}

class Character {
    String name;
    float health;
    float attackPower;
    boolean isAlive;

    public Character(String name, float health, float attackPower, boolean isAlive) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.isAlive = isAlive;
    }

    public boolean runAway() {
        Random rand = new Random();
        return rand.nextBoolean();
    }

    public String Info() {
    }

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
    String name;
    int healingPower;

    public Item(String name, int healingPower) {
        this.name = name;
        this.healingPower = healingPower;
    }

    public String Info() {
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
        System.out.println("Hello, World!");
    }
}
