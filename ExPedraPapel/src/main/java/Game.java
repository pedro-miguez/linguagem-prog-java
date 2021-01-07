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

    public boolean checkVictor (Player player) {
        return player.getCurrentPoints() == getMaxPoints();
    }

    public void runGame() {
        System.out.println("Let's Play 'Rock, Paper, Scissor'!!! Points to win: " + getMaxPoints());

        while (!checkVictor(playerOne) && !checkVictor(playerTwo)) {

            Signals playerOneChoice = chooseSignal(playerOne);
            Signals playerTwoChoice = chooseSignal(playerTwo);

            switch (playerOneChoice.interactionResult(playerTwoChoice)) {
                case 0 -> {
                    System.out.println("Nobody wins a point: " + playerOneChoice + " + " + playerTwoChoice + " = DRAW");
                }
                case 1 -> {
                    System.out.println("Player one wins a point: " + playerOneChoice + " + " + playerTwoChoice +
                            " = " + playerOneChoice + " wins!");
                    playerOne.addPoint();
                }
                case 2 -> {
                    System.out.println("Player two wins a point: " + playerOneChoice + " + " + playerTwoChoice +
                            " = " + playerTwoChoice + " wins!");
                    playerTwo.addPoint();
                }
            }
            System.out.println("Current score is: " + playerOne.getCurrentPoints() + " - " + playerTwo.getCurrentPoints());
        }

        if (checkVictor(playerOne)) {
            System.out.print("Player One Wins!");
        } else {
            System.out.print("Player Two Wins!");
        }
    }

    public Signals chooseSignal (Player player) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Player " + player.getPlayerID() + " (1 - Rock | 2 - Paper | 3 - Scissor): ");
        int answer;
        do {
            answer = scn.nextInt();
        } while (answer < 1 || answer > 3);

        return switch (answer) {
            case 1 -> Signals.ROCK;
            case 2 -> Signals.PAPER;
            case 3 -> Signals.SCISSOR;
            default -> throw new IllegalStateException("Unexpected value: " + answer);
        };
    }
}
