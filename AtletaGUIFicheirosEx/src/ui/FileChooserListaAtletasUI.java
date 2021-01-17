package ui;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class FileChooserListaAtletasUI {

    private FileChooser fileChooser;

    private FileChooserListaAtletasUI(String descricao, String extensao) {
        fileChooser = new FileChooser();

        associarFiltro(descricao, extensao);
    }

    public static FileChooser criarFileChooserListaAtletas(String descricao, String extensao) {
        FileChooserListaAtletasUI fcListaTelefonica = new FileChooserListaAtletasUI(descricao, extensao);

        return fcListaTelefonica.fileChooser;
    }

    private void associarFiltro(String descricao, String extensao) {
        ExtensionFilter filtro = new ExtensionFilter(descricao, extensao);
        fileChooser.getExtensionFilters().add(filtro);
    }
}
