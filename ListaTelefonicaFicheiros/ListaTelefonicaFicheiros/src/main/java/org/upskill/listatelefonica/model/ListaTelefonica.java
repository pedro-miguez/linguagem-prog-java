package org.upskill.listatelefonica.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaTelefonica implements Serializable {

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

    public boolean isVazia() {
        return listaTelefonica.isEmpty();
    }

    public int adicionarListaTelefonica(ListaTelefonica outraListaTelefonica) {
        int totalContactosAdicionados = 0;
        
        for (ContactoTelefonico contacto : outraListaTelefonica.listaTelefonica) {
            boolean contactoAdicionado = adicionarContactoTelefonico(contacto);
            if (contactoAdicionado) {
                totalContactosAdicionados++;
            }
        }
        return totalContactosAdicionados;
    }

    public boolean adicionarContactoTelefonico(String titular, int numero) {
        ContactoTelefonico contacto = new ContactoTelefonico(titular, numero);

        return adicionarContactoTelefonico(contacto);
    }

    public String[] getListaComoArray() {
        String[] listaContactos = new String[listaTelefonica.size()];
        int i = 0;

        for (ContactoTelefonico contactoTelefonico : listaTelefonica) {
            listaContactos[i++] = contactoTelefonico.toStringExport();
        }

        return listaContactos;
    }

    private boolean adicionarContactoTelefonico(ContactoTelefonico contacto) {
        return listaTelefonica.contains(contacto)
                ? false
                : listaTelefonica.add(contacto);
    }
}
