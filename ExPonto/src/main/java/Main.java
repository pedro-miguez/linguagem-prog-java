public class Main {
    public static void main(String[] args) {
        Ponto p1 = new Ponto (1, 1);
        Ponto p2 = new Ponto (5, 10);

        SegmentoReta reta = new SegmentoReta(p1, p2);
        System.out.println(reta);
        System.out.println(reta.calcDeclivio());
        System.out.println(reta.calcLength());

        System.out.println("---");

        p1.moveX(5);
        p1.moveY(-3);

        System.out.println(p1);

        System.out.println(reta);

    }
}
