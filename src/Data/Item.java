package Data;

public class Item {
    private final String itemName;
    private final int ID;
    private int amount = 1;

    public Item(int ID, String itemName) {
        this.ID = ID;
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public int getID() {
        return ID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}