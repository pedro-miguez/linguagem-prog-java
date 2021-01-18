
package org.upskill.matrizgenerica.model;

public abstract class Trabalhador {

    private String nome;

    private static final String NOME_POR_OMISSAO = "sem nome";

    public Trabalhador(String nome) {
        this.nome = nome;
    }

    public Trabalhador() {
        this.nome = Trabalhador.NOME_POR_OMISSAO;
    }

    public Trabalhador(Trabalhador outroTrabalhador) {
        this.nome = outroTrabalhador.nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || this.getClass() != outroObjeto.getClass()) {
            return false;
        }
        Trabalhador t = (Trabalhador) outroObjeto;
        return this.nome.equalsIgnoreCase(t.nome);
    }    

    public abstract float vencimento();
}

    