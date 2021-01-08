public class Filme {

    private String titulo;
    private Data anoRealizacao;
    private String realizador;
    private Categoria categoria;

    public Filme (String titulo, Data anoRealizacao, String realizador, Categoria categoria ) throws AnoInvalidoException, CategoriaInvalidaException {
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

    public void setAnoRealizacao(Data anoRealizacao) throws AnoInvalidoException {
        Data dataMinima = new Data(1850, 1 , 1);
        if (!anoRealizacao.isMaior(dataMinima)) {
            throw new AnoInvalidoException("Ano de Realizacao tem de ser superior a 1850");
        } else if (anoRealizacao.isMaior(Data.dataAtual())) {
            throw new AnoInvalidoException("Ano de Realizacao tem de ser inferior a data actual");
        }
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

    public void setCategoria(Categoria categoria) throws CategoriaInvalidaException {
        boolean encontrada = false;
        for (Categoria c : Categoria.values()) {
            if (categoria == c) {
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            throw new CategoriaInvalidaException("Categoria Invalida");
        }
        this.categoria = categoria;
    }
}
