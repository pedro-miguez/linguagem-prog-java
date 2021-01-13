package org.upskill.listatarefas.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

public class JanelaPrincipalSceneController implements Initializable {

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
        // TODO
    }    

    @FXML
    private void adicionarTarefaAction(ActionEvent event) {
    }

    @FXML
    private void limparTarefasAction(ActionEvent event) {
    }

    @FXML
    private void teclaPressionadaAction(KeyEvent event) {
    }
    
}
