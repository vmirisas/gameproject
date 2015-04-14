package gr.teicm.game;


public class CommandList {
    /**
     * list of valid commands for the first command
     * TODO "USE","OPEN","EXAMINE"
     */
    private static final String validCommands[] = {
            "go", "quit", "help","use","open","examine"
    };

    private static final String validSecondCommands[]={
            "south","west","north","east"
    };


    /**
     * constructor
     */
    public CommandList(){}
    /**
     * checks if the first command is any of the above validcommands
     */
    public boolean isCommand(String aString){
        for(int i = 0; i < validCommands.length; i++){
            if(validCommands[i].equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }

    /**
     * and the same as above for second string
     * @param aString
     * @return
     */
    public boolean isSecondCommand(String aString){
        for(int i = 0; i < validSecondCommands.length; i++){
            if(validSecondCommands[i].equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }
    /**
     * shows all the valid commands
     */
       public void showAll(){
        for(int i = 0; i < validCommands.length; i++){
            System.out.printf(validCommands[i] + " ");
        }
        System.out.println();
    }
}
