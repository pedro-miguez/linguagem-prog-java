
package org.dei.tp5.automovelComMatricula;

import org.dei.biblioteca.Data;

public class Matricula {

    private String matricula;
    private Data dataRegisto;

    private static final String MATRICULA_POR_OMISSAO = "sem matrícula";

    public Matricula(String matricula, Data dataRegisto) {
        this.matricula = matricula;
        this.dataRegisto = new Data(dataRegisto);
    }

    public Matricula() {
        matricula = MATRICULA_POR_OMISSAO;
        dataRegisto = new Data();
    }

    public Matricula(Matricula outraMatricula) {
        matricula = outraMatricula.matricula;
        dataRegisto = outraMatricula.dataRegisto;
    }

    public String getMatricula() {
        return matricula;
    }

    public Data getDataRegisto() {
        return dataRegisto;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setDataRegisto(Data dataRegisto) {
        this.dataRegisto = dataRegisto;
    }

    @Override
    public String toString() {
        return String.format("Matricula: %s registada em %s",
                matricula, dataRegisto.toAnoMesDiaString());
    }
}

