package model;

import java.io.Serializable;

public abstract class AtletaNaoProfissional extends Atleta implements Serializable {

    private int antiguidade;

    private static final int ANTIGUIDADE_OMISSAO = 0;
    private static double percAnt1 = 0.02;
    private static double percAnt2 = 0.08;
    private static double percAnt3 = 0.2;

    public AtletaNaoProfissional(String nome, int numIdCivil, int idade, double freqCardRepouso, double premioAcumulado,
                                 Genero genero, Atividade atividade, ObjectivoTreino objectivo, int antiguidade) {
        super(nome, numIdCivil, idade, freqCardRepouso, premioAcumulado, genero, atividade, objectivo);
        setAntiguidade(antiguidade);
    }

    public AtletaNaoProfissional() {
        super();
        setAntiguidade(ANTIGUIDADE_OMISSAO);
    }

    public int getAntiguidade() {
        return antiguidade;
    }

    public void setAntiguidade(int antiguidade) {
        this.antiguidade = antiguidade;
    }

    public double getPercAntiguidade() {
        if (getAntiguidade() < 5) {
            return 0;
        } else if (getAntiguidade() <= 10) {
            return percAnt1;
        } else if (getAntiguidade() <= 20) {
            return percAnt2;
        } else {
            return percAnt3;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AtletaNaoProfissional that = (AtletaNaoProfissional) o;
        return getAntiguidade() == that.getAntiguidade();
    }
    
    @Override
    public String toString(){
        return String.format("%sAntiguidade: %d || ", super.toString(), getAntiguidade());
    }

    @Override
    public String toStringFicheiroTexto() {
        return String.format("%s%c%d", super.toStringFicheiroTexto(), SEPARADOR, getAntiguidade());
    }

}
