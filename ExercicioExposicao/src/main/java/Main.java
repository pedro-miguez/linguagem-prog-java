import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Quadro q1 = new Quadro("Lonamisa", "VaDinci", 666);
        Quadro q2 = new Quadro("Banboogie", "Alternor", 1321);
        Quadro q3 = new Quadro("Suor Lacrimosso", "Kaisen Oni", 1897);
        Quadro q4 = new Quadro("Alternativa Eclesiastica", "Ken Kenny", 1977);
        Quadro q5 = new Quadro("Chamas no Tejo", "Miguel Miguel", 2005);

        Exposicao e1 = new Exposicao("Exposicao Contemporanea num WC", 2020);
        Exposicao e2 = new Exposicao("Sustainable Damage", 2030);
        Exposicao e3 = new Exposicao("Felicidade Profana", 2009);

        e1.addQuadro(q1);
        e1.addQuadro(q2);
        e1.addQuadro(q3);
        e1.addQuadro(q4);
        e1.addQuadro(q5);

        e2.addQuadro(q3);
        e2.addQuadro(q1);
        e2.addQuadro(q4);

        e3.addQuadro(q5);
        e3.addQuadro(q4);
        e3.addQuadro(q1);

        ArrayList<Exposicao> listaExposicoes = new ArrayList<Exposicao>();
        listaExposicoes.add(e1);
        listaExposicoes.add(e2);
        listaExposicoes.add(e3);

        ArrayList<Quadro> listaQuadros = new ArrayList<Quadro>();
        listaQuadros.add(q1);
        listaQuadros.add(q2);
        listaQuadros.add(q3);

        listar(listaQuadros);

        listar(listaExposicoes);

        q2.setDesignacao("Boomboogey");
        System.out.println(listaQuadros);

        Collections.sort(listaExposicoes);
        Collections.reverse(listaExposicoes);
        listar(listaExposicoes);

        e3.removeQuadro(q1);
        System.out.println(e3);

    }


    private static void listar(List lista) {
        for (Object o : lista) {
            System.out.println(o);
        }
    }
}
