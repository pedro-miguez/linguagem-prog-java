import static org.junit.jupiter.api.Assertions.*;

class QuadroTest {

    @org.junit.jupiter.api.Test
    void testEquals() {
        Quadro q1 = new Quadro("Lonamisa", "VaDinci", 666);
        Quadro q2 = new Quadro("Lonamisa", "VaDinci", 666);

        boolean expected = true;
        boolean result = q1.equals(q2);

        assertEquals(expected, result);

    }

    @org.junit.jupiter.api.Test
    void compareTo() {
        Quadro q1 = new Quadro("Lonamisa", "AaDinci", 666);
        Quadro q2 = new Quadro("Lonamisa", "BaDinci", 666);

        int expected = -1;
        int result = q1.compareTo(q2);

        assertEquals(expected, result);
    }
}