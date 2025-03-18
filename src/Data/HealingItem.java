package Data;

public class HealingItem extends Item {
    private final int healingPower;

    public HealingItem(int ID, String itemName, int healingPower) {
        super(ID, itemName);
        this.healingPower = healingPower;
    }

    public String info() {
        return String.format("%s: Heals %d HP.", super.getItemName(), healingPower);
    }

    public int getHealingPower() {
        return healingPower;
    }
}