package gr.teicm.game.model;

public class Item {
    private String itemName;
    private String itemDescription;
    private ItemType type;
    private Boolean takable;
    private Room currentItemLocation;

    public Item(String itemName, String itemDescription, ItemType type, Boolean takable, Room currentItemLocation) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.type = type;
        this.takable = takable;
        this.currentItemLocation = currentItemLocation;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public ItemType getType() {
        return type;
    }

    public Boolean isTakable() {
        return takable;
    }

    public Room getCurrentItemLocation() {
        return currentItemLocation;
    }
}
