import org.junit.jupiter.api.Test;
import sprint.clube.desportivo.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ClubeDesportivoTest {

    @Test
    void testAddAtleta() {
        ClubeDesportivo test = new ClubeDesportivo("Sitio", "Ontem", new ArrayList<Atleta>());
        AtletaAmador a1 = new AtletaAmador();
        int expected = 1;
        test.addAtleta(a1);

        int result = test.getAtletasInscritos().size();

        assertEquals(expected, result);
    }

    @Test
    void testGetNomeClube() {
        ClubeDesportivo test = new ClubeDesportivo("Sitio", "Ontem", new ArrayList<Atleta>());
        String expected = "Sitio";
        String result = test.getNomeClube();

        assertEquals(expected, result);
    }

    @Test
    void testGetSortedByName() {
        AtletaAmador a1 = new AtletaAmador("Joana", 123, 20, 60, 100,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 21);
        AtletaAmador a2 = new AtletaAmador("Andrade", 123, 20, 60, 100,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 21);
        AtletaAmador a3 = new AtletaAmador("Zelda", 123, 20, 60, 100,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 21);
        ClubeDesportivo test = new ClubeDesportivo("Sitio", "Ontem", new ArrayList<Atleta>());
        test.addAtleta(a1);
        test.addAtleta(a2);
        test.addAtleta(a3);

        ArrayList<Atleta> expected = new ArrayList<Atleta>();
        expected.add(a2);
        expected.add(a1);
        expected.add(a3);

        ArrayList<Atleta> result = test.getSortedByName();

        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    void testGetReverseSortedByPremio() {
        AtletaAmador a1 = new AtletaAmador("Joana", 123, 20, 60, 100,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 21);
        AtletaAmador a2 = new AtletaAmador("Andrade", 123, 20, 60, 99,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 21);
        AtletaAmador a3 = new AtletaAmador("Zelda", 123, 20, 60, 101,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 21);
        ClubeDesportivo test = new ClubeDesportivo("Sitio", "Ontem", new ArrayList<Atleta>());
        test.addAtleta(a3);
        test.addAtleta(a2);
        test.addAtleta(a1);

        ArrayList<Atleta> expected = new ArrayList<Atleta>();
        expected.add(a3);
        expected.add(a1);
        expected.add(a2);

        ArrayList<Atleta> result = test.getReverseSortedByPremio();

        assertEquals(expected, result);
    }

    @Test
    void testGetSortedByTypeThenActivityThenName() {
        AtletaAmador a1 = new AtletaAmador("Joana", 123, 20, 60, 100,
                Genero.MASCULINO, Atividade.CICLISMO, ObjectivoTreino.QUEIMA_GORDURA, 21);
        AtletaAmador a2 = new AtletaAmador("Andrade", 123, 20, 60, 99,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 21);
        AtletaProfissional a3 = new AtletaProfissional("Zelda", 123, 20, 60, 101,
                Genero.MASCULINO, Atividade.NATACAO, ObjectivoTreino.QUEIMA_GORDURA, 100);
        AtletaProfissional a4 = new AtletaProfissional("Velda", 123, 20, 60, 101,
                Genero.MASCULINO, Atividade.NATACAO, ObjectivoTreino.QUEIMA_GORDURA, 100);
        AtletaSemiProfissional a5 = new AtletaSemiProfissional("Velda", 123, 20, 60, 101,
                Genero.MASCULINO, Atividade.NATACAO, ObjectivoTreino.QUEIMA_GORDURA, 100);
        ClubeDesportivo test = new ClubeDesportivo("Sitio", "Ontem", new ArrayList<Atleta>());
        test.addAtleta(a3);
        test.addAtleta(a2);
        test.addAtleta(a1);
        test.addAtleta(a4);
        test.addAtleta(a5);

        ArrayList<Atleta> expected = new ArrayList<Atleta>();
        expected.add(a2);
        expected.add(a1);
        expected.add(a4);
        expected.add(a3);
        expected.add(a5);

        ArrayList<Atleta> result = test.getSortedByTypeThenActivityThenName();

        assertEquals(expected, result);
    }

    
    @Test
    void testCalcularValorTotalIRS(){
        AtletaAmador a1 = new AtletaAmador("Joana", 123, 20, 60, 100,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 21);
        AtletaProfissional a2 = new AtletaProfissional("Andrade", 123, 20, 60, 100,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 1500);
        AtletaSemiProfissional a3 = new AtletaSemiProfissional("Zelda", 123, 20, 60, 100,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 21);
        ClubeDesportivo test = new ClubeDesportivo("Sitio", "Ontem", new ArrayList<Atleta>());
        test.addAtleta(a1);
        test.addAtleta(a2);
        test.addAtleta(a3);
        
        double expectedResult = 160;
        
        double result = test.calcularValorTotalIRS(test.getAtletasInscritos());
        
        assertEquals(expectedResult, result);
    }

    @Test
    void testEqualsTrue(){
        ClubeDesportivo test = new ClubeDesportivo("Sitio", "Ontem", new ArrayList<Atleta>());
        ClubeDesportivo test2 = new ClubeDesportivo("Sitio", "Ontem", new ArrayList<Atleta>());

        assertEquals(test2, test);
    }

    @Test
    void testEqualsFalse(){
        ClubeDesportivo test = new ClubeDesportivo("Sitio", "Ontem", new ArrayList<Atleta>());
        ClubeDesportivo test2 = new ClubeDesportivo("Siio", "Onte", new ArrayList<Atleta>());

        assertNotEquals(test2, test);
    }



}