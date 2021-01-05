
package org.dei.tp5.automovelComMatricula;

import org.dei.biblioteca.Data;
import org.dei.biblioteca.Pessoa;

public class MainAutomovel {

    public static void main(String[] args) {

        Pessoa p1 = new Pessoa("Jorge", 1234567);
        System.out.println("\n#### Listagem da Pessoa ####");
        System.out.println(p1);

        Automovel a1 = new Automovel("KIA", p1);
        System.out.println(a1);

        p1.setNome("Jorge Paixão");
        System.out.println("\n#### Atualização do proprietário ####");
        System.out.println(p1);
        System.out.println(a1);

//    fim do código de AutomovelComProprietario
//        4a
        Data d = new Data(2015, 4, 4);
        Matricula m = new Matricula("11-11-AA", d);

//        4b
        System.out.println("\n#### Listagem da Data e Matrícula ####");
        System.out.println(d);
        System.out.println(m);

//        4c
        d.setData(2016, 4, 4);

//        4d
        System.out.println("\n#### Listagem da Data e Matrícula - Nova Data ####");
        System.out.println(d);
        System.out.println(m);
//
//        7a
        Automovel a = new Automovel("KIA", m, p1);
        System.out.println("\n#### Listagem do Automovel ####");
        System.out.println(a);


//        7b
        m.setMatricula("22-22-BB");
        System.out.println("\n#### Listagem da Matricula e Automovel - Nova Matrícula ####");
        System.out.println(m);
        System.out.println(a);

//        10
        System.out.println("\n#### Clone ####");
        System.out.println(new Automovel(a));
    }
}