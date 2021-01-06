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
}
