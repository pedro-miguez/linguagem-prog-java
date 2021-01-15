package sprint.clube.desportivo;

import java.io.Serializable;
import java.util.Objects;

public class AtletaProfissional extends Atleta implements Serializable {
    
    private double valorFixo;
    
    private static final double VALOR_FIXO_OMISSAO = 0;
    
    private static double percValorVar = 0.20;
    private static int totalAtletasProfissional = 0;
    
    
    public AtletaProfissional(String nome, int numIdCivil, int idade, double freqCardRepouso, double premioAcumulado,
            Genero genero, Atividade atividade, ObjectivoTreino objectivo, double valorFixo){
        super(nome, numIdCivil, idade, freqCardRepouso, premioAcumulado, genero, atividade, objectivo);
        setValorFixo(valorFixo);
        totalAtletasProfissional++;
    }
    
    
    public AtletaProfissional(){
        super();
        setValorFixo(VALOR_FIXO_OMISSAO);
        totalAtletasProfissional++;
    }
    

    /**
     * @return the valorFixo
     */
    public double getValorFixo() {
        return this.valorFixo;
    }

    /**
     * @param valorFixo the valorFixo to set
     */
    public void setValorFixo(double valorFixo) {
        this.valorFixo = valorFixo;
    }

    /**
     * @return the percValorVar
     */
    public static double getPercValorVar() {
        return percValorVar;
    }

    /**
     * @param aPercValorVar the percValorVar to set
     */
    public static void setPercValorVar(double aPercValorVar) {
        percValorVar = aPercValorVar;
    }

    @Override
    public double determinarParcela1() {
        return getValorFixo();
    }

    @Override
    public double determinarParcela2() {
        return getPremioAcumulado() * percValorVar;
    }
    

    public double calcularDescontoIRS(){
        return getValorFixo() * getIRS();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AtletaProfissional that = (AtletaProfissional) o;
        return Double.compare(that.getValorFixo(), getValorFixo()) == 0;
    }

    @Override
    public String toString(){
        return String.format("%sValor de Rendimento Fixo: %.2f || ", super.toString(), getValorFixo());
    }
    
    public static int getTotalAtletasProfissional(){
        return totalAtletasProfissional;
    }  
    
}
