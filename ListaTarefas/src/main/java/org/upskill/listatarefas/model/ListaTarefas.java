package org.upskill.listatarefas.model;

import javax.management.InstanceAlreadyExistsException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaTarefas implements Serializable {


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

    public boolean addTarefa(String descricao, Prioridade prioridade, CharSequence instante) throws InstanceAlreadyExistsException {
        Tarefa tarefa = new Tarefa(descricao, prioridade, instante);

        return addTarefa(tarefa);
    }

    public int adicionarListaTarefas(ListaTarefas outraListaTarefas) throws InstanceAlreadyExistsException {
        int totalContactosAdicionados = 0;

        for (Tarefa tarefa : outraListaTarefas.getListaTarefas()) {
            boolean tarefaAdicionada = addTarefa(tarefa);
            if (tarefaAdicionada) {
                totalContactosAdicionados++;
            }
        }
        return totalContactosAdicionados;
    }

    public void clearTarefas() {
        listaTarefas.clear();
    }

    public List<Tarefa> getListaTarefas() {
        return listaTarefas;
    }

    public String[] getListaComoArray() {
        String[] listaTarefasString = new String[getListaTarefas().size()];
        int i = 0;

        for (Tarefa tarefa : listaTarefas) {
            listaTarefasString[i++] = tarefa.toString();
        }

        return listaTarefasString;
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

   /* public String listaTarefasPorPrioridade() {
        List<Tarefa> listaSortPrioridade = getListaTarefas();
        Collections.sort(listaSortPrioridade);

        StringBuilder output = new StringBuilder();
        for (Tarefa t : listaSortPrioridade) {
            output.append(t).append("\n");
        }
        return String.valueOf(output);
    }*/

    public List<Tarefa> listaTarefasPorPrioridade() {
        List<Tarefa> listaSortPrioridade = new ArrayList<>(getListaTarefas());
        Collections.sort(listaSortPrioridade);

        return listaSortPrioridade;
    }
    
}
