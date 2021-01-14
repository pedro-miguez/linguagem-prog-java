package org.upskill.listatarefas.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.tools.javac.util.Context;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.upskill.listatarefas.controller.AplicacaoController;
import org.upskill.listatarefas.model.Tarefa;

public class JanelaPrincipalUI implements Initializable {

    public MenuItem menuItemAdicionarTarefas;
    public MenuItem menuItemLimparTarefas;
    public MenuItem guardarTextoMenuItem;
    public MenuItem serializarMenuItem;
    private Menu removerMenuItem;

    @FXML
    private ListView<Tarefa> listViewTarefas;
    private ObservableList<Tarefa> obsListTarefas;
    private AplicacaoController appController;
    private Stage adicionarTarefaUIStage;


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
            obsListTarefas = FXCollections.observableArrayList(appController.getListaTarefas());
            listViewTarefas = new ListView<Tarefa>(obsListTarefas);

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
        listViewTarefas.refresh();
    }



    @FXML
    private void limparTarefasAction(ActionEvent event) {
        getRemoverMenuItem().setDisable(true);
        getAplicacaoController().eliminarTarefas();

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
                    obsListTarefas = (ObservableList<Tarefa>) appController.getListaTarefas();
                    break;
                case P:
                    obsListTarefas = (ObservableList<Tarefa>) appController.getListaTarefasPorPrioridade();
                    break;
            }
        }
    }


    public void guardarTextoAction(ActionEvent actionEvent) {
    }

    public void serializarAction(ActionEvent actionEvent) {
    }

    public void desserializarAction(ActionEvent actionEvent) {
    }

    public void sairAction(ActionEvent actionEvent) {
    }

    public Menu getRemoverMenuItem() {
        return removerMenuItem;
    }
}
