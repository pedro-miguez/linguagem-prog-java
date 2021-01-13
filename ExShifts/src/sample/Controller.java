package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextArea numText;
    public Button btnConfirm;
    public Label letrasLabel;
    public Button btnLeft;
    public Button btnRight;

    char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
    char[] letrasEscolhidas;
    int qntLetras = 3;

    public void initialize (URL url, ResourceBundle rb) {
        criarArrayInicial();
    }

    public void btnConfirmClick(ActionEvent actionEvent) {
        criarArray();
    }

    public void btnLeftClick(ActionEvent actionEvent) {
        char first = letrasEscolhidas[0];

        System.arraycopy(letrasEscolhidas, 1, letrasEscolhidas, 0, letrasEscolhidas.length-1);

        letrasEscolhidas[letrasEscolhidas.length-1] = first;

        setArray();
    }

    public void btnRightClick(ActionEvent actionEvent) {
        char last = letrasEscolhidas[letrasEscolhidas.length-1];

        System.arraycopy(letrasEscolhidas, 0, letrasEscolhidas, 1, letrasEscolhidas.length - 1);

        /*for (int i = letrasEscolhidas.length-1; i > 0; i--) {
            letrasEscolhidas[i] = letrasEscolhidas[i-1];
        }*/

        letrasEscolhidas[0] = last;

        setArray();
    }

    public void criarArray() {
        StringBuilder output = new StringBuilder();

        try {
            qntLetras = Integer.parseInt(numText.getText());
            if (qntLetras < 3 || qntLetras > 7) {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Erro");
                alert1.setHeaderText("Deve ser introduzido um valor entre 3 e 7!");
                alert1.showAndWait();
                numText.clear();
                numText.requestFocus();
            } else {
                letrasEscolhidas = new char[qntLetras];

                for (int i = 0; i < qntLetras; i++) {
                    letrasEscolhidas[i] = letras[i];
                    output.append(letrasEscolhidas[i]).append(" ");
                }

                letrasLabel.setText(String.valueOf(output));
            }
        } catch (NumberFormatException e) {
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Erro");
            alert1.setHeaderText("Deve ser introduzido um valor inteiro!");
            alert1.showAndWait();
            numText.clear();
            numText.requestFocus();
        }

    }

    public void criarArrayInicial() {
        StringBuilder output = new StringBuilder();
        letrasEscolhidas = new char[qntLetras];

        for (int i = 0; i < qntLetras; i++) {
            letrasEscolhidas[i] = letras[i];
            output.append(letrasEscolhidas[i]).append(" ");
        }

        letrasLabel.setText(String.valueOf(output));
    }

    public void setArray() {
        StringBuilder output = new StringBuilder();
        for (char letrasEscolhida : letrasEscolhidas) {
            output.append(letrasEscolhida).append(" ");
        }
        letrasLabel.setText(String.valueOf(output));
    }
}
