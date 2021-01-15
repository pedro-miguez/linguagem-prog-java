package sprint.clube.desportivo;

import java.io.Serializable;

public class AtletaAmador extends AtletaNaoProfissional implements Serializable {


    private static double percentagemMensal = 0.07;
    private static int valorMinimo = 5;
    private static int totalAtletasAmador = 0;

    public AtletaAmador(String nome, int numIdCivil, int idade, double freqCardRepouso, double premioAcumulado,
                        Genero genero, Atividade atividade, ObjectivoTreino objectivo, int antiguidade) {
        super(nome, numIdCivil, idade, freqCardRepouso, premioAcumulado, genero, atividade, objectivo, antiguidade );
        totalAtletasAmador++;
    }

    public AtletaAmador(){
        super();
        totalAtletasAmador++;
    }

    public static double getPercentagemMensal() {
        return percentagemMensal;
    }

    public static void setPercentagemMensal(double percentagemMensal) {
        AtletaAmador.percentagemMensal = percentagemMensal;
    }

    public static int getValorMinimo() {
        return valorMinimo;
    }

    public static void setValorMinimo(int valorMinimo) {
        AtletaAmador.valorMinimo = valorMinimo;
    }

    public double determinarParcela1() {
        return getPremioAcumulado() * getPercAntiguidade();

    }

    public double determinarParcela2() {
        return getPremioAcumulado() * getPercentagemMensal();
    }

    @Override
    public double calcularPagamento() {
        return super.calcularPagamento() < valorMinimo? valorMinimo : super.calcularPagamento();
    }


    @Override
    public String toString(){
        return String.format("%s", super.toString());
    }


    public static String[] getAtletaComoArray(String atleta) {
        String[] dados = atleta.trim().split(String.valueOf(SEPARADOR));
        int nrAtributos = 9;

        if (dados.length == nrAtributos) {
            try {
                new AtletaAmador(dados[0], Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), Double.parseDouble(dados[3]),
                        Double.parseDouble(dados[4]), Genero.valueOf(dados[5].toUpperCase()),
                        Atividade.valueOf(dados[6].toUpperCase()), ObjectivoTreino.valueOf(dados[7].toUpperCase()), Integer.parseInt(dados[8]));

                return dados;
            }
            catch(Exception ex) {
                throw new RuntimeException("Dados Inválidos da Tarefa");
            }
        }
        throw new RuntimeException("Dados Inválidos da Tarefa");
    }

    public static int getTotalAtletasAmador(){
        return totalAtletasAmador;
    }



}
