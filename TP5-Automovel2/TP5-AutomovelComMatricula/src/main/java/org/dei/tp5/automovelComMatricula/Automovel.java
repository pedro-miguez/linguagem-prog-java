
package org.dei.tp5.automovelComMatricula;

import org.dei.biblioteca.*;

public class Automovel {

    private String marca;
    private Matricula matricula;
    private Pessoa proprietario;

    private static final String MARCA_POR_OMISSAO = "sem marca";

    public Automovel(String marca, Matricula matricula, Pessoa proprietario) {
        this.marca = marca;
        this.matricula = new Matricula(matricula);
        this.proprietario = proprietario;
    }
    
    public Automovel(String marca, Pessoa proprietario) {
        this.marca = marca;
        matricula = new Matricula();
        this.proprietario = proprietario;
    }

    public Automovel() {
        marca = MARCA_POR_OMISSAO;
        matricula = new Matricula();
        proprietario = new Pessoa();
    }

    public Automovel(Automovel outroAutomovel) {
        marca = outroAutomovel.marca;
        matricula = new Matricula(outroAutomovel.matricula);
        proprietario = outroAutomovel.proprietario;
    }

    public String getMarca() {
        return marca;
    }

    public Matricula getMatricula() {
        return new Matricula(matricula);
    }

    public Pessoa getProprietario() {
        return proprietario;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula.setMatricula(matricula.getMatricula());
        this.matricula.setDataRegisto(new Data(matricula.getDataRegisto()));
    }

    public void setProprietario(Pessoa proprietario) {
        this.proprietario = proprietario;
    }

    public String toString() {
        return String.format(
                "Automóvel:%n Marca=%s%n Matricula=%s%n Proprietário=%s",
                marca, matricula, proprietario);
    }
}
