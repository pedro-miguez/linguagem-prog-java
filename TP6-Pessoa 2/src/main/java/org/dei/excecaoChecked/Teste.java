
package org.dei.excecaoChecked;

import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import org.dei.excecaoUnchecked.Pessoa;
import java.io.IOException;

public class Teste {

    public static void main(String[] args) {

        List<Pessoa> lista = new ArrayList<>();

        lista.add(new Pessoa("Jorge", 1234567));
        lista.add(new Pessoa("Ana", 7654321));

        System.out.println(guardarEmFicheiro(lista) ? "Ficheiro criado."
                : "Ficheiro não criado.");

    }

    private static boolean guardarEmFicheiro(List<Pessoa> lista)  {
        Formatter ficheiro;
        ficheiro = new Formatter(new File("pessoas.txt"));
        for (Pessoa p : lista) {
            ficheiro.format("%s%n", p);
        }
        ficheiro.close();
        return true;
    }

//    private static boolean guardarEmFicheiro(List<Pessoa> lista) {
//        Formatter ficheiro;
//        try {
//            ficheiro = new Formatter(new File("pessoas.txt"));
//            try {
//                for (Pessoa p : lista) {
//                    ficheiro.format("%s%n", p);
//                }
//            } finally {
//                ficheiro.close();
//            }
//            return true;
//        } catch (IOException e) {
//            return false;
//        }
//    }
    
}