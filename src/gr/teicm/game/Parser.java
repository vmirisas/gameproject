package gr.teicm.game;

import gr.teicm.game.command.GoCommand;
import gr.teicm.game.command.HelpCommand;
import gr.teicm.game.command.ICommand;
import gr.teicm.game.command.QuitCommand;
import gr.teicm.game.exception.InvalidCommandException;
import gr.teicm.game.model.Command;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Logger;

public class Parser {
    private static Parser instance;

    private Parser() {
    }

    public static Parser getInstance() {
        if (instance == null) {
            instance = new Parser();
        }

        return instance;
    }

    public List<ICommand> getCommands() throws InvalidCommandException {
        List<ICommand> commands = new ArrayList<>();

        System.out.print("> ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] commandsSplit = input.split(" and ");

        List<String> words;
        StringTokenizer tokenizer;

        for (String commandInput : commandsSplit) {
            tokenizer = new StringTokenizer(commandInput);
            words = new ArrayList<>();

            while (tokenizer.hasMoreElements()) {
                words.add(tokenizer.nextToken());
            }

            Command representativeCommand = null;

            for (Command command : Command.values()) {
                try {
                    if (words.get(0).equalsIgnoreCase(command.toString())) {
                        representativeCommand = command;
                    }
                } catch (IndexOutOfBoundsException e) {
                    throw new InvalidCommandException("No command found");
                }
            }

            if (representativeCommand == null) {
                throw new InvalidCommandException("There is no such command: " + words.get(0));
            } else {
                if (representativeCommand == Command.GO) {
                    try {
                        commands.add(new GoCommand(words.get(1)));
                    } catch (IndexOutOfBoundsException e) {
                        throw new InvalidCommandException("No argument found");
                    }
                } else if (representativeCommand == Command.HELP) {
                    commands.add(new HelpCommand());
                } else if (representativeCommand == Command.QUIT) {
                    commands.add(new QuitCommand());
                }
            }
        }

        return commands;
    }
}
