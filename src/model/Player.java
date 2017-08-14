package model;

public class Player {

    public int score;

    public PlayerChoice choice;

    public PlayerChoice[] getPlayerChoices() {
        return playerChoices;
    }

    public PlayerChoice[] playerChoices = PlayerChoice.values();

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public PlayerChoice getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = playerChoices[choice];
    }

    public void incrementScore() {
        score++;
    }

    public void makeRandomChoice() {
        this.choice = playerChoices[(int) Math.floor(Math.random() * 3)];
    }
}