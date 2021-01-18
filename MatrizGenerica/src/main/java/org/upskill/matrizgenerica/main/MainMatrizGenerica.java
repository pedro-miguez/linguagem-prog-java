
package org.upskill.matrizgenerica.main;

import org.upskill.matrizgenerica.model.MatrizGenerica;
import org.upskill.matrizgenerica.model.Trabalhador;
import org.upskill.matrizgenerica.model.TrabalhadorPeca;

import java.util.ArrayList;
import java.util.List;

public class MainMatrizGenerica {

    public static void main(String[] args) {

        MatrizGenerica<TrabalhadorPeca> matrizTrabalhadorPeca = new MatrizGenerica<>();

        MatrizGenerica<String> matrizStrings = new MatrizGenerica<>();

        MatrizGenerica<Comparable> matrizComparable = new MatrizGenerica<>();

        MatrizGenerica<Trabalhador> matrizTrabalhador = new MatrizGenerica<>();

        TrabalhadorPeca tp1 = new TrabalhadorPeca("jose", 1, 2);

        List<TrabalhadorPeca> listaTP = new ArrayList<TrabalhadorPeca>();
        listaTP.add(tp1);
        
        matrizTrabalhador.addLine(listaTP);


    }
    
}
