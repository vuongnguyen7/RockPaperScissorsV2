package view;

import model.PlayerChoice;

import javax.swing.*;

public class GameInterface {

    public int getGameOption(String welcomeMessage, String windowTitle, String[] gameOptions) {
        return JOptionPane.showOptionDialog(null, welcomeMessage, windowTitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, gameOptions, null);
    }

    public int getPlayerChoice(String welcomeMessage, String windowTitle, PlayerChoice[] playerChoices) {
        return JOptionPane.showOptionDialog(null, welcomeMessage, windowTitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, playerChoices, null);
    }

    public void displayMessageDialog(String message, String windowTitle) {
        JOptionPane.showMessageDialog(null, message, windowTitle, JOptionPane.PLAIN_MESSAGE, null);
    }

}