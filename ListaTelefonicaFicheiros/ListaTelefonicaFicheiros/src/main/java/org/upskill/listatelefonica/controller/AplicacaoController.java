package org.upskill.listatelefonica.controller;

import java.io.File;
import org.upskill.listatelefonica.model.FicheiroListaTelefonica;
import org.upskill.listatelefonica.model.ListaTelefonica;

public class AplicacaoController {

    private ListaTelefonica listaTelefonica;
    private FicheiroListaTelefonica ficheiroListaTelefonica;

    public AplicacaoController() {
        ficheiroListaTelefonica = new FicheiroListaTelefonica();
        
        desserializar();
    }

    public String getListaTelefonica() {
        return listaTelefonica.toString();
    }

    public boolean adicionarContactoTelefonico(String titular, int numero) {
        return listaTelefonica.adicionarContactoTelefonico(titular, numero);
    }

    public boolean isListaTelefonicaVazia() {
        return listaTelefonica.isVazia();
    }

    public boolean serializar() {
        return ficheiroListaTelefonica.serializar(listaTelefonica);
    }

    public boolean serializar(File ficheiroExportar) {
        return ficheiroListaTelefonica.serializar(ficheiroExportar, listaTelefonica);
    }

    public void desserializar() {
        listaTelefonica = ficheiroListaTelefonica.desserializar();
    }

    public int desserializar(File ficheiroImportar) {
        ListaTelefonica listaTelefonicaImportada = ficheiroListaTelefonica.desserializar(ficheiroImportar);

        return listaTelefonica.adicionarListaTelefonica(listaTelefonicaImportada);
    }

    public boolean exportarTexto(File ficheiroExportar) {
        return ficheiroListaTelefonica.exportarTexto(ficheiroExportar, listaTelefonica);
    }

    public int importarTexto(File ficheiroImportar) {
        ListaTelefonica listaTelefonicaImportada = ficheiroListaTelefonica.importarTexto(ficheiroImportar);

        return listaTelefonica.adicionarListaTelefonica(listaTelefonicaImportada);
    }

//    // pode ser util para preencher inicialmete a lista telefónica, e.g. construtor deste controlller
//    public void prePreencherLista() {
//        for (int i = 1; i <= 10; i++) {
//            listaTelefonica.adicionarContactoTelefonico("abc" + i, 100000000 + i);
//        }
//    }
}
