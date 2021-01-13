package org.upskill.listatelefonica.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaTelefonica {
    private List<ContactoTelefonico> listaTelefonica;

    public ListaTelefonica() {
        listaTelefonica = new ArrayList<>();
    }

    @Override
    public String toString() {
        List<ContactoTelefonico> copia = new ArrayList<>(listaTelefonica);
        Collections.sort(copia);
        
        StringBuilder s = new StringBuilder();
        for (ContactoTelefonico telefone : copia) {
            s.append(telefone);
            s.append("\n");
        }
        
        return s.toString().trim();
    }

    public void prePreencherLista() {
        for (int i = 1; i <= 50; i++) {
            this.adicionarContactoTelefonico("abc" + i, 100000000 + i);
        }
    }

    public boolean adicionarContactoTelefonico(String titular, int numero) {
        ContactoTelefonico contacto = new ContactoTelefonico(titular, numero);
        return listaTelefonica.contains(contacto)
                ? false
                : listaTelefonica.add(contacto);
    }
}