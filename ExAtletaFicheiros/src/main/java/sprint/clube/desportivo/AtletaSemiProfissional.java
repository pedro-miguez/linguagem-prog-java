package sprint.clube.desportivo;

import java.io.Serializable;

public class AtletaSemiProfissional extends AtletaNaoProfissional implements Serializable {

    private static double parcelaFixa = 100;
    private static int totalAtletasSemiProfissional = 0;

    public AtletaSemiProfissional(String nome, int numIdCivil, int idade, double freqCardRepouso, double premioAcumulado,
                        Genero genero, Atividade atividade, ObjectivoTreino objectivo, int antiguidade) {
        super(nome, numIdCivil, idade, freqCardRepouso, premioAcumulado, genero, atividade, objectivo, antiguidade );
        totalAtletasSemiProfissional++;
    }

    public AtletaSemiProfissional(){
        super();
        totalAtletasSemiProfissional++;
    }

    public static double getParcelaFixa() {
        return parcelaFixa;
    }

    public static void setParcelaFixa(double parcelaFixa) {
        AtletaSemiProfissional.parcelaFixa = parcelaFixa;
    }

    public double determinarParcela1() {
        return getParcelaFixa();
    }

    public double determinarParcela2() {
        return getParcelaFixa() * getPercAntiguidade();
    }
    

    public double calcularDescontoIRS(){
        return getParcelaFixa() * getIRS();
    }
    
    @Override
    public String toString(){
        return String.format("%sValor de Rendimento Fixo: %.2f || ", super.toString(), getParcelaFixa());
    }
    
    
    public static int getTotalAtletasSemiProfissional(){
        return totalAtletasSemiProfissional;
    }     

}
