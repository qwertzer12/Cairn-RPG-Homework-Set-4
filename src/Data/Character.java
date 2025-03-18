package Data;

import java.util.ArrayList;
import java.util.Random;

public class Character {
    private String name = "temp";
    private int health = 1;
    private int attackPower = 1;
    private boolean isAlive = true;
    private ArrayList<Weapon> weapons = new ArrayList<>();
    private ArrayList<HealingItem> healingItems = new ArrayList<>();
    private Weapon equippedWeapon;


    public Character(String name, int health, int attackPower, boolean isAlive, Weapon equippedWeapon) {
        this.setName(name);
        this.setHealth(health);
        this.setAttackPower(attackPower);
        this.setAlive(isAlive);
        this.setEquippedWeapon(equippedWeapon);
        weapons.add(equippedWeapon);
    }

    public boolean runAway() {
        Random rand = new Random();
        return rand.nextBoolean();
    }

    public String Info() {
        return String.format("%s: %d HP, %d AP. Equipped Weapon: %s.", getName(), getHealth(), getAttackPower(), getEquippedWeapon().getItemName());    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public ArrayList<HealingItem> getHealingItems() {
        return healingItems;
    }

    public void addHealingItems(HealingItem healingItem, int n) {
        boolean itemFound = false;
        for (HealingItem thisHealingItem : healingItems) {
            if (thisHealingItem.getID() == healingItem.getID()) {
                thisHealingItem.setAmount(thisHealingItem.getAmount() + n);
                itemFound = true;
                break;
            }
        }
        if (!itemFound) {
            healingItem.setAmount(n);
            healingItems.add(healingItem);
        }
    }

    public void removeHealingItems(HealingItem healingItem, int n) {
        for (HealingItem thisHealingItem : healingItems) {
            if (thisHealingItem.getID() == healingItem.getID()) {
                thisHealingItem.setAmount(thisHealingItem.getAmount() - n);
                if (thisHealingItem.getAmount() <= 0) {
                    healingItems.remove(thisHealingItem);
                }
                break;
            }
        }
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void addWeapon(Weapon weapon, int n) {
        boolean itemFound = false;
        for (Weapon thisWeapon : weapons) {
            if (thisWeapon.getID() == weapon.getID()) {
                thisWeapon.setAmount(thisWeapon.getAmount() + n);
                itemFound = true;
                break;
            }
        }
        if (!itemFound) {
            weapon.setAmount(n);
            weapons.add(weapon);
        }
    }

    public void removeWeapon(Weapon weapon, int n) {
        for (Weapon thisWeapon : weapons) {
            if (thisWeapon.getID() == weapon.getID()) {
                thisWeapon.setAmount(thisWeapon.getAmount() - n);
                if (thisWeapon.getAmount() <= 0) {
                    healingItems.remove(thisWeapon);
                }
                break;
            }
        }
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public int damage(){
        return equippedWeapon.getDamage()+getAttackPower();
    };
}
