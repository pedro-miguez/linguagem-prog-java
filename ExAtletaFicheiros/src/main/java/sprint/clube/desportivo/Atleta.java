package sprint.clube.desportivo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Java1 - grupo4
 * 
 * Current class implements the tool for creating new athletes (as Atleta) accordingly with 3 types of athletes
 * (Profissional, Semi-Profissional e Amador, the last two being Nao Profissionais) and with specific information for each
 * (such as name, Civil number identification, age in years, gender, associated activity for training,
 * training objective, rest heart rate value, and total monthly prize)
 * It has implementations for retriving or calculate several output values and parameters, such as
 * work heart rate, max heart rate, work training index, club payment value for the athete,
 * total monthly prize after adding a new prize value, IRS tax value and to get all information about the Atleta through toString() method.
 * 
 */
public abstract class Atleta implements Comparable<Atleta>, Serializable {

    private String nome;
    private int numIdCivil;
    private int idade;
    private double freqCardRepouso;
    private double premioAcumulado;
    private Genero genero;
    private Atividade atividade;
    private ObjectivoTreino objectivoTreino;

    private static final String NOME_OMISSAO = "Sem nome";
    private static final int NUMID_OMISSAO = 0;
    private static final int IDADE_OMISSAO = 0;
    private static final double FCR_OMISSAO = 0;
    private static final double PREMIO_OMISSAO = 0;
    private static final Genero GENERO_OMISSAO = Genero.MASCULINO;
    private static final Atividade ATIVIDADE_OMISSAO = Atividade.CAMINHADA;
    private static final ObjectivoTreino OBJECTIVO_TREINO_OMISSAO = ObjectivoTreino.QUEIMA_GORDURA;

    public static final char SEPARADOR = '-';
    
    private static final double QUEIMA_IT = 0.6;
    private static final double CARDIO_IT = 0.75;

    private static final double IRS = 0.1;

    /**
     * Initializes a new instance Atleta with set parameters.
     * 
     * @param nome
     * @param numIdCivil
     * @param idade
     * @param freqCardRepouso
     * @param premioAcumulado
     * @param genero
     * @param atividade
     * @param objectivo
     * 
     */
    public Atleta(String nome, int numIdCivil, int idade, double freqCardRepouso, double premioAcumulado, Genero genero, Atividade atividade, ObjectivoTreino objectivo) {
        this.nome = nome;
        this.numIdCivil = numIdCivil;
        this.idade = idade;
        this.freqCardRepouso = freqCardRepouso;
        this.premioAcumulado = premioAcumulado;
        this.setGenero(genero);
        this.setAtividade(atividade);
        this.setObjectivoTreino(objectivo);
    }
    
    /**
     * Initializes a new instance Atleta with default values.
     *
     */
    public Atleta(){
        this.setNome(NOME_OMISSAO);
        this.setNumIdCivil(NUMID_OMISSAO);
        this.setIdade(IDADE_OMISSAO);
        this.setFreqCardRepouso(FCR_OMISSAO);
        this.setPremioAcumulado(PREMIO_OMISSAO);
        this.setGenero(GENERO_OMISSAO);
        this.setAtividade(ATIVIDADE_OMISSAO);
        this.setObjectivoTreino(OBJECTIVO_TREINO_OMISSAO);
        
    }

    /**
     * Gives the IRS tax index constant value.
     * 
     * @return IRS tax index constant value.
     * 
     */
    public static double getIRS() {
        return IRS;
    }

    /**
     * Gives the nome (name) for a given Atleta.
     * 
     * @return  the nome (name) for a given Atleta (nome as a String, first name or first and last names).
     * 
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets the nome (name) for a given Atleta.
     * 
     * @param nome sets the nome (name) for a given Atleta (nome as a String, first name or first and last names).
     * 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Gives the Numero de Identidicacao Civil (Civil Id number) for a given Atleta.
     * 
     * @return the Numero de Identidicacao Civil for a given Atleta (numIdCivil as an int, composed by 7 to 9 digits).
     * 
     */
    public int getNumIdCivil() {
        return numIdCivil;
    }

    /**
     * Sets the Numero de Identidicacao Civil (Civil Id number) for a given Atleta.
     * 
     * @param numIdCivil sets the Numero de Identidicacao Civil for a given Atleta
     * (numIdCivil as an int, composed by 7 to 9 digits).
     * 
     */
    public void setNumIdCivil(int numIdCivil) {
        this.numIdCivil = numIdCivil;
    }

    /**
     * Gives the Idade (age) in years for a given Atleta.
     * 
     * @return the Idade (age) for a given Atleta (idade as an int given in years and greater than 0)
     * 
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Sets the idade (age) in years for a given Atleta.
     *
     * @param idade sets the idade (age) for a given Atleta (idade as an int given in years and greater than 0)
     * 
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Gives the Frequencia Cardiaca em Repouso (rest heart rate) for a given Atleta.
     * 
     * @return the Frequencia Cardiaca em Repouso (rest heart rate) for a given Atleta (freqCardRepouso as a double, value between 0 and 200)
     * 
     */
    public double getFreqCardRepouso() {
        return freqCardRepouso;
    }

    /**
     * Sets the Frequencia Cardiaca em Repouso (rest heart rate) for a given Atleta.
     * 
     * @param freqCardRepouso sets the Frequencia Cardiaca em Repouso (rest heart rate) for a given Atleta
     * (freqCardRepouso as a double, value between 0 and 200)
     * 
     */
    public void setFreqCardRepouso(double freqCardRepouso) {
        this.freqCardRepouso = freqCardRepouso;
    }

    /**
     * Gives the premioAcumulado (monthly competition prize value) in Euros for a given Atleta.
     * 
     * @return the premioAcumulado (monthly competition prize value) in Euros for a given Atleta
     * (premioAcumulado as a double, total monthly value for competition prizes of an Atleta)
     * 
     */
    public double getPremioAcumulado() {
        return premioAcumulado;
    }

    /**
     * Sets the premioAcumulado (monthly competition prize value) in Euros for a given Atleta.
     * 
     * @param premioAcumulado sets the premioAcumulado (monthly competition prize value) in Euros for a given Atleta
     * (premioAcumulado as a double, total monthly value for competition prizes of an Atleta)
     * 
     */
    public void setPremioAcumulado(double premioAcumulado) {
        this.premioAcumulado = premioAcumulado;
    }

    /**
     * Gives the new value for premioAcumulado (monthly competition prize value) in Euros, by adding an additional prize value in Euros (valor) to the previous premioAcumulado value.
     * 
     * @param valor gives the new value for premioAcumulado (monthly competition prize value) in Euros by adding an additional prize value in Euros (valor) to the previous premioAcumulado value.
     * 
     */
    public void addPremio(double valor){
        setPremioAcumulado(getPremioAcumulado() + valor);
    }

    /**
     * Gives genero (gender), as a String, for a given Atleta.
     * 
     * @return genero (gender), as a String, for a given Atleta (can be MASCULINO or FEMININO).
     * 
     */
    public String getGenero() {
        return genero.toString();
    }

    /**
     * Sets genero (gender) for a given Atleta.
     * 
     * @param genero sets genero (gender) for a given Atleta (can be MASCULINO or FEMININO).
     * 
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * Gives atividade (activity type), as a String, for a given Atleta.
     * 
     * @return atividade (activity type), as a String, for a given Atleta (can be CAMINHADA, CORRIDA, CICLISMO or NATACAO).
     * 
     */
    public String getAtividade() {
        return atividade.toString();
    }

    /**
     * Sets the atividade (activity type) for a given Atleta.
     * 
     * @param atividade sets the atividade (activity type) for a given Atleta (can be CAMINHADA, CORRIDA, CICLISMO or NATACAO).
     * 
     */
    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }


    /**
     * Gives objectivoTreino (training objective), as String, for a given Atleta.
     * 
     * @return objectivoTreino (training objective), as String, for a given Atleta (can be QUEIMA_GORDURA or CAPACIDADE_CARDIORESPIRATORIA).
     * 
     */
    public String getObjectivoTreino() {
        return objectivoTreino.toString();
    }

    /**
     * Sets the objectivoTreino (training objective) for a given Atleta.
     * 
     * @param objectivoTreino sets the objectivoTreino (training objective) for a given Atleta (can be QUEIMA_GORDURA or CAPACIDADE_CARDIORESPIRATORIA).
     * 
     */
    public void setObjectivoTreino(ObjectivoTreino objectivoTreino) {
        this.objectivoTreino = objectivoTreino;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * <p>
     * The {@code equals} method implements an equivalence relation
     * on non-null object references:
     * 
     * @param   o   the reference object with which to compare.
     * @return  {@code true} if this object is the same as the obj
     *          argument; {@code false} otherwise.
     * 
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atleta atleta = (Atleta) o;
        return getNumIdCivil() == atleta.getNumIdCivil() &&
                getIdade() == atleta.getIdade() &&
                Double.compare(atleta.getFreqCardRepouso(), getFreqCardRepouso()) == 0 &&
                Double.compare(atleta.getPremioAcumulado(), getPremioAcumulado()) == 0 &&
                Objects.equals(getNome(), atleta.getNome()) &&
                getGenero() == atleta.getGenero() &&
                getAtividade() == atleta.getAtividade() &&
                getObjectivoTreino() == atleta.getObjectivoTreino();
    }
    

    /**
     * Gives the final value for the Atleta payment, considering the sum of the two parcels (determinarParcela1() + determinarParcela2()).
     * 
     * @return the final value for the Atleta payment, considering the sum of the two parcels (determinarParcela1() + determinarParcela2()).
     * 
     * see {@link #determinarParcela1()}
     * see {@link #determinarParcela2()}
     * 
     */
    public double calcularPagamento() {
        return determinarParcela1() + determinarParcela2();
    }

    /**
     * Gives the value of parcel 1/2 of athlete payment.
     * 
     * @return value for parcel 1 out of 2 for the Atleta payment calculation.
     * 
     * see {@link #calcularPagamento()}
     * see {@link #determinarParcela1()} implementation in subclasses
     * 
     */
    public abstract double determinarParcela1();

    /**
     * Gives the value of parcel 2/2 of athlete payment.
     * 
     * @return value for parcel 2 out of 2 for the Atleta payment calculation.
     * 
     * see {@link #calcularPagamento()}
     * see {@link #determinarParcela2()} implementation in subclasses
     * 
     */
    public abstract double determinarParcela2();


    /**
     * Frequencia Cardiaca de Trabalho (work heart rate), considering the following formulla: FCT = FCR + [IT * (FCM - FCR)].
     * 
     * @return the value for Frequiencia Cardiaca de Trabalho (work heart rate), considering the following formulla
     * FCT = FCR + [IT * (FCM - FCR)]
     * 
     * see {@link #getFreqCardRepouso()}
     * see {@link #determinarIT()}
     * see {@link #freqCardMax()}
     * 
     */
    public double freqCardTrabalho(){
        return getFreqCardRepouso() + (determinarIT() * (freqCardMax() - getFreqCardRepouso()));
    }

    /**
     * Frequïencia Cardiaca Maxima (max heart rate) considering the activity, gender and age of the athlete (Atleta).
     * 
     * @return the Frequencia Cardiaca Maxima (max heart rate) considering the activity, gender and age of the athlete (Atleta).
     * 
     * see {@link #getGenero()}
     * see {@link #getIdade()}
     * see {@link #getAtividade()}
     * 
     */
    public double freqCardMax(){
        if (this.atividade == Atividade.CAMINHADA || this.atividade == Atividade.CORRIDA){
            return 208.75 - (0.73 * getIdade());
        }
        else {
            if (this.atividade == Atividade.NATACAO){
                return 204 - (1.7 * getIdade());
            }
            else {
                if (this.atividade == Atividade.CICLISMO && this.genero == Genero.FEMININO){
                    return 189 - (0.56 * getIdade());
                    }
                else {
                    return 202 - (0.72 * getIdade());
                }
            }
        }
    }

    /**
     * Intensidade de Treino (training intensity) according with the training objective (Objectivio de Treino).
     * 
     * @return value for Intensidade de Treino (training intensity) according with the training objective (Objectivio de Treino).
     * 
     * See {@link #getObjectivoTreino()}
     * 
     */
    public double determinarIT(){
        if (this.objectivoTreino == ObjectivoTreino.CAPACIDADE_CARDIORESPIRATORIA){
            return CARDIO_IT;
        }
        else{
            return QUEIMA_IT;
        }
    }
    
    /**
     * Returns a string representation of the object Atleta and its attributes.
     *
     * The result should be a concise but informative representation that is easy
     * for a person to read.
     * It is overriden by all subclasses.
     *
     * @return  a string representation of the object.
     * 
     */
    @Override
    public String toString(){
        return String.format("Tipo de Atleta: %s%nNome: %s || Numero de Identificacao Civil: %d || Idade: %d || Genero: %s"
                + "%nAtividade: %s || Objectivo de treino: %s || Frequencia Cardiaca de Treino: %s%n"
                + "Valor dos Premios Mensal: %.2f || "
                + "", this.getClass().getSimpleName(), getNome(), getNumIdCivil(), getIdade(), getGenero(), getAtividade(), getObjectivoTreino(), getFreqCardRepouso(), getPremioAcumulado());
    }

    public String toStringFicheiroTexto() {
        return String.format("%s%c%s%c%d%c%d%c%.2f%c%.2f%c%s%c%s%c%s", this.getClass().getSimpleName(), SEPARADOR, nome, SEPARADOR, numIdCivil, SEPARADOR, idade, SEPARADOR,
                freqCardRepouso, SEPARADOR, premioAcumulado, SEPARADOR, genero, SEPARADOR, atividade, SEPARADOR, objectivoTreino);
    }



    /**
     * Compares this object with the specified object for order.  
     *
     * @param   a the object to be compared.
     * @return  a negative integer, zero, or a positive integer as this object
     *          is less than, equal to, or greater than the specified object.
     *
     */
    @Override
    public int compareTo(Atleta a) {
        return this.getNome().compareToIgnoreCase(a.getNome());
    }
}
