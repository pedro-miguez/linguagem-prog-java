public class Main {
    public static void main(String[] args) {
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Game g1 = new Game(3, p1, p2);

        g1.runGame();

    }
}
