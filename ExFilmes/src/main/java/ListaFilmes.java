import java.util.ArrayList;
import java.util.List;

public class ListaFilmes {

    private List<Filme> listaDeFilmes;
    private String identificador;

    public ListaFilmes(List<Filme> listaDeFilmes, String identificador) {
        this.setListaDeFilmes(listaDeFilmes);
        this.setIdentificador(identificador);
    }

    public List<Filme> getListaDeFilmes() {
        return new ArrayList<Filme>(listaDeFilmes);
    }

    public void setListaDeFilmes(List<Filme> listaDeFilmes) {
        this.listaDeFilmes = new ArrayList<Filme>(listaDeFilmes);
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
}
