public class Filme {

    private String titulo;
    private Data anoRealizacao;
    private String realizador;
    private Categoria categoria;

    public Filme (String titulo, Data anoRealizacao, String realizador, Categoria categoria ) {
        this.setTitulo(titulo);
        this.setAnoRealizacao(anoRealizacao);
        this.setRealizador(realizador);
        this.setCategoria(categoria);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Data getAnoRealizacao() {
        return anoRealizacao;
    }

    public void setAnoRealizacao(Data anoRealizacao) {
        this.anoRealizacao = anoRealizacao;
    }

    public String getRealizador() {
        return realizador;
    }

    public void setRealizador(String realizador) {
        this.realizador = realizador;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
