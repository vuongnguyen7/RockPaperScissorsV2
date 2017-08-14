package model;

public enum PlayerChoice {
    ROCK("Rock"),
    PAPER("Paper"),
    SCISSORS("Scissors");

    public final String choice;

    public String getChoice() {
        return choice;
    }

    PlayerChoice(String choice) {
        this.choice = choice;
    }

    @Override
    public String toString() {return choice;}
}