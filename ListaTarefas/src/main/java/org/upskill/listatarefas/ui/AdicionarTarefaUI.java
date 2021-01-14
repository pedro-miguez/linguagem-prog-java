package org.upskill.listatarefas.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import org.upskill.listatarefas.controller.AplicacaoController;
import org.upskill.listatarefas.model.Prioridade;
import org.upskill.listatarefas.model.Tarefa;

import javax.management.InstanceAlreadyExistsException;

public class AdicionarTarefaUI implements Initializable {

    private JanelaPrincipalUI janelaPrincipalUI;

    public void associarParentUI(JanelaPrincipalUI janelaPrincipalUI) {
        this.janelaPrincipalUI = janelaPrincipalUI;
    }

    @FXML
    private Button btnCriarTarefa;
    @FXML
    private Button btnCancelar;
    @FXML
    private Label lblTarefa;
    @FXML
    private Label lblPrioridade;
    @FXML
    private TextField txtTarefa;
    @FXML
    private ComboBox<Prioridade> cmbPrioridade;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmbPrioridade.getItems().setAll(Prioridade.values());
    }    

    @FXML
    private void criarTarefaAction(ActionEvent event) {
        try {
            AplicacaoController appController = janelaPrincipalUI.getAplicacaoController();

            boolean added = appController.adicionarTarefa(txtTarefa.getText(), cmbPrioridade.getValue());

            if (added) {
                janelaPrincipalUI.atualizarListViewListaTarefas();
                janelaPrincipalUI.getRemoverMenuItem().setDisable(false);
            }
            AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, MainApp.TITULO_APLICACAO, "Adicionar Tarefa.",
                    added ? "Tarefa adicionada com sucesso."
                            : "Não foi possível adicionar a tarefa.").show();

            encerrarAdicionarTarefaUI(event);

        } catch (InstanceAlreadyExistsException | IllegalArgumentException iae) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, MainApp.TITULO_APLICACAO, "Erro nos dados.",
                    iae.getMessage()).show();
        }

    }

    @FXML
    private void cancelarAction(ActionEvent event) {
        encerrarAdicionarTarefaUI(event);
    }

    private void encerrarAdicionarTarefaUI(ActionEvent event) {
        this.txtTarefa.clear();
        cmbPrioridade.setValue(Prioridade.BAIXA);

        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    
}
