package org.upskill.listatarefas.ui;

import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.upskill.listatarefas.controller.AplicacaoController;

import java.io.IOException;

public class MainApp extends Application {

    public static final String TITULO_APLICACAO = "Lista de Tarefas";

    @Override
    public void start(Stage stage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/JanelaPrincipalScene.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");

            stage.setTitle(TITULO_APLICACAO);
            stage.setScene(scene);

            stage.sizeToScene();
            stage.setResizable(false);

            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    Alert alerta = AlertaUI.criarAlerta(Alert.AlertType.CONFIRMATION, TITULO_APLICACAO,
                            "Confirmação da ação.", "Deseja mesmo encerrar a aplicação?");

                    if (alerta.showAndWait().get() == ButtonType.CANCEL) {
                        event.consume();
                    } else {
                        AplicacaoController appController = ((JanelaPrincipalUI) loader.getController()).getAplicacaoController();
                        if (!appController.listaVazia() && !appController.serializar()) {
                            AlertaUI.criarAlerta(Alert.AlertType.ERROR, TITULO_APLICACAO, "Exportar Lista.",
                                    "Problema a exportar a lista de contactos!").show();
                        }
                    }
                }
            });
            stage.show();
        } catch (
                IOException ex) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, TITULO_APLICACAO,
                    "Problemas no arranque da aplicação.", ex.getMessage()).show();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
