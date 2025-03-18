package Data;

import java.util.Random;

public class Character {
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
