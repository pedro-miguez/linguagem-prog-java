package org.upskill.listatelefonica.controller;

import org.upskill.listatelefonica.model.ListaTelefonica;

public class AplicacaoController {
    private ListaTelefonica listaTelefonica;

    public AplicacaoController() {
        listaTelefonica = new ListaTelefonica();
    }

    public String getListaTelefonica() {
        return listaTelefonica.toString();
    }

    public void preencherListaTelefonica() {
        listaTelefonica.prePreencherLista();
    }

    public boolean adicionarContactoTelefonico(String titular, int numero) {
        return listaTelefonica.adicionarContactoTelefonico(titular, numero);
    }
}