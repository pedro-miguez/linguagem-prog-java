public class Ponto {

    private int x;
    private int y;

    private static final int X_OMITTED = 0;
    private static final int Y_OMITTED = 0;

    public Ponto (int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public Ponto (Ponto p1) {
        this.setX(p1.getX());
        this.setY(p1.getY());
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void movePonto (int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public void moveX (int x) {
        this.setX(getX() + x);
    }

    public void moveY (int y) {
        this.setY(getY() + y);
    }

    public void moveXANDY (int x, int y) {
        this.moveX(x);
        this.moveY(y);
    }

    @Override
    public String toString() {
        return "Ponto{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
