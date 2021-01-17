package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class ClubeDesportivo implements Serializable {
    private String nomeClube;
    private String dataFundacao;
    private ArrayList<Atleta> atletasInscritos;

    private static final String NOME_OMISSAO = "Sem nome";
    private static final String DATA_OMISSAO = "Sem data de fundação";

    private static final int ATLETA = 1;
    private static final int ATLETA_NAO_PROFISSIONAL = 2;



    public ClubeDesportivo(String nomeClube, String dataFundacao, ArrayList<Atleta> atletasInscritos ) {
        this.setNomeClube(nomeClube);
        this.setDataFundacao(dataFundacao);
        this.atletasInscritos = atletasInscritos;
    }

    public ClubeDesportivo() {
        this.setNomeClube(NOME_OMISSAO);
        this.setDataFundacao(DATA_OMISSAO);
    }

    public String getNomeClube() {
        return nomeClube;
    }

    public void setNomeClube(String nomeClube) {
        this.nomeClube = nomeClube;
    }

    public String getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(String dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public boolean addAtleta (Atleta a) {
        if (getAtletasInscritos().contains(a)) {
            return false;
        } else {
            return getAtletasInscritos().add(a);
        }

    }

    public int addListaAtletas(ArrayList<Atleta> lista) {
        int totalAtletasAdicionados = 0;
        for (Atleta a : lista) {
            if(addAtleta(a)) {
                totalAtletasAdicionados++;
            }
        }

        return totalAtletasAdicionados;
    }


    public ArrayList<Atleta> getAtletasInscritos() {
        return atletasInscritos;
    }

    public ArrayList<Atleta> getListaAtletasDadoTipo (TipoAtleta tipoAtleta) {
        if (tipoAtleta == TipoAtleta.ATLETA) {
            return this.getAtletasInscritos();
        }
        ArrayList<Atleta> atletasDadoTipo = new ArrayList<>();

        for(Atleta a : getAtletasInscritos()) {
            switch (tipoAtleta) {
                case AMADOR:
                    if (a instanceof AtletaAmador ) {
                        atletasDadoTipo.add(a);
                    }
                    break;
                case PROFISSIONAL:
                    if (a instanceof AtletaProfissional ) {
                        atletasDadoTipo.add(a);
                    }
                    break;
                case NAO_PROFISSIONAL:
                    if (a instanceof AtletaNaoProfissional ) {
                        atletasDadoTipo.add(a);
                    }
                    break;
                case SEMIPROFISSIONAL:
                    if (a instanceof AtletaSemiProfissional ) {
                        atletasDadoTipo.add(a);
                    }
                    break;
            }
        }

        return atletasDadoTipo;
    }

    public String[] getListaAtletasComoArray(TipoAtleta tipoAtleta) {
        String[] listaTarefasString = new String[getListaAtletasDadoTipo(tipoAtleta).size()];
        int i = 0;

        for (Atleta atleta : getListaAtletasDadoTipo(tipoAtleta)) {
            listaTarefasString[i++] = atleta.toStringFicheiroTexto();
        }

        return listaTarefasString;
    }



    public ArrayList<Atleta> getSortedByName() {
        ArrayList<Atleta> atletasOrdenados = new ArrayList<Atleta>(atletasInscritos);
        Collections.sort(atletasOrdenados);
        return atletasOrdenados;
    }

    public ArrayList<Atleta> getReverseSortedByPremio() {
        ArrayList<Atleta> atletasOrdenados = new ArrayList<Atleta>(atletasInscritos);
        atletasOrdenados.sort(new SortByPremioReversedComparator());
        return atletasOrdenados;
    }

    public ArrayList<Atleta> getSortedByTypeThenActivityThenName() {
        ArrayList<Atleta> atletasOrdenados = new ArrayList<Atleta>(atletasInscritos);
        atletasOrdenados.sort(new SortByTypeThenActivityThenName());
        return atletasOrdenados;
    }
    
    
    public double calcularValorTotalIRS(ArrayList<Atleta> getAtletasInscritos){
        double somaIRS = 0;

        for (Atleta atleta : getAtletasInscritos()) {
            if (atleta instanceof AtletaSemiProfissional) {
                somaIRS += ((AtletaSemiProfissional)atleta).calcularDescontoIRS();
            } else if (atleta instanceof AtletaProfissional) {
                somaIRS += ((AtletaProfissional) atleta).calcularDescontoIRS();
            }
        }
        return somaIRS;
    }

    
    @Override
    public String toString(){
        return String.format("Nome do clube: %s || Data de Fundação: %s%n", getNomeClube(), getDataFundacao());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClubeDesportivo that = (ClubeDesportivo) o;
        return Objects.equals(getNomeClube(), that.getNomeClube()) &&
                Objects.equals(getDataFundacao(), that.getDataFundacao()) &&
                Objects.equals(getAtletasInscritos(), that.getAtletasInscritos());
    }

}
