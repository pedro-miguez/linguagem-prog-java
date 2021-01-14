package org.upskill.listatelefonica.model;

import java.io.Serializable;

public class ContactoTelefonico implements Comparable<ContactoTelefonico>, Serializable {

    private String titular;
    private int numero;

    private static final char SEPARADOR = ';';

    public ContactoTelefonico(String titular, int numero) {
        setTitular(titular);
        setNumero(numero);
    }

    public final void setTitular(String titular) {
        if (titular == null || titular.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é inválido!");
        }
        this.titular = titular;
    }

    public final void setNumero(int numero) {
        if (numero < 100000000 || numero > 999999999) {
            throw new IllegalArgumentException("Número de telefone é inválido!");
        }
        this.numero = numero;
    }

    @Override
    public String toString() {
        return String.format("Número:%d Titular:%s", numero, titular);
    }

    public String toStringExport() {
        return String.format("%d%c%s", numero, SEPARADOR, titular);
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        ContactoTelefonico outroTelefone = (ContactoTelefonico) outroObjeto;

        return numero == outroTelefone.numero;
    }

    @Override
    public int compareTo(ContactoTelefonico outroTelefone) {
        return numero - outroTelefone.numero;
    }

    public static final String[] getContactoComoArray(String contacto) {
        String[] dados = contacto.trim().split(String.valueOf(SEPARADOR));
        int nrAtributos = 2;

        if (dados.length == nrAtributos) {
            try {
                new ContactoTelefonico(dados[1], Integer.parseInt(dados[0]));
                
                return dados;
            }
            catch(Exception ex) {
                throw new RuntimeException("Dados Inválidos do Contacto");
            }
        }

        throw new RuntimeException("Dados Inválidos do Contacto");
    }
}
