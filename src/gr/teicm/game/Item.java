package gr.teicm.game;


/**
* Created by Vasilis on 27/3/2015.
*/
public class Item {

    private String itemName;
    private String itemDescription;
    private ItemType type ;
    private boolean takable;
    private Room currentItemLocation;




    public Item(String itemName, String itemDescription, ItemType type, boolean takable, Room currentItemLocation){
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

    public boolean isTakable() {
        return takable;
    }

    public Room getCurrentItemLocation() {
        return currentItemLocation;
    }



}
