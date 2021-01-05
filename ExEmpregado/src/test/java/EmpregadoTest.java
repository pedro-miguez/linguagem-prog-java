import static org.junit.jupiter.api.Assertions.*;

class EmpregadoTest {

    @org.junit.jupiter.api.Test
    void calcularHorasSemanais() {
        Tempo t1 = new Tempo(10, 0 ,0);
        Tempo t2 = new Tempo(11, 0 ,0);
        Data d1 = new Data(2010, 1, 1);
        Empregado e1 = new Empregado("Maria", "maria", d1, t1, t2);

        double expected = 5;
        double result = e1.calcularHorasSemanais();

        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void calcularDiasContratado() {
        Tempo t1 = new Tempo(10, 0 ,0);
        Tempo t2 = new Tempo(11, 0 ,0);
        Data d1 = new Data(2021, 1, 04);
        Empregado e1 = new Empregado("Maria", "maria", d1, t1, t2);

        double expected = 1;
        double result = e1.calcularDiasContratado();

        assertEquals(expected, result);
    }
}