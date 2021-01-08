import java.util.List;

public class Main {

    private static final Categoria ROMANCE = null;

    public static void main(String[] args) throws AnoInvalidoException, CategoriaInvalidaException, IdentificadorInvalidoException {
        Data dataAntiga = new Data(1800, 1 , 1);
        Data dataFuturo = new Data(2030, 1, 1);
        Data dataValida = new Data(2000, 1, 1);
        //Filme f1 = new Filme("A", dataAntiga, "ABC", Categoria.ACAO);
        //Filme f2 = new Filme ("B", dataFuturo, "BBC", Categoria.ANIMACAO);
        //Filme f3 = new Filme("C", dataValida, "CCC", ROMANCE);
        //ListaFilmes lf1 = new ListaFilmes("a");
        ListaFilmes lf2 = new ListaFilmes("1");
    }
}
