package org.upskill.listatelefonica.ui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import org.upskill.listatelefonica.controller.AplicacaoController;

public class JanelaPrincipalUI implements Initializable {

    private AplicacaoController appController;
    private Stage novoContactoStage;

    @FXML
    private TextArea txtAreaListaTelefonica;

    @FXML
    private MenuItem mnuContactosExportarSerializacao;

    @FXML
    private MenuItem mnuContactosExportarTexto;

    private static final String CABECALHO_IMPORTAR = "Importar Lista.";
    private static final String CABECALHO_EXPORTAR = "Exportar Lista.";

    private static final int SERIALIZACAO = 1;
    private static final String DESCRICAO_SERIALIZACAO = "Ficheiro Lista Telefónica";
    private static final String EXTENSAO_SERIALIZACAO = "*.ltf";

    private static final int TEXTO = 2;
    private static final String DESCRICAO_TEXTO = "Ficheiro de Texto";
    private static final String EXTENSAO_TEXTO = "*.txt";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AdicionarNovoContactoScene.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            novoContactoStage = new Stage();
            novoContactoStage.initModality(Modality.APPLICATION_MODAL);
            novoContactoStage.setTitle("Novo Contacto");
            novoContactoStage.setResizable(false);
            novoContactoStage.setScene(scene);

            appController = new AplicacaoController();
            atualizaTextAreaListaTelefonica();

            AdicionarNovoContactoUI novoContactoUI = loader.getController();
            novoContactoUI.associarParentUI(this);
        } catch (IOException ex) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, MainApp.TITULO_APLICACAO, "Erro.", ex.getMessage());
        }
    }

    public AplicacaoController getAplicacaoController() {
        return appController;
    }

    public void atualizaTextAreaListaTelefonica() {
        txtAreaListaTelefonica.setText(appController.getListaTelefonica());
    }

    @FXML
    private void mnuContactosNovoAction(ActionEvent event) throws IOException {
        novoContactoStage.show();
    }

    @FXML
    private void mnuListaShowing(Event event) {
        mnuContactosExportarSerializacao.setDisable(appController.isListaTelefonicaVazia());
        mnuContactosExportarTexto.setDisable(appController.isListaTelefonicaVazia());
    }

    @FXML
    private void mnuContactosImportarSerializacaoAction(ActionEvent event) {
        importarLista(SERIALIZACAO);
    }

    @FXML
    private void mnuContactosExportarSerializacaoAction(ActionEvent event) {
        exportarLista(SERIALIZACAO);
    }

    @FXML
    private void mnuContactosImportarTextoAction(ActionEvent event) {
        importarLista(TEXTO);
    }

    @FXML
    private void mnuContactosExportarTextoAction(ActionEvent event) {
        exportarLista(TEXTO);
    }

    @FXML
    private void mnuContactosSairAction(ActionEvent event) {
        Window window = txtAreaListaTelefonica.getScene().getWindow();
        window.fireEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    @FXML
    private void mnuOpcoesAcercaAction(ActionEvent event) {
        AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, MainApp.TITULO_APLICACAO, "Acerca.",
                "@Copyright\nUPskill 2020/2021").show();
    }

    private void importarLista(int tipoFicheiro) {
        String descricao, extensao;

        switch (tipoFicheiro) {
            case SERIALIZACAO:
                descricao = DESCRICAO_SERIALIZACAO;
                extensao = EXTENSAO_SERIALIZACAO;
                break;

            case TEXTO:
                descricao = DESCRICAO_TEXTO;
                extensao = EXTENSAO_TEXTO;
                break;

            default:
                throw new IllegalArgumentException("Tipo de ficheiro desconhecido.");
        }

        FileChooser flChooser = FileChooserListaTelefonicaUI.criarFileChooserListaTelefonica(descricao, extensao);
        File ficheiroImportar = flChooser.showOpenDialog(txtAreaListaTelefonica.getScene().getWindow());

        if (ficheiroImportar != null) {
            int numeroContactosImportados = 0;

            switch (tipoFicheiro) {
                case SERIALIZACAO:
                    numeroContactosImportados = appController.desserializar(ficheiroImportar);
                    break;

                case TEXTO:
                    numeroContactosImportados = appController.importarTexto(ficheiroImportar);
                    break;
            }

            if (numeroContactosImportados > 0) {
                atualizaTextAreaListaTelefonica();

                AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, MainApp.TITULO_APLICACAO, CABECALHO_IMPORTAR,
                        String.format("%d contacto(s) importado(s).", numeroContactosImportados)).show();
            } else {
                AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, MainApp.TITULO_APLICACAO, CABECALHO_IMPORTAR,
                        "Ficheiro sem contactos telefónicos para importar!").show();
            }
        } else {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, MainApp.TITULO_APLICACAO, CABECALHO_IMPORTAR,
                    "Não foi seleccionado nenhum ficheiro!").show();
        }
    }

    private void exportarLista(int tipoFicheiro) {
        String descricao, extensao;

        switch (tipoFicheiro) {
            case SERIALIZACAO:
                descricao = DESCRICAO_SERIALIZACAO;
                extensao = EXTENSAO_SERIALIZACAO;
                break;

            case TEXTO:
                descricao = DESCRICAO_TEXTO;
                extensao = EXTENSAO_TEXTO;
                break;

            default:
                throw new IllegalArgumentException("Tipo de ficheiro desconhecido.");
        }

        FileChooser flChooser = FileChooserListaTelefonicaUI.criarFileChooserListaTelefonica(descricao, extensao);
        File ficheiroExportar = flChooser.showSaveDialog(txtAreaListaTelefonica.getScene().getWindow());

        if (ficheiroExportar != null) {
            boolean gravou = false;

            switch (tipoFicheiro) {
                case SERIALIZACAO:
                    gravou = appController.serializar(ficheiroExportar);
                    break;

                case TEXTO:
                    gravou = appController.exportarTexto(ficheiroExportar);
                    break;

            }
            if (gravou) {
                AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, MainApp.TITULO_APLICACAO, CABECALHO_EXPORTAR,
                        "Contactos exportados com sucesso.").show();
            } else {
                AlertaUI.criarAlerta(Alert.AlertType.ERROR, MainApp.TITULO_APLICACAO, CABECALHO_EXPORTAR,
                        "Problema a exportar a lista de contactos!").show();
            }
        } else {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, MainApp.TITULO_APLICACAO, CABECALHO_EXPORTAR,
                    "Não foi seleccionado nenhum ficheiro!").show();
        }
    }

}
