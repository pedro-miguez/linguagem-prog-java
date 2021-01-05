public class SegmentoReta {
    private Ponto inicio;
    private Ponto fim;

    public SegmentoReta(Ponto p1, Ponto p2) {
        this.setInicio(new Ponto(p1));
        this.setFim(new Ponto(p2));
    }


    public Ponto getInicio() {
        return inicio;
    }

    public void setInicio(Ponto inicio) {
        this.inicio = inicio;
    }

    public Ponto getFim() {
        return fim;
    }

    public void setFim(Ponto fim) {
        this.fim = fim;
    }

    public double calcLength() {
        return Math.sqrt(Math.pow((this.getFim().getX() - this.getInicio().getX()), 2) +
                Math.pow((this.getFim().getY() - this.getInicio().getY()), 2) );
    }

    public double calcDeclivio() {
        return (double)(this.getInicio().getY() - this.getFim().getY()) /
                (this.getInicio().getX() - this.getFim().getX());
    }

    public void moveX (int x) {
        this.getInicio().setX(this.getInicio().getX() + x);
        this.getFim().setX(this.getFim().getX() + x);
    }

    public void moveY (int y) {
        this.getInicio().setY(this.getInicio().getY() + y);
        this.getFim().setY(this.getFim().getY() + y);
    }

    @Override
    public String toString() {
        return "SegmentoReta{" +
                "inicio=" + inicio +
                ", fim=" + fim +
                '}';
    }
}
