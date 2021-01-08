import java.util.ArrayList;
import java.util.List;

public class ListaFilmes {

    private List<Filme> listaDeFilmes;
    private String identificador;

    public ListaFilmes(List<Filme> listaDeFilmes, String identificador) throws IdentificadorInvalidoException {
        this.setListaDeFilmes(listaDeFilmes);
        this.setIdentificador(identificador);
    }

    public ListaFilmes(String identificador) throws IdentificadorInvalidoException {
        this.setIdentificador(identificador);
        this.setListaDeFilmes(new ArrayList<>());
    }

    public List<Filme> getListaDeFilmes() {
        return new ArrayList<>(listaDeFilmes);
    }

    public void setListaDeFilmes(List<Filme> listaDeFilmes) {
        this.listaDeFilmes = new ArrayList<>(listaDeFilmes);
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) throws IdentificadorInvalidoException {
        char c = identificador.charAt(0);

        if (!Character.isUpperCase(c)) {
            throw new IdentificadorInvalidoException("Identificador tem de comecar com uma letra maiuscula: " + identificador);
        }
        this.identificador = identificador;
    }
}
