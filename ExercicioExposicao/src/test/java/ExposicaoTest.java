import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExposicaoTest {

    @Test
    void removeQuadro() {
        Quadro q1 = new Quadro("Lonamisa", "VaDinci", 666);
        Exposicao e1 = new Exposicao("Exposicao Contemporanea num WC", 2020);

        e1.addQuadro(q1);

        assertTrue(e1.removeQuadro(q1));

    }

    @Test
    void testEquals() {
        Exposicao e1 = new Exposicao("Exposicao Contemporanea num WC", 2020);
        Exposicao e2 = new Exposicao("Exposicao Contemporanea num WC", 2020);

        boolean expected = true;
        boolean result = e1.equals(e2);

        assertEquals(expected, result);
    }

    @Test
    void compareTo() {
        Exposicao e1 = new Exposicao("Exposicao Contemporanea num WC", 2020);
        Exposicao e2 = new Exposicao("Exposicao Contemporanea num WC", 2028);

        int expected = -1;
        int result = e1.compareTo(e2);

        assertEquals(expected, result);
    }
}