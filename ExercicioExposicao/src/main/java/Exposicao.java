import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exposicao implements Comparable<Exposicao>  {

    private String designacao;
    private int anoExposicao;
    private List<Quadro> listaQuadros;

    private final static String DESIGNACAO_OMIT = "Sem designação";
    private final static int ANOEXPOSICAO = 0;

    public Exposicao(String designacao, int anoExposicao, List<Quadro> listaQuadros) {
        this.setDesignacao(designacao);
        this.setAnoExposicao(anoExposicao);
        this.setListaQuadros(listaQuadros);
    }

    public Exposicao(String designacao, int anoExposicao) {
        this.setDesignacao(designacao);
        this.setAnoExposicao(anoExposicao);
        this.setListaQuadros(new ArrayList<>());
    }

    public Exposicao() {
        this.setDesignacao(DESIGNACAO_OMIT);
        this.setAnoExposicao(ANOEXPOSICAO);
        listaQuadros = new ArrayList<>();
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public int getAnoExposicao() {
        return anoExposicao;
    }

    public void setAnoExposicao(int anoExposicao) {
        this.anoExposicao = anoExposicao;
    }

    public List<Quadro> getListaQuadros() {
        return new ArrayList<>(listaQuadros);
    }

    public void setListaQuadros(List<Quadro> listaQuadros) {
        this.listaQuadros = new ArrayList<Quadro>(listaQuadros);
    }

    public boolean addQuadro (Quadro q) {
        if (!listaQuadros.contains(q)) {
            return listaQuadros.add(q);
        } else {
            return false;
        }
    }

    public boolean removeQuadro (Quadro q) {
        return listaQuadros.remove(q);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exposicao exposicao = (Exposicao) o;
        return getAnoExposicao() == exposicao.getAnoExposicao() &&
                getDesignacao().equals(exposicao.getDesignacao()) &&
                getListaQuadros().equals(exposicao.getListaQuadros());
    }

    @Override
    public int compareTo(Exposicao o) {
        return Integer.compare(this.getAnoExposicao(), o.getAnoExposicao());
    }

    @Override
    public String toString() {
        return "Exposicao{" +
                "designacao='" + designacao + '\'' +
                ", anoExposicao=" + anoExposicao +
                ", listaQuadros: \n" + ordernarDesignacoesAutor(listaQuadros) +
                '}';
    }

    public StringBuilder ordernarDesignacoesAutor (List<Quadro> listaQuadros) {
        Collections.sort(listaQuadros);
        StringBuilder designacaoOrdenada = new StringBuilder();
        for (Quadro q : listaQuadros) {
            designacaoOrdenada.append(q.getDesignacao()).append("\n");
        }
        return designacaoOrdenada;
    }
}
