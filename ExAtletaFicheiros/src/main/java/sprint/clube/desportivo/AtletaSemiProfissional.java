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


    public static String[] getAtletaComoArray(String atleta) {
        String[] dados = atleta.trim().split(String.valueOf(SEPARADOR));
        int nrAtributos = 10;

        if (dados.length == nrAtributos) {
            try {
                new AtletaSemiProfissional(dados[1], Integer.parseInt(dados[2]), Integer.parseInt(dados[3]), Double.parseDouble(dados[4]),
                        Double.parseDouble(dados[5]), Genero.valueOf(dados[6].toUpperCase()),
                        Atividade.valueOf(dados[7].toUpperCase()), ObjectivoTreino.valueOf(dados[8].toUpperCase()), Integer.parseInt(dados[9]));

                return dados;
            }
            catch(Exception ex) {
                throw new RuntimeException("Dados Inválidos da Tarefa");
            }
        }
        throw new RuntimeException("Dados Inválidos da Tarefa");
    }


    public static int getTotalAtletasSemiProfissional(){
        return totalAtletasSemiProfissional;
    }     

}
