package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    public Button btnLimpar;

    public Button btnConverter;

    public Button btnSair;

    public TextField txtCelcius;

    public TextField txtFahrenheit;

    public void actionConverter(ActionEvent actionEvent) {
        try {
            float celsius = Float.parseFloat(txtCelcius.getText());
            float fahrenheit = (float) (1.8*celsius+32);
            txtFahrenheit.setText(String.valueOf(fahrenheit));
        } catch (NumberFormatException e) {
            Alert alertaNF = new Alert(Alert.AlertType.ERROR);
            alertaNF.setTitle("Celsius");
            alertaNF.setHeaderText("Erro na temperatura Celsius");
            alertaNF.setContentText("Não foi introduzido nenhum valor numérico!");
            alertaNF.showAndWait();
            txtCelcius.requestFocus();
        }

    }

    public void actionLimpar(ActionEvent actionEvent) {
        txtCelcius.clear();
        txtFahrenheit.clear();
        txtCelcius.requestFocus();
    }

    public void actionSair(ActionEvent actionEvent) {
        Alert alertaNF = new Alert(Alert.AlertType.CONFIRMATION);
        alertaNF.setTitle("Sair");
        alertaNF.setHeaderText("Confirmação");
        alertaNF.setContentText("Deseja mesmo fechar a aplicação?");


        if (alertaNF.showAndWait().get() == ButtonType.OK) {
            ((Stage) btnSair.getScene().getWindow()).close();
        } else {
            alertaNF.close();
        }
    }
}

