package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    public Label lblCliques;
    public Button btnClick;
    public int counter = 0;

    public void clickAction(ActionEvent actionEvent) {
        counter++;
        lblCliques.setText("Número de Cliques: " + counter);
    }
}
