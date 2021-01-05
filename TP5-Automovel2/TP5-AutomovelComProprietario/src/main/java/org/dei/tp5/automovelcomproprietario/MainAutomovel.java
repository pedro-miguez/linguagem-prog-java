
package org.dei.tp5.automovelcomproprietario;

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
    }

}
