package gr.teicm.game.command;

import gr.teicm.game.model.Command;

public class HelpCommand implements ICommand {
    @Override
    public void perform() {
        System.out.println("I think you asked for my help...");
        System.out.println("well...");
        System.out.println();
        System.out.println("Your available command words are:");
        System.out.println();

        String commands = "";

        for (Command command : Command.values()) {
            commands += "\t" + command + "\n";
        }

        System.out.println(commands);
    }
}
