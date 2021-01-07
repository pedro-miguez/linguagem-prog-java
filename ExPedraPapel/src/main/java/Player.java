public class Player {
    private int currentPoints;
    private int playerID;

    public Player (int playerID) {
        setPlayerID(playerID);
        setCurrentPoints(0);
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
