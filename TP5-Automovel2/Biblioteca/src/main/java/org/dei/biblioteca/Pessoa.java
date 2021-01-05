
package org.dei.biblioteca;

/**
 * Representa uma pessoa através do seu nome e número ID Civil do cartão do
 * cidadão.
 *
 * @author ISEP-DEI-PPROG
 */
public class Pessoa implements Comparable<Pessoa> {

    /**
     * O nome da pessoa.
     */
    private String nome;
    
    /**
     * O número ID Civil do cartão do cidadão da pessoa.
     */
    private int idCivil;

    /**
     * O nome por omissão.
     */
    private static final String NOME_POR_OMISSAO = "sem nome";
    
    /**
     * O número ID Civil do cartão do cidadão por omissão.
     */
    private static final int IDCIVIL_POR_OMISSAO = 0;

    /**
     * Constrói uma instância de Pessoa recebendo o nome e o número ID Civil do
     * cartão do cidadão.
     *
     * @param nome o nome da pessoa.
     * @param idCivil o número ID Civil do cartão do cidadão.
     */
    public Pessoa(String nome, int idCivil) {
        this.nome = nome;
        this.idCivil = idCivil;
    }

    /**
     * Constrói uma instância de Pessoa com o nome e o número ID Civil do cartão
     * do cidadão, por omissão.
     */
    public Pessoa() {
        nome = NOME_POR_OMISSAO;
        idCivil = IDCIVIL_POR_OMISSAO;
    }

    /**
     * Constrói uma instância de Pessoa com as mesmas caraterísticas da pessoa
     * recebida por parâmetro.
     *
     * @param outraPessoa a pessoa com as características a copiar.
     */
    public Pessoa(Pessoa outraPessoa) {
        nome = outraPessoa.nome;
        idCivil = outraPessoa.idCivil;
    }

    /**
     * Devolve o nome da pessoa.
     *
     * @return nome da pessoa.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Devolve o número ID Civil do cartão do cidadão da pessoa.
     *
     * @return número ID Civil do cartão do cidadão da pessoa.
     */
    public int getIDCivil() {
        return idCivil;
    }

    /**
     * Modifica o nome da pessoa.
     *
     * @param nome o novo nome da pessoa.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Modifica o número ID Civil do cartão do cidadão da pessoa.
     *
     * @param idCivil o novo número ID Civil do cartão do cidadão da pessoa.
     */
    public void setIDCivil(int idCivil) {
        this.idCivil = idCivil;
    }

    /**
     * Devolve a descrição textual da pessoa.
     *
     * @return caraterísticas da pessoa.
     */
    @Override
    public String toString() {
        return String.format("%s tem o cartão do cidadão com o número ID Civil %d.",
                nome, idCivil);
    }

    /**
     * Compara a pessoa com o objeto recebido.
     *
     * @param outroObjeto o objeto a comparar com a pessoa.
     * @return true se o objeto recebido representar uma pessoa equivalente à
     *         pessoa. Caso contrário, retorna false.
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Pessoa outraPessoa = (Pessoa) outroObjeto;
        return nome.equalsIgnoreCase(outraPessoa.nome)
                && idCivil == outraPessoa.idCivil;
    }

    /**
     * Compara alfabeticamente os nomes da pessoa e da outra pessoa recebida por
     * parâmetro.
     *
     * @param outraPessoa a pessoa a ser comparada.
     * @return o valor 0 se a outraPessoa recebida tem o mesmo nome da pessoa;
     *         o valor -1 se, alfabeticamente, o nome da pessoa for anterior ao 
     *         nome da outraPessoa; o valor 1 se, alfabeticamente, o nome da 
     *         pessoa for posterior ao nome da pessoa.
     */
    @Override
    public int compareTo(Pessoa outraPessoa) {
        return nome.compareToIgnoreCase(outraPessoa.nome);
    }
}

