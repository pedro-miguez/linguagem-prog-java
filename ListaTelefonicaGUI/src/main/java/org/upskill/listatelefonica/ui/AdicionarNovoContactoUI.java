package org.upskill.listatelefonica.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.upskill.listatelefonica.controller.AplicacaoController;

public class AdicionarNovoContactoUI implements Initializable {
    private JanelaPrincipalUI janelaPrincipalUI;

    @FXML
    private TextField txtNome;
    
    @FXML
    private TextField txtTelefone;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void associarParentUI(JanelaPrincipalUI janelaPrincipalUI) {
        this.janelaPrincipalUI = janelaPrincipalUI;
    }

    @FXML
    private void btnAdicionarAction(ActionEvent event) {
        try {
            AplicacaoController appController = janelaPrincipalUI.getAplicacaoController();
            
            boolean adicionou = appController.adicionarContactoTelefonico(
                                    txtNome.getText().trim(),
                                    Integer.parseInt(txtTelefone.getText()));
            if (adicionou) {
                janelaPrincipalUI.atualizaTextAreaListaTelefonica();
            }
            
            AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, MainApp.TITULO_APLICACAO, "Adicionar novo contacto.",
                    adicionou ? "Contacto adicionado com sucesso."
                    : "Não foi possível adicionar o contacto.").show();

            encerrarNovoContactoUI(event);
        } catch (NumberFormatException nfe) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, MainApp.TITULO_APLICACAO, "Erro nos dados.",
                    "Introduza um valor numérico para telefone!").show();
        } catch (IllegalArgumentException iae) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, MainApp.TITULO_APLICACAO, "Erro nos dados.",
                    iae.getMessage()).show();
        }
    }

    @FXML
    private void btnCancelarAction(ActionEvent event) {
        encerrarNovoContactoUI(event);
    }

    private void encerrarNovoContactoUI(ActionEvent event) {
        this.txtNome.clear();
        this.txtTelefone.clear();
        
        ((Node) event.getSource()).getScene().getWindow().hide();
    }
}