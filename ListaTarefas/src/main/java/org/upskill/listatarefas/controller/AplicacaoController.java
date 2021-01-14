package org.upskill.listatarefas.controller;

import org.upskill.listatarefas.model.FicheiroListaTarefas;
import org.upskill.listatarefas.model.ListaTarefas;
import org.upskill.listatarefas.model.Prioridade;
import org.upskill.listatarefas.model.Tarefa;

import javax.management.InstanceAlreadyExistsException;
import java.io.File;
import java.util.List;

public class AplicacaoController {

    private ListaTarefas lista;
    private FicheiroListaTarefas ficheiroListaTarefas;

    //inicia atributos
    public AplicacaoController() {
        ficheiroListaTarefas = new FicheiroListaTarefas();

        desserializar();
    }

    public boolean serializar() {
        return ficheiroListaTarefas.serializar(lista);
    }

    public boolean serializar (File ficheiroExportar) {
        return ficheiroListaTarefas.serializar(ficheiroExportar, lista);
    }

    public void desserializar() {
        lista = ficheiroListaTarefas.desserializar();
    }

    public int desserializar(File ficheiroImportar) throws InstanceAlreadyExistsException {
        ListaTarefas listaTarefasImportada = ficheiroListaTarefas.desserializar(ficheiroImportar);

        return lista.adicionarListaTarefas(listaTarefasImportada);
    }

    public boolean exportarTexto(File ficheiroExportar) {
        return ficheiroListaTarefas.exportarTexto(ficheiroExportar, lista);
    }

    public int importarTexto(File ficheiroImportar) throws InstanceAlreadyExistsException {
        ListaTarefas listaTarefasImportada = ficheiroListaTarefas.importarTexto(ficheiroImportar);

        return lista.adicionarListaTarefas(listaTarefasImportada);
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
    public List<Tarefa> getListaTarefas() {
        return lista.getListaTarefas();
    }

    //retorna os elementos da lista, por decrescente de prioridade
    public List<Tarefa> getListaTarefasPorPrioridade() {
        return lista.listaTarefasPorPrioridade();
    }


    //retorna um array com todos os valores de Prioridade
    public Prioridade[] getPrioridades() {
        return Prioridade.values();
    }
}
