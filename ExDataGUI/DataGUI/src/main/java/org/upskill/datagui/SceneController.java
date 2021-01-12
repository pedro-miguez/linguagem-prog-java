/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.upskill.datagui;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void diaSemanaAction(ActionEvent actionEvent) {
    }

    public void dataExtensoAction(ActionEvent actionEvent) {
    }

    public void limparAction(ActionEvent actionEvent) {
    }
}
