package gr.teicm.game;


import java.lang.String;

public class Command {

    private String commandWord;
    private String secondWord;

    /**Here we are making the constructor of our class Command
     */
    public Command(String firstWord, String secondWord){
        commandWord = firstWord;
        this.secondWord = secondWord;
    }

    /**Because the commandWord and secondword  are private for security reasons we build a getter for the commandword and secondword
     */
    public String getCommandWord() {return commandWord;}


    public String getSecondWord()
    {
        return secondWord;
    }

    /**We check the probability that the user enters an invalid first or/and second word
     *
     */
    public boolean isUnknown()
    {
        return (commandWord == null);
    }



    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }

}
