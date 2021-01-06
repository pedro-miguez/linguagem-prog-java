import java.util.Scanner;

public class Game {

    private int maxPoints;
    private Player playerOne;
    private Player playerTwo;

    public Game (int maxPoints, Player playerOne, Player playerTwo) {
        setMaxPoints(maxPoints);
        setPlayerOne(playerOne);
        setPlayerTwo(playerTwo);
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public void runGame() {
        while (playerOne.getCurrentPoints() < maxPoints && playerTwo.getCurrentPoints() < maxPoints) {
            Signals playerOneChoice = chooseSignal(playerOne);
            Signals playerTwoChoice = chooseSignal(playerTwo);

            switch (playerOneChoice.interactionResult(playerTwoChoice)) {
                case 0:
                case 1:
                case 2:
            }

        }
    }

    public Signals chooseSignal (Player player) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Player " + player.getPlayerID() + "(1 - Rock | 2 - Paper | 3 - Scissor): ");
        int answer = scn.nextInt();

        switch (answer) {
            case 1:
                return Signals.ROCK;
            case 2:
                return Signals.PAPER;
            case 3:
                return Signals.SCISSOR;
            default:
                System.out.println("Só são validos valores entre 1 e 3");
                chooseSignal(player);
        }
    }
}
