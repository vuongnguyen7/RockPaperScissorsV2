import model.Player;
import model.PlayerChoice;
import view.GameInterface;

public class RockPaperScissorsV2 {

    static int startGameOption = 1;
    static Player player1 = new Player();
    static Player player2 = new Player();
    static GameInterface gui = new GameInterface();

    public static void main(String[] args) {

        while (startGameOption == 1) {
            if (player1.getScore() == 3) {
                gui.displayMessageDialog("Congratulations! You've beaten the Computer!", "You've beaten the Computer");
                System.exit(0); }
                else if (player2.getScore() == 3) {
                    gui.displayMessageDialog("Unlucky, the Computer has beaten you this time.", "You've have been beaten by the Computer");
                    System.exit(0);
                } else {
                    initialiseGame();
                    playGame();
                }
            }
        }

    static void initialiseGame() {

        startGameOption = gui.getGameOption("Hello, welcome to the 'Rock, Paper, Scissors' game", "Rock, Paper, Scissor Game", new String[]{"Exit", "New Game"});
        if (startGameOption == 0 || startGameOption == -1) { System.exit(0); }
    }

    static void playGame() {

        int p1Choice = gui.getPlayerChoice("Please select one.", "Choices for Player 1", player1.getPlayerChoices());
        player1.setChoice(p1Choice);
        player2.makeRandomChoice();

        evaluateResult(player1.getChoice(), player2.getChoice());

        gui.displayMessageDialog("Player 1 Score = " + player1.getScore() + "." + "\n" + "Player 2 Score = " + player2.getScore() + ".", "Current Scores");
    }

    static void evaluateResult(PlayerChoice player1Choice, PlayerChoice player2Choice) {

        if (player1Choice == player2Choice) {
            gui.displayMessageDialog("Player 1 and Player 2 selected " + player2Choice + "." + "\n" + "It’s a tie!", "Game results");
        } else {
            switch(player1Choice) {
                // using case but manually adding in the winning choice between the 2 choices
                case ROCK:
                    evaluateWinner(player1Choice, player2Choice, PlayerChoice.PAPER); break;
                case PAPER:
                    evaluateWinner(player1Choice, player2Choice, PlayerChoice.SCISSORS); break;
                case SCISSORS:
                    evaluateWinner(player1Choice, player2Choice, PlayerChoice.ROCK); break;
            }
        }
    }

    // method for evaluating winner, giving player1 choice, player2 choice and the winning value. Then checking if player1 or player2 has matched with the winning value.
    static void evaluateWinner(PlayerChoice player1Choice, PlayerChoice player2Choice, PlayerChoice player2ChoiceToWin) {

        if (player2Choice == player2ChoiceToWin) {
            gui.displayMessageDialog("Player 1 selected " + player1Choice + "." + "\n" + "Player 2 selected " + player2Choice + "." + "\n" + player2Choice + " beats " + player1Choice + ", Player 2 wins!", "Game results");
            player2.incrementScore();
        } else {
            gui.displayMessageDialog("Player 1 selected " + player1Choice + "." + "\n" + "Player 2 selected " + player2Choice + "." + "\n" + player1Choice + " beats " + player2Choice + ", Player 1 wins!", "Game results");
            player1.incrementScore();
        }
    }
}