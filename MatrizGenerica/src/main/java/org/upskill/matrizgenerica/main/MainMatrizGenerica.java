
package org.upskill.matrizgenerica.main;

import org.upskill.matrizgenerica.model.MatrizGenerica;
import org.upskill.matrizgenerica.model.Trabalhador;
import org.upskill.matrizgenerica.model.TrabalhadorPeca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainMatrizGenerica {

    public static void main(String[] args) {

        ArrayList<Integer> arrayNums1 = new ArrayList<Integer>();
        arrayNums1.add(1);
        arrayNums1.add(2);
        arrayNums1.add(3);

        ArrayList<Integer> arrayNums2 = new ArrayList<Integer>();
        arrayNums2.add(1);
        arrayNums2.add(2);

        MatrizGenerica<Integer> intArray = new MatrizGenerica<>();

        intArray.addLine(arrayNums1);
        intArray.addLine(arrayNums2);
        intArray.addLine(arrayNums1);

        Integer[] array = new Integer[4];
        Integer[] array2 = intArray.elementsOfGivenColumn(array, 2);

        System.out.println(Arrays.toString(array2));

    }
    
}
