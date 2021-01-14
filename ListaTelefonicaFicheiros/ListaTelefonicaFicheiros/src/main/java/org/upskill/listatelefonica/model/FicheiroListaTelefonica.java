package org.upskill.listatelefonica.model;

import java.io.*;
import java.util.Scanner;

public class FicheiroListaTelefonica {

    public static final String NOME_FICHEIRO_SERIALIZAR = "ListaTelefonica.ltf";

    public FicheiroListaTelefonica() {
    }

    public boolean serializar(ListaTelefonica listaTelefonica) {
        return serializar(NOME_FICHEIRO_SERIALIZAR, listaTelefonica);
    }

    public boolean serializar(String nomeFicheiro, ListaTelefonica listaTelefonica) {
        return serializar(new File(nomeFicheiro), listaTelefonica);
    }

    public boolean serializar(File ficheiro, ListaTelefonica listaTelefonica) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(ficheiro));
            try {
                out.writeObject(listaTelefonica);
                
                return true;
            } finally {
                out.close();
            }
        } catch (IOException ex) {
            return false;
        }
    }

    public ListaTelefonica desserializar() {
        return desserializar(NOME_FICHEIRO_SERIALIZAR);
    }

    public ListaTelefonica desserializar(String nomeFicheiro) {
        return desserializar(new File(nomeFicheiro));
    }

    public ListaTelefonica desserializar(File ficheiro) {
        ListaTelefonica listaTelefonica;
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(ficheiro));
            try {
                listaTelefonica = (ListaTelefonica) in.readObject();
                
                return listaTelefonica;
            } finally {
                in.close();
            }
        } catch (IOException | ClassNotFoundException ex) {
            return new ListaTelefonica();
        }
    }

    public boolean exportarTexto(File ficheiro, ListaTelefonica listaTelefonica) {
        try {
            PrintWriter out = new PrintWriter(ficheiro);
            String[] listaTelefonicaParaFicheiro = listaTelefonica.getListaComoArray();

            try {
                for (int i = 0; i < listaTelefonicaParaFicheiro.length - 1; i++) {
                    out.print(listaTelefonicaParaFicheiro[i] + "\n");
                }
                out.print(listaTelefonicaParaFicheiro[listaTelefonicaParaFicheiro.length - 1]);

                return true;
            } finally {
                out.close();
            }
        } catch (IOException ex) {
            return false;
        }
    }

    public ListaTelefonica importarTexto(File ficheiro) {
        try {
            ListaTelefonica lista = new ListaTelefonica();
            Scanner in = new Scanner(ficheiro);

            try {
                while (in.hasNextLine()) {
                    String linha = in.nextLine();
                    String []dadosContacto = ContactoTelefonico.getContactoComoArray(linha);

                    lista.adicionarContactoTelefonico(dadosContacto[1], Integer.parseInt(dadosContacto[0]));
                }

                return lista;
            } finally {
                in.close();
            }
        } catch (IOException ex) {
            return new ListaTelefonica();
        }
    }
}
