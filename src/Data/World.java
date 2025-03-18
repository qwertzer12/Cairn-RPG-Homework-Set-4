package Data;

import java.util.ArrayList;

public class World {
    private final String gameName = "Cairn RPG";
    private final String publisher = "AJ Chabin, Samuel Chapin";
    private ArrayList<Weapon> weapons = new ArrayList<>();
    private ArrayList<HealingItem> healingItems = new ArrayList<>();


    public World() {
        weapons.add(new Weapon(weapons.size(), "Wooden Sword", 5));
        weapons.add(new Weapon(weapons.size(), "Iron Sword", 10));
        weapons.add(new EnchantedWeapon(weapons.size(), "Fire Sword", 8, 4));

        weapons.add(new Weapon(weapons.size(), "Wooden Axe", 7));
        weapons.add(new Weapon(weapons.size(), "Iron Axe", 12));
        weapons.add(new EnchantedWeapon(weapons.size(), "Ice Axe", 9, 5));

        weapons.add(new Weapon(weapons.size(), "Wooden Dagger", 5));
        weapons.add(new Weapon(weapons.size(), "Iron Dagger", 8));
        weapons.add(new EnchantedWeapon(weapons.size(), "Poison Dagger", 6, 9));


        healingItems.add(new HealingItem(healingItems.size(), "Healing Potion", 10));
        healingItems.add(new HealingItem(healingItems.size(), "Super Potion", 20));
        healingItems.add(new HealingItem(healingItems.size(), "Mega Potion", 50));
    }

    public String getGameName() {
        return gameName;
    }

    public String getPublisher() {
        return publisher;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public Weapon randomWeapon() {
        return weapons.get((int)(Math.random() * weapons.size()));
    }

    public ArrayList<HealingItem> getHealingItems() {
        return healingItems;
    }

    public HealingItem randomHealingItem() {
        return healingItems.get((int)(Math.random() * healingItems.size()));
    }
}



