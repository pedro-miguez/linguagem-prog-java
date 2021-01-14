package org.upskill.listatarefas.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.tools.javac.util.Context;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.upskill.listatarefas.controller.AplicacaoController;

public class JanelaPrincipalUI implements Initializable {

    private AplicacaoController appController;
    private Stage adicionarTarefaUIStage;

    @FXML
    private Button btnAdicionarTarefas;
    @FXML
    private Button btnLimparTarefas;
    @FXML
    private TextArea txtAreaTarefas;

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

    public void atualizarTextAreaListaTarefas(){
        txtAreaTarefas.setText(appController.getListaTarefas());
    }



    @FXML
    private void limparTarefasAction(ActionEvent event) {
        getBtnLimparTarefas().setDisable(true);
        txtAreaTarefas.clear();
        getAplicacaoController().eliminarTarefas();

    }

    @FXML
    private void teclaPressionadaAction(KeyEvent event) {
        if (event.isShortcutDown()) {
            switch (event.getCode()){
                case Z:
                    appController.eliminarUltimaTarefa();
                    atualizarTextAreaListaTarefas();
                    break;
                case O:
                    atualizarTextAreaListaTarefas();
                    break;
                case P:
                    txtAreaTarefas.setText(appController.getListaTarefasPorPrioridade());
                    break;
            }
        }
    }

    public Button getBtnLimparTarefas() {
        return btnLimparTarefas;
    }
}
