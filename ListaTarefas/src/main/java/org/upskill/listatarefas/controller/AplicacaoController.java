package org.upskill.listatarefas.controller;

import org.upskill.listatarefas.model.ListaTarefas;
import org.upskill.listatarefas.model.Prioridade;

public class AplicacaoController {

    private ListaTarefas lista;

    //inicia atributos
    public AplicacaoController() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //adiciona uma nova tarefa na lista
    public boolean adicionarTarefa(String descricao, Prioridade prioridade) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //elimina de lista todas as tarefas
    public void eliminarTarefas() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //elimina apenas a última tarefa inserida na lista
    public boolean eliminarUltimaTarefa() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //verifica se lista está ou não vazia
    public boolean listaVazia() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //retorna os elementos da lista, por ordem de inserção
    public String getListaTarefas() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //retorna os elementos da lista, por decrescente de prioridade
    public String getListaTarefasPorPrioridade() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //retorna um array com todos os valores de Prioridade
    public Prioridade[] getPrioridades() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
