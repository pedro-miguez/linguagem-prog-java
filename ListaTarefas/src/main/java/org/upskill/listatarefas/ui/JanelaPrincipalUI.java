package org.upskill.listatarefas.ui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.*;
import org.upskill.listatarefas.controller.AplicacaoController;
import org.upskill.listatarefas.model.Tarefa;

import javax.management.InstanceAlreadyExistsException;

public class JanelaPrincipalUI implements Initializable {

    public MenuItem menuItemAdicionarTarefas;
    public MenuItem menuItemLimparTarefas;
    public MenuItem guardarTextoMenuItem;
    public MenuItem serializarMenuItem;
    public Menu removerMenuItem;
    public MenuItem importarTextoMenuItem;

    @FXML
    private ListView<Tarefa> listViewTarefas;
    private ObservableList<Tarefa> obsListTarefas;
    private AplicacaoController appController;
    private Stage adicionarTarefaUIStage;

    private static final String CABECALHO_IMPORTAR = "Importar Lista.";
    private static final String CABECALHO_EXPORTAR = "Exportar Lista.";

    private static final int SERIALIZACAO = 1;
    private static final String DESCRICAO_SERIALIZACAO = "Ficheiro Lista Tarefas";
    private static final String EXTENSAO_SERIALIZACAO = "*.ser";

    private static final int TEXTO = 2;
    private static final String DESCRICAO_TEXTO = "Ficheiro de Texto";
    private static final String EXTENSAO_TEXTO = "*.txt";


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AdicionarTarefaScene.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            adicionarTarefaUIStage = new Stage();
            adicionarTarefaUIStage.initModality(Modality.APPLICATION_MODAL);
            adicionarTarefaUIStage.setTitle("Nova Tarefa");
            adicionarTarefaUIStage.setResizable(false);
            adicionarTarefaUIStage.setScene(scene);

            appController = new AplicacaoController();
            atualizarListViewListaTarefas();


            AdicionarTarefaUI adicionarTarefaUI = loader.getController();
            adicionarTarefaUI.associarParentUI(this);
        } catch (IOException ex) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, MainApp.TITULO_APLICACAO, "Erro.", ex.getMessage());
        }
    }


    public AplicacaoController getAplicacaoController() {
        return appController;
    }

    @FXML
    private void adicionarTarefaAction(ActionEvent event) throws IOException {
        adicionarTarefaUIStage.show();
    }

    public void atualizarListViewListaTarefas(){
        listViewTarefas.getItems().setAll(appController.getListaTarefas());
    }

    @FXML
    private void limparTarefasAction(ActionEvent event) {
        getRemoverMenuItem().setDisable(true);
        getAplicacaoController().eliminarTarefas();
        atualizarListViewListaTarefas();

    }

    @FXML
    private void teclaPressionadaAction(KeyEvent event) {
        if (event.isShortcutDown()) {
            switch (event.getCode()){
                case Z:
                    appController.eliminarUltimaTarefa();
                    atualizarListViewListaTarefas();
                    break;
                case O:
                    listViewTarefas.getItems().setAll(appController.getListaTarefas());
                    break;
                case P:
                    listViewTarefas.getItems().setAll(appController.getListaTarefasPorPrioridade());
                    break;
            }
        }
    }


    public void guardarTextoAction(ActionEvent actionEvent) {
        exportarLista(TEXTO);
    }

    public void importarTextoAction(ActionEvent actionEvent) throws InstanceAlreadyExistsException {
        importarLista(TEXTO);
    }

    public void serializarAction(ActionEvent actionEvent) {
        exportarLista(SERIALIZACAO);
    }

    public void desserializarAction(ActionEvent actionEvent) throws InstanceAlreadyExistsException {
        importarLista(SERIALIZACAO);
    }

    public void sairAction(ActionEvent actionEvent) {
        Window window = listViewTarefas.getScene().getWindow();
        window.fireEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    public Menu getRemoverMenuItem() {
        return removerMenuItem;
    }



    private void importarLista(int tipoFicheiro) throws InstanceAlreadyExistsException {
        String descricao, extensao;

        switch (tipoFicheiro) {
            case SERIALIZACAO:
                descricao = DESCRICAO_SERIALIZACAO;
                extensao = EXTENSAO_SERIALIZACAO;
                break;
            case TEXTO:
                descricao = DESCRICAO_TEXTO;
                extensao = EXTENSAO_TEXTO;
                break;

            default:
                throw new IllegalArgumentException("Tipo de ficheiro desconhecido.");

        }

        FileChooser flChooser = FileChooserListaTarefasUI.criarFileChooserListaTelefonica(descricao, extensao);
        File ficheiroImportar = flChooser.showOpenDialog(listViewTarefas.getScene().getWindow());

        if (ficheiroImportar != null) {
            int numeroTarefasImportadas = 0;

            switch (tipoFicheiro) {
                case SERIALIZACAO:
                    numeroTarefasImportadas = appController.desserializar(ficheiroImportar);
                    break;
                case TEXTO:
                    numeroTarefasImportadas = appController.importarTexto(ficheiroImportar);
                    break;
            }

            if (numeroTarefasImportadas > 0) {
                atualizarListViewListaTarefas();

                AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, MainApp.TITULO_APLICACAO, CABECALHO_IMPORTAR,
                        String.format("%d tarefa(s) importada(s).", numeroTarefasImportadas)).show();
            } else {
                AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, MainApp.TITULO_APLICACAO, CABECALHO_IMPORTAR,
                        "Ficheiro sem tarefas para importar!").show();
            }
        } else {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, MainApp.TITULO_APLICACAO, CABECALHO_IMPORTAR,
                    "Não foi seleccionado nenhum ficheiro!").show();
        }
    }

    private void exportarLista(int tipoFicheiro) {
        String descricao, extensao;

        switch (tipoFicheiro) {
            case SERIALIZACAO:
                descricao = DESCRICAO_SERIALIZACAO;
                extensao = EXTENSAO_SERIALIZACAO;
                break;

            case TEXTO:
                descricao = DESCRICAO_TEXTO;
                extensao = EXTENSAO_TEXTO;
                break;

            default:
                throw new IllegalArgumentException("Tipo de ficheiro desconhecido.");
        }

        FileChooser flChooser = FileChooserListaTarefasUI.criarFileChooserListaTelefonica(descricao, extensao);
        File ficheiroExportar = flChooser.showSaveDialog(listViewTarefas.getScene().getWindow());

        if (ficheiroExportar != null) {
            boolean gravou = false;

            switch (tipoFicheiro) {
                case SERIALIZACAO:
                    gravou = appController.serializar(ficheiroExportar);
                    break;

                case TEXTO:
                    gravou = appController.exportarTexto(ficheiroExportar);
                    break;

            }
            if (gravou) {
                AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, MainApp.TITULO_APLICACAO, CABECALHO_EXPORTAR,
                        "Tarefas exportadas com sucesso.").show();
            } else {
                AlertaUI.criarAlerta(Alert.AlertType.ERROR, MainApp.TITULO_APLICACAO, CABECALHO_EXPORTAR,
                        "Problema a exportar a lista de tarefas!").show();
            }
        } else {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, MainApp.TITULO_APLICACAO, CABECALHO_EXPORTAR,
                    "Não foi seleccionado nenhum ficheiro!").show();
        }
    }

    public void abrirMenuTarefaAction(Event actionEvent) {
        removerMenuItem.setDisable(appController.listaVazia());
    }

    public void abrirMenuFicheirosAction(Event actionEvent) {
        guardarTextoMenuItem.setDisable(appController.listaVazia());
        serializarMenuItem.setDisable(appController.listaVazia());
    }
}
