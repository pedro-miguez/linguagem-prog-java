package ui;

import controller.AppController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Atleta;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class JanelaPrincipalUI implements Initializable {

    public Menu menuSerializar;
    public Menu menuExportarTexto;
    public ListView<Atleta> listViewAtletas;

    private AppController appController;

    private static final String CABECALHO_IMPORTAR = "Importar Lista.";
    private static final String CABECALHO_EXPORTAR = "Exportar Lista.";

    private static final int SERIALIZACAO_FICHEIRO = 1;
    private static final String DESCRICAO_SERIALIZACAO = "Ficheiro Lista Tarefas";
    private static final String EXTENSAO_SERIALIZACAO = "*.ser";

    private static final int TEXTO_FICHEIRO = 2;
    private static final String DESCRICAO_TEXTO = "Ficheiro de Texto";
    private static final String EXTENSAO_TEXTO = "*.txt";

    private static final int SERIALIZACAO_AUTO = 3;

    private static final int TEXTO_AUTO = 4;

    private static final int SERIALIZACAO_PRO = 5;

    private static final int TEXTO_PRO = 5;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AdicionarTarefaScene.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            appController = new AppController();
            atualizarListViewListaAtletas();

        } catch (IOException ex) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, MainApp.TITULO_APLICACAO, "Erro.", ex.getMessage());
        }
    }

    private void atualizarListViewListaAtletas() {
        listViewAtletas.getItems().setAll(appController.getListaAtletas());
    }

    public AppController getAppController() {
        return appController;
    }


    public void menuShowingAction(Event event) {
    }






    //importar
    public void importarTextoTodos(ActionEvent actionEvent) {
    }

    public void importarTextoProfissional(ActionEvent actionEvent) {
    }

    public void importarTextoFicheiroTodos(ActionEvent actionEvent) {
    }


    //exportar
    public void exportarTextoProfissional(ActionEvent actionEvent) {
    }

    public void exportarTextoTodos(ActionEvent actionEvent) {
    }

    public void exportarTextoTodosFicheiro(ActionEvent actionEvent) {
    }


    //serializar
    public void serializarTodos(ActionEvent actionEvent) {
    }

    public void serializarProfissional(ActionEvent actionEvent) {
    }

    public void serializarTodosFicheiro(ActionEvent actionEvent) {
    }


    //desserializar
    public void desserializarTodos(ActionEvent actionEvent) {
    }

    public void desserializarProfissional(ActionEvent actionEvent) {
    }

    public void desserializarFicheiro(ActionEvent actionEvent) {
    }


    public void sairAction(ActionEvent actionEvent) {
    }

    //métodos de import/export
    private void importarListaFicheiro(int tipoFicheiro) {
        String descricao, extensao;

        switch (tipoFicheiro) {
            case SERIALIZACAO_FICHEIRO:
                descricao = DESCRICAO_SERIALIZACAO;
                extensao = EXTENSAO_SERIALIZACAO;
                break;
            case TEXTO_FICHEIRO:
                descricao = DESCRICAO_TEXTO;
                extensao = EXTENSAO_TEXTO;
                break;

            default:
                throw new IllegalArgumentException("Tipo de ficheiro desconhecido.");
        }

        FileChooser flChooser = FileChooserListaAtletasUI.criarFileChooserListaAtletas(descricao, extensao);
        File ficheiroImportar = flChooser.showOpenDialog(listViewAtletas.getScene().getWindow());

        if (ficheiroImportar != null) {
            int numeroTarefasImportadas = 0;

            switch (tipoFicheiro) {
                case SERIALIZACAO_FICHEIRO:
                    numeroTarefasImportadas = appController.desserializarFicheiroEscolhido(ficheiroImportar);
                    break;
                case TEXTO_FICHEIRO:
                    numeroTarefasImportadas = appController.importarTextoFicheiroEscolhido(ficheiroImportar);
                    break;
            }

            if (numeroTarefasImportadas > 0) {
                atualizarListViewListaAtletas();

                AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, MainApp.TITULO_APLICACAO, CABECALHO_IMPORTAR,
                        String.format("%d atleta(s) importado(s).", numeroTarefasImportadas)).show();
            } else {
                AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, MainApp.TITULO_APLICACAO, CABECALHO_IMPORTAR,
                        "Ficheiro sem atletas para importar!").show();
            }
        } else {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, MainApp.TITULO_APLICACAO, CABECALHO_IMPORTAR,
                    "Não foi seleccionado nenhum ficheiro!").show();
        }
    }



}
