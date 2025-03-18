package Data;

public class EnchantedWeapon extends Weapon{
    private final int magicDamage;

    public EnchantedWeapon(int ID, String itemName, int damage, int magicDamage) {
        super(ID, itemName, damage);
        this.magicDamage = magicDamage;
    }

    public int getMagicDamage() {
        return magicDamage;
    }

    public String info() {
        return String.format("%s: Deals %d physical damage and %d magic damage.", super.getItemName(), super.getDamage(), magicDamage);
    }
}
