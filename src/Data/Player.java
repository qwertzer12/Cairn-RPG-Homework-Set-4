package Data;

public class Player extends Character {
    private final int level = 1;
    private final int experience = 0;
    private final int money = 0;
    public Player(String name, float health, float attackPower, boolean isAlive) {
        super(name, health, attackPower, isAlive);
    }
}