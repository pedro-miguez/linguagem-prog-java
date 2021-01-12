package org.upskill.datagui.model;

import javafx.scene.control.Alert;
import org.upskill.datagui.SceneController;
import org.upskill.datagui.model.Data;
import org.upskill.datagui.model.DiaInvalidoException;
import org.upskill.datagui.model.MesInvalidoException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Methods {

    public static Data lerData(String data) throws MesInvalidoException, DiaInvalidoException {
        boolean invalid = true;
        Data d1 = new Data();

        do {
            try {
                if (validarData(data)) {
                    int ano = Integer.parseInt(data.split("/")[0]);
                    int mes = Integer.parseInt(data.split("/")[1]);
                    int dia = Integer.parseInt(data.split("/")[2]);
                    d1.setData(ano, mes, dia);
                    invalid = false;
                } else {
                    Alert alert1 = new Alert(Alert.AlertType.ERROR);
                    alert1.setTitle("Erro");
                    alert1.setHeaderText("Data é inválida!");
                    alert1.showAndWait();

                }
            } catch (DiaInvalidoException | MesInvalidoException e) {
                System.out.println(e.getMessage());
            }
        } while (invalid);

        return d1;
    }

    private static boolean validarData(String data) {
        if (data.length() != 10) {
            return false;
        } else return data.split("/").length == 3;
    }

    public static Formatter criarFicheiro() {
        Scanner scn = new Scanner(System.in);
        Formatter output = null;
        boolean unresolved = true;
        do {
            try {
                System.out.println("Nome do ficheiro: ");
                String filename = scn.nextLine();
                output = new Formatter(filename);
                unresolved = false;
            } catch (Exception e) {
                System.out.println("Nao foi possivel criar o ficheiro!");
            }
        } while (unresolved);
        System.out.println("Ficheiro criado");
        return output;
    }




}
