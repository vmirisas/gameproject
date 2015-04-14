package gr.teicm.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Parser {

    private CommandList commands; // holds all valid command words

    /**
     * constructor
     */
    public CommandList getCommands(){
        return commands;
    }
    public Parser() {commands = new CommandList(); }

    /**
     *
     */
    public  Command getCommand()
    {
        String inputLine = ""; // will hold the full input line
        String word1;
        String word2;

        System.out.printf("> "); // print prompt

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
           inputLine = reader.readLine();
        }
        catch (java.io.IOException e){
            System.out.printf("There was an error during reading: " + e.getMessage());
        }

        StringTokenizer tokenizer = new StringTokenizer(inputLine);

        if(tokenizer.hasMoreTokens())
            word1 = tokenizer.nextToken(); // get first word
        else
            word1 = null;

        if(tokenizer.hasMoreTokens())
            word2 = tokenizer.nextToken(); // get second word
        else
            word2 = null;

        // note: we just ignore the rest of the input line.

        // Now check whether this word is known. If so, create a command
        // with it. If not, create a "nil" command (for unknown command).

        if(commands.isCommand(word1)&&commands.isSecondCommand(word2))
            return new Command(word1,word2);
        else if(commands.isCommand(word1))
            return new Command(word1,null);
                    else
            return new Command(null,word2);
    }





    /**
     *runs the show all command from the commandList file
     */
    public void showCommands()
    {
        commands.showAll();
    }


}
