package gr.teicm.game.command;

import gr.teicm.game.PlayerState;
import gr.teicm.game.exception.InvalidCommandArgumentException;
import gr.teicm.game.model.Exit;
import gr.teicm.game.model.Room;

import java.util.List;

public class GoCommand implements ICommand {
    private PlayerState playerState;
    private String argument;

    public GoCommand(String arguments) {
        this.playerState = PlayerState.getInstance();
        this.argument = arguments;
    }

    public String getArgument() {
        return argument;
    }

    public void setArgument(String arguments) {
        this.argument = arguments;
    }

    @Override
    public void perform() throws InvalidCommandArgumentException {
        Room currentRoom = playerState.getCurrentRoom();
        List<Exit> exits = currentRoom.getExits();
        Exit representativeExit = null;

        for (Exit exit : exits) {
            if (this.argument.equalsIgnoreCase(exit.getDirection().toString())) {
                representativeExit = exit;
            }
        }

        if (representativeExit != null) {
            playerState.setCurrentRoom(representativeExit.getRoom());
            System.out.println(playerState.getCurrentRoom().getDescription());
        } else {
            throw new InvalidCommandArgumentException("There is no such direction");
        }
    }
}
