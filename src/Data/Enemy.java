package Data;

import java.util.ArrayList;

public class Enemy extends Character{
    World world = new World();
    ArrayList<Item> loot = new ArrayList<>();

    public Enemy(String name, int health, int attackPower, boolean isAlive, Weapon equippedWeapon) {
        super(name, health, attackPower, isAlive, equippedWeapon);
        loot.add(world.randomWeapon());
        loot.add(world.randomHealingItem());
    }

    public ArrayList<Item> getLoot() {
        return loot;
    }
}
