package Data;

public class Item {
    private final String itemName;
    private final int ID;

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
}