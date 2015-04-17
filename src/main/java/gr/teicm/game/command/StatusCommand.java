package gr.teicm.game.command;

import gr.teicm.game.PlayerState;
import gr.teicm.game.exception.InvalidCommandArgumentException;
import gr.teicm.game.model.Exit;
import gr.teicm.game.model.Room;

public class StatusCommand implements ICommand {
    private PlayerState playerState;

    public StatusCommand() {
        this.playerState = PlayerState.getInstance();
    }

    @Override
    public void perform() throws InvalidCommandArgumentException {
        Room currentRoom = this.playerState.getCurrentRoom();

        String string = "";

        string += "Room: " + currentRoom.getName() + "\n";
        string += "Room Description: " + currentRoom.getDescription() + "\n";
        string += "Exits: \n";

        for (Exit exit : currentRoom.getExits()) {
            string += "\t" + exit.getDirection().toString() + "\t->\t" + exit.getRoom().getName() + "\n";
        }

        System.out.println(string.trim());
    }
}
