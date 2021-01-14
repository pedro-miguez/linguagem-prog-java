package org.upskill.listatarefas.model;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Tarefa t1 = new Tarefa("der", Prioridade.BAIXA);
        String[] dados = t1.toString().trim().split("-");
        Tarefa t2 = new Tarefa(dados[0].trim(), Prioridade.valueOf(dados[1].toUpperCase().trim()));

        System.out.println(Arrays.toString(Tarefa.getTarefaComoArray(t1.toString())));
    }
}
