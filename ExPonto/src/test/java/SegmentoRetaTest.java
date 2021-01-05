import static org.junit.jupiter.api.Assertions.*;

class SegmentoRetaTest {

    @org.junit.jupiter.api.Test
    void calcLength() {
        Ponto p1 = new Ponto (1, 1);
        Ponto p2 = new Ponto (2, 2);

        SegmentoReta reta = new SegmentoReta(p1, p2);

        double expected = 1.4142;

        double result = reta.calcLength();

        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void calcDeclivio() {
        Ponto p1 = new Ponto (1, 1);
        Ponto p2 = new Ponto (2, 2);

        SegmentoReta reta = new SegmentoReta(p1, p2);

        double expected = 1;

        double result = reta.calcDeclivio();

        assertEquals(expected, result);
    }
}