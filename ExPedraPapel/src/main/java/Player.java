public class Player {
    private int currentPoints;
    private int playerID;
    private boolean winner;

    public Player (int playerID) {
        setPlayerID(playerID);
        setCurrentPoints(0);
        setWinner(false);
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public void addPoint() {
        setCurrentPoints(getCurrentPoints() + 1);
    }

}
