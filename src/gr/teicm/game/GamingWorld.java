package gr.teicm.game;

import gr.teicm.game.command.ICommand;
import gr.teicm.game.exception.InvalidCommandArgumentException;
import gr.teicm.game.exception.InvalidCommandException;
import gr.teicm.game.model.Direction;
import gr.teicm.game.model.Exit;
import gr.teicm.game.model.Room;

import java.util.ArrayList;
import java.util.List;

public class GamingWorld {
    private PlayerState playerState;
    private Parser parser;
    private List<Room> rooms;

    public GamingWorld() {
        this.playerState = PlayerState.getInstance();
        this.parser = Parser.getInstance();
        this.rooms = new ArrayList<>();

        createRooms();
    }

    public void createRooms() {
        Room yard = new Room("You are at the house yard. It's beautiful out here although the weather is freezing cold!");
        Room livingRoom = new Room("You are in the living room. As you enter the house you feel the cozy warmth of the fireplace. ");
        Room kitchen = new Room("The smell of fresh food indicates with closed eyes that this room is the kitchen.");
        Room bedroom = new Room("This is where le sexy time happens... or where you can just sleep.");
        Room office = new Room("There is a huge desk as you enter the office. An Apple computer is on it. Also there is a big library with a plethora o books.");
        Room bathroom = new Room("This bathroom is full of steam. You also distinguish rem stains on the mirror.");
        Room garage = new Room("The garage seems pretty tidy. I wonder where the car could possibly be...");

        yard.setExits(new Exit(Direction.NORTH, livingRoom), new Exit(Direction.EAST, garage));
        livingRoom.setExits(new Exit(Direction.NORTH, bedroom), new Exit(Direction.EAST, kitchen), new Exit(Direction.SOUTH, yard), new Exit(Direction.WEST, office));
        kitchen.setExits(new Exit(Direction.SOUTH, garage), new Exit(Direction.WEST, livingRoom));
        bedroom.setExits(new Exit(Direction.SOUTH, livingRoom), new Exit(Direction.WEST, bathroom));
        office.setExits(new Exit(Direction.NORTH, bathroom), new Exit(Direction.EAST, livingRoom));
        bathroom.setExits(new Exit(Direction.EAST, bedroom), new Exit(Direction.SOUTH, office));
        garage.setExits(new Exit(Direction.NORTH, kitchen), new Exit(Direction.WEST, yard));

        this.rooms.add(yard);
        this.rooms.add(livingRoom);
        this.rooms.add(kitchen);
        this.rooms.add(bedroom);
        this.rooms.add(office);
        this.rooms.add(bathroom);
        this.rooms.add(garage);

        this.playerState.setCurrentRoom(yard);
    }

    public void play() {
        System.out.println(this.playerState.getCurrentRoom().getDescription());

        List<ICommand> commands;

        while (true) {
            try {
                commands = parser.getCommands();
                commands.forEach(ICommand::perform);
            } catch (InvalidCommandException | InvalidCommandArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
