package org.upskill.listatelefonica.ui;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class FileChooserListaTelefonicaUI {

    private FileChooser fileChooser;

    private FileChooserListaTelefonicaUI(String descricao, String extensao) {
        fileChooser = new FileChooser();

        associarFiltro(descricao, extensao);
    }

    public static FileChooser criarFileChooserListaTelefonica(String descricao, String extensao) {
        FileChooserListaTelefonicaUI fcListaTelefonica = new FileChooserListaTelefonicaUI(descricao, extensao);

        return fcListaTelefonica.fileChooser;
    }

    private void associarFiltro(String descricao, String extensao) {
        ExtensionFilter filtro = new ExtensionFilter(descricao, extensao);
        fileChooser.getExtensionFilters().add(filtro);
    }
}
