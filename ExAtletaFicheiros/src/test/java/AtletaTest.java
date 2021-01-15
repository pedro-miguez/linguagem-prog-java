
import org.junit.jupiter.api.Test;
import sprint.clube.desportivo.*;

import static org.junit.jupiter.api.Assertions.*;

class AtletaTest {

    @Test
    void testAddPremio() {
        AtletaAmador a1 = new AtletaAmador();
        a1.addPremio(50);
        int expected = 50;
        int result = (int) a1.getPremioAcumulado();

        assertEquals(expected, result);
    }

    @Test
    void testCalcularPagamentoAmador() {
        AtletaAmador a1 = new AtletaAmador("Joana", 123, 20, 60, 100,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 21);
        double expected = 100 * 0.2 + 100 * 0.07;
        double result = a1.calcularPagamento();

        assertEquals(expected, result, 0.0);
    }

    @Test
    void testCalcularPagamentoAmadorMinimo() {
        AtletaAmador a1 = new AtletaAmador("Joana", 123, 20, 60, 0,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 0);
        double expected = 5;
        double result = a1.calcularPagamento();

        assertEquals(expected, result);
    }

    @Test
    void testCalcularPagamentoProfissional() {
        AtletaProfissional a1 = new AtletaProfissional("Joana", 123, 20, 60, 100,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 100);
        double expected = 100 + (100 * 0.2);
        double result = a1.calcularPagamento();

        assertEquals(expected, result, 0.0);
    }

    @Test
    void testCalcularPagamentoSemiProfissionalAnt15() {
        AtletaSemiProfissional a1 = new AtletaSemiProfissional("Joana", 123, 20, 60, 100,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 15);
        double expected = 100+ (100 * 0.08);
        double result = a1.calcularPagamento();

        assertEquals(expected, result, 0.0);
    }

    @Test
    void testCalcularPagamentoSemiProfissionalAnt25() {
        AtletaSemiProfissional a1 = new AtletaSemiProfissional("Joana", 123, 20, 60, 100,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 25);
        double expected = 100+ (100 * 0.2);
        double result = a1.calcularPagamento();

        assertEquals(expected, result);
    }

    @Test
    void testCalcularPagamentoSemiProfissionalAnt6() {
        AtletaSemiProfissional a1 = new AtletaSemiProfissional("Joana", 123, 20, 60, 100,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 6);
        double expected = 100+ (100 * 0.02);
        double result = a1.calcularPagamento();

        assertEquals(expected, result);
    }

    @Test
    void testCalcularPagamentoSemiProfissionalAnt0() {
        AtletaSemiProfissional a1 = new AtletaSemiProfissional("Joana", 123, 20, 60, 100,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 0);
        double expected = 100;
        double result = a1.calcularPagamento();

        assertEquals(expected, result);
    }

    @Test
    void testFreqCardTrabalhoMasculinoQueimaGordura() {
        AtletaAmador a1 = new AtletaAmador("Joana", 123, 20, 60, 100,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 21);
        double expected = 60 + (0.6 * ((208.75 - (0.73 * 20)) - 60));
        double result = a1.freqCardTrabalho();

        assertEquals(expected, result, 0.0);
    }

    @Test
    void testFreqCardTrabalhoFemininoCardio() {
        AtletaAmador a1 = new AtletaAmador("Joana", 123, 20, 60, 100,
                Genero.FEMININO, Atividade.CICLISMO, ObjectivoTreino.CAPACIDADE_CARDIORESPIRATORIA, 21);
        double expected = 60 + (0.75 * ((189- (0.56 * 20)) - 60));
        double result = a1.freqCardTrabalho();

        assertEquals(expected, result);
    }

    @Test
    void testFreqCardMax() {
        AtletaAmador a1 = new AtletaAmador("Joana", 123, 20, 60, 100,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 21);
        double expected = 208.75 - (0.73 * 20);
        double result = a1.freqCardMax();

        assertEquals(expected, result, 0.0);
    }

    @Test
    void testDeterminarIT() {
        AtletaAmador a1 = new AtletaAmador("Joana", 123, 20, 60, 100,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 21);
        double expected = 0.6;
        double result = a1.determinarIT();

        assertEquals(expected, result, 0.0);

    }

    @Test
    void testEqualsAtletaAmadorTrue() {
        AtletaAmador a1 = new AtletaAmador("Joana", 123, 20, 60, 100,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 21);
        AtletaAmador a2 = new AtletaAmador("Joana", 123, 20, 60, 100,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 21);

        assertEquals(a2, a1);
    }

    @Test
    void testEqualsAtletaAmadorFalse() {
        AtletaAmador a1 = new AtletaAmador("Joana", 123, 20, 60, 100,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 21);
        AtletaAmador a2 = new AtletaAmador("Joana", 123, 20, 60, 100,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 20);

        assertNotEquals(a2, a1);
    }

    @Test
    void testEqualsAtletaProfissonalTrue() {
        AtletaProfissional a1 = new AtletaProfissional("Andrade", 123, 20, 60, 100,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 1500);
        AtletaProfissional a2 = new AtletaProfissional("Andrade", 123, 20, 60, 100,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 1500);

        assertEquals(a2, a1);
    }

    @Test
    void testEqualsAtletaProfissonalFalse() {
        AtletaProfissional a1 = new AtletaProfissional("Andrade", 123, 20, 60, 100,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 1500);
        AtletaProfissional a2 = new AtletaProfissional("Andrade", 123, 20, 60, 100,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 100);

        assertNotEquals(a2, a1);
    }

    @Test
    void testEqualsAtletaSemiProfissonalTrue() {
        AtletaSemiProfissional a1 = new AtletaSemiProfissional("Zelda", 123, 20, 60, 100,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 21);
        AtletaSemiProfissional a2 = new AtletaSemiProfissional("Zelda", 123, 20, 60, 100,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 21);

        assertEquals(a2, a1);
    }

    @Test
    void testEqualsAtletaSemiProfissonalFalse() {
        AtletaSemiProfissional a1 = new AtletaSemiProfissional("Zelda", 123, 20, 60, 100,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 21);
        AtletaSemiProfissional a2 = new AtletaSemiProfissional("Zelda", 123, 20, 60, 100,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 23);

        assertNotEquals(a2, a1);
    }




}