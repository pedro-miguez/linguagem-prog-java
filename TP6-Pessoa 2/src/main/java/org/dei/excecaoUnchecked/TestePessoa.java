
package org.dei.excecaoUnchecked;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestePessoa {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        boolean invalid = true;
        Pessoa p = new Pessoa();
        do {
            try {
                System.out.print("Nome:");
                String nome = ler.nextLine();
                p.setNome(nome);
                invalid = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (invalid);

        invalid = true;

        do {
            try {
                System.out.print("Nº de ID Civil:");
                int idCivil = ler.nextInt();
                ler.nextLine();
                p.setIDCivil(idCivil);
                invalid = false;
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        } while (invalid);

        System.out.println("\nPessoa: " + p);

    }
}
