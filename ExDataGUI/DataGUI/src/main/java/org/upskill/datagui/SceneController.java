/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.upskill.datagui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import org.upskill.datagui.model.Data;
import org.upskill.datagui.model.DiaInvalidoException;
import org.upskill.datagui.model.MesInvalidoException;

/**
 * FXML Controller class
 *
 * 
 */
public class SceneController implements Initializable {

    public Button btnDiaSemana;
    public Button btnDataExtenso;
    public Button btnLimpar;
    public TextField txtDiaSemana;
    public TextField txtData;
    public Label dataExtensoLbl;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void diaSemanaAction(ActionEvent actionEvent) {
        validarCriarData(txtData.getText(), actionEvent);
    }

    public void dataExtensoAction(ActionEvent actionEvent) {
        validarCriarData(txtData.getText(), actionEvent);

    }

    public void limparAction(ActionEvent actionEvent) {
        txtDiaSemana.clear();
        txtData.clear();
        dataExtensoLbl.setText("");
        txtData.requestFocus();
    }

    public void validarCriarData(String data, ActionEvent event) throws MesInvalidoException, DiaInvalidoException {
        Data d1 = new Data();

        try {
            if (validarData(data)) {
                int ano = Integer.parseInt(data.split("/")[0]);
                int mes = Integer.parseInt(data.split("/")[1]);
                int dia = Integer.parseInt(data.split("/")[2]);
                d1.setData(ano, mes, dia);
                if (event.getSource() == btnDataExtenso) {
                    dataExtensoLbl.setText(d1.toString());
                } else if (event.getSource() == btnDiaSemana) {
                    txtDiaSemana.setText(d1.diaDaSemana());
                } else if (event.getSource() == txtData) {
                    dataExtensoLbl.setText(d1.toString());
                    txtDiaSemana.setText(d1.diaDaSemana());
                }
            } else {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Erro");
                alert1.setHeaderText("Data é inválida!");
                alert1.showAndWait();
                limparAction(event);
            }
        } catch (DiaInvalidoException | MesInvalidoException e) {
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Erro");
            alert1.setHeaderText(e.getMessage());
            alert1.showAndWait();
            limparAction(event);

        }

    }

    private boolean validarData(String data) {
        if (data.length() != 10) {
            return false;
        } else return data.split("/").length == 3;
    }

    public void showAllDatas(ActionEvent actionEvent) {
        validarCriarData(txtData.getText(), actionEvent);
    }
}
