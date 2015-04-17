package gr.teicm.game.model;

public enum Command {
    GO("go"),
    QUIT("quit"),
    HELP("help");

    String value;

    Command(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
