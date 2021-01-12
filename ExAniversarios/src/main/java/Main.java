import java.text.Normalizer;
import java.util.Formatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws MesInvalidoException, DiaInvalidoException {
        String name = null;
        Scanner scn = new Scanner(System.in);
        Formatter output = Methods.criarFicheiro();

        name = Methods.lerNome();
        while (!name.equals("")) {
            Data dataNasc = Methods.lerData();
            output.format("%s; %s %n", name, dataNasc);
            name = Methods.lerNome();
        }
        output.close();
        System.out.println("Aplicação Terminada");
    }
}
