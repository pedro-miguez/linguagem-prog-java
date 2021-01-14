package org.upskill.listatarefas.model;

import javax.management.InstanceAlreadyExistsException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaTarefas {


    public enum ORDENACAO {INSERCAO, PRIORIDADE}
    
    private List<Tarefa> listaTarefas;

    //implementar todas as funcionalidades necessárias

    public ListaTarefas() {
        this.listaTarefas = new ArrayList<Tarefa>();
    }

    public boolean addTarefa(Tarefa t) throws InstanceAlreadyExistsException {
        if (listaTarefas.contains(t)) {
            throw new InstanceAlreadyExistsException("Já existe uma data criada neste instante com esta descrição!");
        } else {
            return listaTarefas.add(t);
        }
    }

    public void clearTarefas() {
        for (Tarefa t : this.listaTarefas) {
            listaTarefas.remove(t);
        }
    }

    public List<Tarefa> getListaTarefas() {
        return new ArrayList<>(listaTarefas);
    }

    public boolean clearUltimaTarefa() {
        if (isEmpty()) {
            return false;
        } else {
            listaTarefas.remove(listaTarefas.size()-1);
            return true;
        }
    }

    public boolean isEmpty() {
        return listaTarefas.size() == 0;
    }

    @Override
    public String toString() {
        return  listaTarefasPorInsercao();
    }

    public String listaTarefasPorInsercao() {
        List<Tarefa> listaCopia = getListaTarefas();

        StringBuilder output = new StringBuilder();
        for (Tarefa t : listaCopia) {
            output.append(t).append("\n");
        }
        return String.valueOf(output);
    }

    public String listaTarefasPorPrioridade() {
        List<Tarefa> listaSortPrioridade = getListaTarefas();
        Collections.sort(listaSortPrioridade);

        StringBuilder output = new StringBuilder();
        for (Tarefa t : listaSortPrioridade) {
            output.append(t).append("\n");
        }
        return String.valueOf(output);
    }
    
}
