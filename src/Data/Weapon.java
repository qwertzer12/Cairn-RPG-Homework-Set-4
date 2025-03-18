package Data;

public class Weapon extends Item {
    private final int damage;

    public Weapon(int ID, String itemName, int damage) {
        super(ID, itemName);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
