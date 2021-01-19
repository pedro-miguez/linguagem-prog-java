
package org.upskill.matrizgenerica.model;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MatrizGenerica<E> {

    private List< List<E> > matrizGenerica;
    private int numeroMaximoColunas;

    public MatrizGenerica() {
        this.matrizGenerica = new ArrayList<>();
        this.numeroMaximoColunas = 0;
    }

    public int getNumberOfLines() {
        return this.matrizGenerica.size();
    }
    
    public int getNumberOfColumns(int indiceLinha) {
        verificarIndiceLinha(indiceLinha);
        return this.matrizGenerica.get(indiceLinha).size();
    }

    public void clear() {
        this.matrizGenerica.clear();
    }
    
    private int tamanhoColuna(int indice){
        verificarIndiceColuna(indice);
        int numeroLinhas=0;
        for (List<E> linha : this.matrizGenerica) {
            if(indice<linha.size()){
                numeroLinhas++;
            }
        }
        return numeroLinhas;
    }
    
    private void verificarIndiceLinha(int indice) {
        if (indice < 0 || indice >= this.matrizGenerica.size()) {
            throw new IndexOutOfBoundsException(
                    "Índice Linha: " + indice
                    + ", Tamanho: " + this.matrizGenerica.size());
        }
    }

    private void verificarIndiceColuna(int indiceColuna) {
        if (indiceColuna < 0 || indiceColuna >= this.numeroMaximoColunas) {
            throw new IndexOutOfBoundsException(
                    " Índice Coluna: " + indiceColuna
                    + ", Tamanho: " + this.numeroMaximoColunas);
        }
    }
    
    private void verificarIndices(int indiceLinha, int indiceColuna) {
        if (indiceLinha < 0
                || indiceLinha >= this.matrizGenerica.size()
                || indiceColuna < 0
                || indiceColuna >= this.matrizGenerica.get(indiceLinha).size()) {
            String mensagem = mensagemIndiceLinhaInvalido(indiceLinha) + 
                    mensagemIndiceColunaInvalido(indiceLinha);
            throw new IndexOutOfBoundsException(mensagem);
        }
    }

    private String mensagemIndiceLinhaInvalido(int indice) {
        return "Índice Linha: " + indice
                + ", Tamanho: " + this.matrizGenerica.size();
    }
    
    private String mensagemIndiceColunaInvalido(int indice) {
        return  " Índice Coluna: " + indice
                + ", Tamanho: " + this.matrizGenerica.get(indice).size();
    }

    public E getElement(int indiceLinha, int indiceColuna) {
        return this.matrizGenerica.get(indiceLinha).get(indiceColuna);
    }

    /*public boolean addLine(Collection<? extends E> collection) {
        if (collection.size() > this.numeroMaximoColunas) {
            this.numeroMaximoColunas = collection.size();
        }
        return this.matrizGenerica.add(new ArrayList<>(collection));
    }*/

    public boolean addLine(Collection<? extends E> collection) {
        if (collection.size() > this.numeroMaximoColunas) {
            this.numeroMaximoColunas = collection.size();
        }
        return this.matrizGenerica.add(new ArrayList<>(collection));
    }


    public boolean contains(E e) {
        for (List<E> list : this.matrizGenerica) {
            if(list.contains(e)) {
                return true;
            }
        }
        return false;
    }

    public boolean substituteElement(int indiceLinha, int indiceColuna, E e){
        verificarIndices(indiceLinha, indiceColuna);
        this.matrizGenerica.get(indiceLinha).set(indiceColuna, e);
        return this.getElement(indiceLinha, indiceColuna) == e;
    }

    public List<E> removeLine(int indiceLinha) {
        verificarIndiceLinha(indiceLinha);

        if (matrizGenerica.get(indiceLinha).size() == numeroMaximoColunas) {
            numeroMaximoColunas = 0;
            for (List<E> linha : matrizGenerica) {
                if (linha.size() > numeroMaximoColunas) {
                    numeroMaximoColunas = linha.size();
                }
            }
        }

        return this.matrizGenerica.remove(indiceLinha);
    }

    @SuppressWarnings("unchecked")
    public E[] elementsOfGivenColumn(E[] array, int indiceColuna) {
        verificarIndiceColuna(indiceColuna);

        int dimensaoColuna = tamanhoColuna(indiceColuna);

        if (array.length < dimensaoColuna) {
            array = (E[]) Array.newInstance(array.getClass().getComponentType(), dimensaoColuna);
            //array = (E[]) new Object[dimensaoColuna];
        } else if (array.length > dimensaoColuna) {
            array[dimensaoColuna] = null;
        }

        int i = 0;

        for (List<E> linha : this.matrizGenerica) {
            if (linha.size()-1 >= indiceColuna) {
                array[i++] = linha.get(indiceColuna);
            }
        }

        return array;
    }

}
