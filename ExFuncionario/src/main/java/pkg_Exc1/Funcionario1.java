package pkg_Exc1;

public class Funcionario1 {
    private String nome;
    private float vencimento;

    private static final String NOME_POR_OMISSAO = "sem nome";
    private static final float VENC_POR_OMISSAO = 500;

    public Funcionario1() throws ExcecaoAlfabetoEspaco, ExcecaoVencimentoNegativo {
        setNome(NOME_POR_OMISSAO);
        setVencimento(VENC_POR_OMISSAO);
    }

    public Funcionario1(String nome, float vencimento) throws ExcecaoAlfabetoEspaco, ExcecaoVencimentoNegativo {
        setNome(nome);
        setVencimento(vencimento);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws ExcecaoAlfabetoEspaco {
        char c;
        for (int i = 0; i < nome.length(); i++) {
            c = nome.charAt(i);
            if (!Character.isLetter(c) && !Character.isSpaceChar(c))
                throw new ExcecaoAlfabetoEspaco("O " + nome + " tem caracteres que não são letras");
        }
        this.nome = nome;
    }

    public float getVencimento() {
        return vencimento;
    }

    public void setVencimento(float vencimento) throws ExcecaoVencimentoNegativo {
        if (vencimento < 0) {
            throw new ExcecaoVencimentoNegativo("Vencimento com valor negativo: " + vencimento);
        }
        this.vencimento = vencimento;
    }

    public String toString() {
        return nome + " tem o vencimento de " + vencimento;
    }

    // Para o efeito deste exercício, este método só deve ser adicionado depois do remove falhar!
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Funcionario1 obj = (Funcionario1) outroObjeto;
        return this.nome.equalsIgnoreCase(obj.nome) &&
                this.vencimento == obj.vencimento;
    }

}
