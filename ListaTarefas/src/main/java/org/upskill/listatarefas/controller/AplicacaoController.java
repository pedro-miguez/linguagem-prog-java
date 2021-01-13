package org.upskill.listatarefas.controller;

import org.upskill.listatarefas.model.ListaTarefas;
import org.upskill.listatarefas.model.Prioridade;
import org.upskill.listatarefas.model.Tarefa;

import javax.management.InstanceAlreadyExistsException;
import java.util.Collections;
import java.util.List;

public class AplicacaoController {

    private ListaTarefas lista;

    //inicia atributos
    public AplicacaoController() {
        lista = new ListaTarefas();
    }

    //adiciona uma nova tarefa na lista
    public boolean adicionarTarefa(String descricao, Prioridade prioridade) throws InstanceAlreadyExistsException {
        return lista.addTarefa(new Tarefa(descricao, prioridade));
    }

    //elimina de lista todas as tarefas
    public void eliminarTarefas() {
        lista.clearTarefas();
    }

    //elimina apenas a última tarefa inserida na lista
    public boolean eliminarUltimaTarefa() {
        return lista.clearUltimaTarefa();
    }

    //verifica se lista está ou não vazia
    public boolean listaVazia() {
        return lista.isEmpty();
    }

    //retorna os elementos da lista, por ordem de inserção
    public String getListaTarefas() {
        StringBuilder output = new StringBuilder();
        for (Tarefa t : lista.getListaTarefas()) {
            output.append(t).append("\n");
        }
        return String.valueOf(output);
    }

    //retorna os elementos da lista, por decrescente de prioridade
    public String getListaTarefasPorPrioridade() {
        List<Tarefa> listaSortPrioridade = lista.getListaTarefas();
        Collections.sort(listaSortPrioridade);

        StringBuilder output = new StringBuilder();
        for (Tarefa t : listaSortPrioridade) {
            output.append(t).append("\n");
        }
        return String.valueOf(output);
    }

    //retorna um array com todos os valores de Prioridade
    public Prioridade[] getPrioridades() {
        return Prioridade.values();
    }
}
