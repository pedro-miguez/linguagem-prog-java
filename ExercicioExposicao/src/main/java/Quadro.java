import java.util.Objects;

public class Quadro implements Comparable<Quadro>{

    private String designacao;
    private String nomeAutor;
    private int anoCriacao;

    private final static String DESIGNACAO_OMIT = "Sem designação";
    private final static String NOMEAUTOR_OMITT = "Sem nome";
    private final static int ANOCRIACAO_OMITT = 0;

    public Quadro (String designacao, String nomeAutor, int anoCriacao) {
        setDesignacao(designacao);
        setNomeAutor(nomeAutor);
        setAnoCriacao(anoCriacao);
    }

    public Quadro (Quadro outroQuadro) {
        setDesignacao(outroQuadro.getDesignacao());
        setNomeAutor(outroQuadro.getNomeAutor());
        setAnoCriacao(outroQuadro.getAnoCriacao());
    }

    public Quadro () {
        setDesignacao(DESIGNACAO_OMIT);
        setNomeAutor(NOMEAUTOR_OMITT);
        setAnoCriacao(ANOCRIACAO_OMITT);
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public int getAnoCriacao() {
        return anoCriacao;
    }

    public void setAnoCriacao(int anoCriacao) {
        this.anoCriacao = anoCriacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quadro quadro = (Quadro) o;
        return getAnoCriacao() == quadro.getAnoCriacao() &&
                getDesignacao().equals(quadro.getDesignacao()) &&
                getNomeAutor().equals(quadro.getNomeAutor());
    }

    @Override
    public int compareTo(Quadro o) {
        return this.getNomeAutor().compareToIgnoreCase(o.getNomeAutor());
    }

    @Override
    public String toString() {
        return "Quadro{" +
                "designacao= '" + designacao + '\'' +
                ", nomeAutor= '" + nomeAutor + '\'' +
                ", anoCriacao= " + anoCriacao +
                '}';
    }
}
