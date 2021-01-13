package org.upskill.listatelefonica.model;

public class ContactoTelefonico implements Comparable<ContactoTelefonico> {
    private String titular;
    private int numero;

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
            throw new IllegalArgumentException("Número é inválido!");
        }
        this.numero = numero;
    }

    @Override
    public String toString() {
        return String.format("Número:%d Titular:%s", numero, titular);
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
}