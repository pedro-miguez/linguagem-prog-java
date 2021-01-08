public class Realizador {

    private String nome;
    private String nacionalidade;
    private Data dataNascimento;

    public Realizador(String nome, String nacionalidade, Data dataNascimento) {
        this.setNome(nome);
        this.setNacionalidade(nacionalidade);
        this.setDataNascimento(dataNascimento);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
