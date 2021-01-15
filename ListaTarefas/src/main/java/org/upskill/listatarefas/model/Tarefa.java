package org.upskill.listatarefas.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Tarefa implements Comparable<Tarefa>, Serializable {
    private String descricao;
    private LocalDateTime instante;
    private Prioridade prioridade;

    private static final DateTimeFormatter formatoInstante = DateTimeFormatter.ofPattern("dd/MM/yyyy_HH:mm:ss.SSS");

    private static final char SEPARADOR = '-';


    public Tarefa(String descricao, Prioridade prioridade) {
        setDescricao(descricao);
        setPrioridade(prioridade);
        instante = LocalDateTime.now();
    }

    public Tarefa(String descricao, Prioridade prioridade, CharSequence instante) {
        setDescricao(descricao);
        setPrioridade(prioridade);
        this.instante = LocalDateTime.parse(instante, formatoInstante);
    }

    public String getDescricao() {
        return descricao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public LocalDateTime getInstante() {
        return instante;
    }

    public final void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição inválida!");
        }
        this.descricao = descricao;
    }

    public final void setPrioridade(Prioridade prioridade) {
        if (prioridade == null) {
            throw new IllegalArgumentException("Prioridade inválida!");
        }
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        String stringDataTempoDeRegisto = instante.format(formatoInstante);
        return String.format("%s %c %s %c %s", descricao, SEPARADOR, prioridade, SEPARADOR,
                stringDataTempoDeRegisto);
    }



    @Override
    public int compareTo(Tarefa outraTarefa) {
        if(prioridade.equals(outraTarefa.prioridade)) {
            return instante.compareTo(outraTarefa.instante);
        }
        
        return prioridade.compareTo(outraTarefa.prioridade);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return getDescricao().equals(tarefa.getDescricao()) &&
                getInstante().equals(tarefa.getInstante());
    }

    public static String[] getTarefaComoArray(String tarefa) {
        String[] dados = tarefa.trim().split(String.valueOf(SEPARADOR));
        int nrAtributos = 3;

        if (dados.length == nrAtributos) {
            try {
                new Tarefa(dados[0], Prioridade.valueOf(dados[1].toUpperCase().trim()), dados[2].trim());

                return dados;
            }
            catch(Exception ex) {
                throw new RuntimeException("Dados Inválidos da Tarefa");
            }
        }
        throw new RuntimeException("Dados Inválidos da Tarefa");
    }

}
