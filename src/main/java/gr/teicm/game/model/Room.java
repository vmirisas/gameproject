package gr.teicm.game.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Room {
    private String name;
    private String description;
    private List<Exit> exits;
    private List<Item> items;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.exits = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public List<Exit> getExits() {
        return this.exits;
    }

    public void addExits(Exit... exits) {
        Collections.addAll(this.exits, exits);
    }

    public String getDescription() {
        return description;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public List<Item> getItems() {
        return this.items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

