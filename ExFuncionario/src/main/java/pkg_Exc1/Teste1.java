package pkg_Exc1;

import javax.swing.*;

public class Teste1 {
    public static void main(String[] args) {
        Funcionario1 f1 = null;
        Funcionario1 f2 = null;
        Funcionario1 f3 = null;
        Funcionario1 f4 = null;
        // Validar se os nomes têm só letras ou o caráter espaço
        try {
            f1 = new Funcionario1("Pedro Silva", 2000);
            f2 = new Funcionario1("Ana Gomes", 3500);
            f3 = new Funcionario1("Paulo 8arros", 900);
            f4 = new Funcionario1("Catarina Machado", 1500);
        } catch (ExcecaoAlfabetoEspaco | ExcecaoVencimentoNegativo e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        System.out.println("Listar funcionarios");
        if (f1 != null)
            System.out.println("f1 -> " + f1.toString());
        if (f2 != null)
            System.out.println("f2 -> " + f2.toString());
        if (f3 != null)
            System.out.println("f3 -> " + f3.toString());
        if (f4 != null)
            System.out.println("f4 -> " + f4.toString());
    }
}