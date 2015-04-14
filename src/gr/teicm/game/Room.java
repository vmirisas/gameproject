package gr.teicm.game;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.ArrayList;


public class Room {

    private String description ;
    private HashMap exits ;
    private ArrayList<Item> items = new ArrayList<Item>();
    /**
     *
     */
    public Room(String description)
    {
        this.description = description;
        exits = new HashMap();
    }

    /**
     * puts elements on the hashmap
     */
    public void setExits(Room north, Room east, Room south, Room west)
    {
        if(north != null)
            exits.put("north", north);
        if(east != null)
            exits.put("east", east);
        if(south != null)
            exits.put("south", south);
        if(west != null)
            exits.put("west", west);
    }

    /**
     * constructor
     */
    public String shortDescription()
    {
        return description;
    }

    /**
     *constructor
     */
    public String longDescription()
    {
        return  description + "\n" + exitString();
    }

    /**
     *constructor
     */
    private String exitString()
    {
        String returnString = "Exits:";
        Set keys = exits.keySet();
        for(Iterator iter = keys.iterator(); iter.hasNext();)
            returnString += " " + iter.next();
        return returnString;
    }

    /**
     *constructor
     */
    public Room nextRoom(String direction)
    {
        return (Room)exits.get(direction);
    }

    /**
     * method for adding items to our rooms
     */
    public void addItem(Item item){
        items.add(item);
    }

    /**
     * method for removing items from our rooms
     */
    public void removeItem(Item item){
        items.remove(item);
    }

    /**
     * getter for items
     */




}


