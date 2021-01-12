import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Methods {

    public static Data lerData() throws MesInvalidoException, DiaInvalidoException {
        Scanner ler = new Scanner(System.in);
        boolean invalid = true;
        Data d1 = new Data();

        do {
            try {
                System.out.print("Data de Aniversário(aaaa/mm/dd):");
                String data = ler.nextLine();
                if (validarData(data)) {
                    int ano = Integer.parseInt(data.split("/")[0]);
                    int mes = Integer.parseInt(data.split("/")[1]);
                    int dia = Integer.parseInt(data.split("/")[2]);
                    d1.setData(ano, mes, dia);
                    invalid = false;
                } else {
                    System.out.println("Formato invalido!");
                }
            } catch (DiaInvalidoException | MesInvalidoException e) {
                System.out.println(e.getMessage());
            }
        } while (invalid);

        return d1;
    }

    private static boolean validarData(String data) {
        if (data.length() != 10) {
            return false;
        } else return data.split("/").length == 3;
    }

    public static Formatter criarFicheiro() {
        Scanner scn = new Scanner(System.in);
        Formatter output = null;
        boolean unresolved = true;
        do {
            try {
                System.out.println("Nome do ficheiro: ");
                String filename = scn.nextLine();
                output = new Formatter(filename);
                unresolved = false;
            } catch (Exception e) {
                System.out.println("Nao foi possivel criar o ficheiro!");
            }
        } while (unresolved);
        System.out.println("Ficheiro criado");
        return output;
    }

    public static String lerNome() {
        String name = null;
        Scanner scn = new Scanner(System.in);
        boolean unresolved = true;
        do {
            try {
                System.out.println("Nome ('ENTER' para terminar): ");
                name = scn.nextLine();
                if (stringIsLettersOnly(name)) {
                    unresolved = false;
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        } while (unresolved);

        return name;
    }

    public static boolean stringIsLettersOnly(String s) {
        if (s.length() > 0) {
            for (Character c : s.toCharArray()) {
                if (!Character.isLetter(c) && !Character.isSpaceChar(c)) {
                    System.out.println("nome tem caractéres inválidos");
                    return false;
                } else if (s.isBlank()){
                    System.out.println("Nome só tem espaços");
                    return false;
                }
            }
        }
        return true;
    }
}
