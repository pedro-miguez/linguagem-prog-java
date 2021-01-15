package org.upskill.listatarefas.model;

import javax.management.InstanceAlreadyExistsException;
import java.io.*;
import java.util.Scanner;

public class FicheiroListaTarefas {

    public static final String NOME_FICHEIRO_SERIALIZAR = "ListaTarefas.ser";

    public FicheiroListaTarefas() {
    }

    public boolean serializar(ListaTarefas listaTarefas) {
        return serializar(NOME_FICHEIRO_SERIALIZAR, listaTarefas);
    }

    public boolean serializar(String nomeFicheiro,ListaTarefas listaTarefas) {
        return serializar (new File(nomeFicheiro), listaTarefas);
    }

    public boolean serializar(File ficheiro, ListaTarefas listaTarefas) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(ficheiro));
            try {
                out.writeObject(listaTarefas);

                return true;
            } finally {
                out.close();
            }
        } catch (IOException ex) {
            return false;
        }
    }

    public ListaTarefas desserializar() {
        return desserializar(NOME_FICHEIRO_SERIALIZAR);
    }

    public ListaTarefas desserializar(String nomeFicheiro) {
        return desserializar(new File(nomeFicheiro));
    }

    public ListaTarefas desserializar(File ficheiro) {
        ListaTarefas listaTarefas;
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(ficheiro));
            try {
                listaTarefas = (ListaTarefas) in.readObject();

                return listaTarefas;
            } finally {
                in.close();
            }
        } catch (IOException | ClassNotFoundException ex) {
            return new ListaTarefas();
        }
    }

    public boolean exportarTexto(File ficheiro, ListaTarefas listaTarefas) {
        try {
            PrintWriter out = new PrintWriter(ficheiro);
            String[] listaTarefasParaFicheiro = listaTarefas.getListaComoArray();

            try {
                for (int i = 0; i < listaTarefasParaFicheiro.length - 1; i++) {
                    out.print(listaTarefasParaFicheiro[i] + "\n");
                }
                out.print(listaTarefasParaFicheiro[listaTarefasParaFicheiro.length - 1]);

                return true;
            } finally {
                out.close();
            }
        } catch (IOException ex) {
            return false;
        }
    }

    public ListaTarefas importarTexto(File ficheiro) {
        try {
            ListaTarefas lista = new ListaTarefas();
            Scanner in = new Scanner(ficheiro);

            try {
                while (in.hasNextLine()) {
                    String linha = in.nextLine();
                    String []dadosTarefa = Tarefa.getTarefaComoArray(linha);

                    lista.addTarefa(dadosTarefa[0], Prioridade.valueOf(dadosTarefa[1].toUpperCase().trim()), dadosTarefa[2].trim());
                }

                return lista;
            } finally {
                in.close();
            }
        } catch (IOException | InstanceAlreadyExistsException ex) {
            return new ListaTarefas();
        }
    }






}
