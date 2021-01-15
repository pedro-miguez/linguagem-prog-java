package sprint.clube.desportivo;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        //Criação do clube desportivo
        ClubeDesportivo cb1 = new ClubeDesportivo("Vigorosa", "30-5-1965", new ArrayList<Atleta>());

        //Criação de 3 instâncias de Atleta Amador
        AtletaAmador aa1 = new AtletaAmador("Joana", 123, 20, 51, 250,
                Genero.FEMININO, Atividade.CICLISMO, ObjectivoTreino.CAPACIDADE_CARDIORESPIRATORIA, 10);
        AtletaAmador aa2 = new AtletaAmador("Andrade", 1234, 50, 60, 99,
                Genero.MASCULINO, Atividade.CAMINHADA, ObjectivoTreino.QUEIMA_GORDURA, 21);
        AtletaAmador aa3 = new AtletaAmador("Miguel", 12345, 42, 71, 150,
                Genero.MASCULINO, Atividade.NATACAO, ObjectivoTreino.QUEIMA_GORDURA, 2);

        //Criação de 3 instâncias de Atleta Profissional
        AtletaProfissional ap1 = new AtletaProfissional("Zelda", 111, 20, 55, 421,
                Genero.FEMININO, Atividade.CORRIDA, ObjectivoTreino.CAPACIDADE_CARDIORESPIRATORIA, 200);
        AtletaProfissional ap2 = new AtletaProfissional("Velda", 112, 50, 80, 101,
                Genero.MASCULINO, Atividade.NATACAO, ObjectivoTreino.QUEIMA_GORDURA, 180);
        AtletaProfissional ap3 = new AtletaProfissional("Mario", 113, 19, 60, 259,
                Genero.MASCULINO, Atividade.CICLISMO, ObjectivoTreino.QUEIMA_GORDURA, 154);

        //Criação de 3 instâncias de Atleta Semi Profissional
        AtletaSemiProfissional asp1 = new AtletaSemiProfissional("Luisa", 1, 24, 59, 333,
                Genero.FEMININO, Atividade.NATACAO, ObjectivoTreino.QUEIMA_GORDURA, 8);
        AtletaSemiProfissional asp2 = new AtletaSemiProfissional("Rodrigo", 2, 44, 44, 221,
                Genero.MASCULINO, Atividade.CICLISMO, ObjectivoTreino.CAPACIDADE_CARDIORESPIRATORIA, 2);
        AtletaSemiProfissional asp3 = new AtletaSemiProfissional("Maria", 3, 31, 50, 198,
                Genero.FEMININO, Atividade.NATACAO, ObjectivoTreino.CAPACIDADE_CARDIORESPIRATORIA, 21);

        //Armazenamento das instâncias criadas no Clube Desportivo
        cb1.addAtleta(aa1);
        cb1.addAtleta(aa2);
        cb1.addAtleta(aa3);
        cb1.addAtleta(ap1);
        cb1.addAtleta(ap2);
        cb1.addAtleta(ap3);
        cb1.addAtleta(asp1);
        cb1.addAtleta(asp2);
        cb1.addAtleta(asp3);

        //Listagem dos Atletas Amadores e SemiProfissionais: Nome, FCM, FCT
        System.out.println("#### - Listagem dos Atletas Amadores e Semi Profissionais: Nome, FCM, FCT - ###");
        for (Atleta a : cb1.getAtletasInscritos()) {
            if (a instanceof AtletaSemiProfissional || a instanceof AtletaAmador) {
                System.out.printf("Nome: %s | FCM: %.2f | FCT: %.2f %n", a.getNome(), a.freqCardMax(), a.freqCardTrabalho());
            }
        }
        System.out.println();

        //Listagem: Nome e Valor a Pagar a cada atleta
        System.out.println("#### - Listagem: Nome e Valor a Pagar a cada atleta - ###");
        for (Atleta a : cb1.getAtletasInscritos()) {
            System.out.printf("Nome: %s | Valor a Pagar: %.2f %n", a.getNome(), a.calcularPagamento());

        }
        System.out.println();

        //Apresentação de Instâncias
        System.out.println("#### - Numero de instancias criadas em cada classe - ###");
        System.out.println("Instancias de Atleta Amador: " + AtletaAmador.getTotalAtletasAmador());
        System.out.println("Instancias de Atleta Profissional: " + AtletaProfissional.getTotalAtletasProfissional());
        System.out.println("Instancias de Atleta Semi Profissional: " + AtletaSemiProfissional.getTotalAtletasSemiProfissional());
        System.out.println();

        //Calcular e apresentar o valor total a pagar a cada tipo de atleta, e o valor total desses pagamentos
        System.out.println("#### - Calcular e apresentar o valor total a pagar a cada tipo de atleta, " +
                "e o valor total desses pagamentos - ###");
        double sumAmador = 0;
        double sumPro = 0;
        double sumSemiPro = 0;
        for (Atleta a : cb1.getAtletasInscritos()) {
            if (a instanceof AtletaAmador) {
                sumAmador += a.calcularPagamento();
            } else if (a instanceof AtletaProfissional) {
                sumPro += a.calcularPagamento();
            } else {
                sumSemiPro += a.calcularPagamento();
            }
        }
        double sumTotal = sumAmador + sumPro + sumSemiPro;

        System.out.printf("Valor a pagar aos Atletas Amadores: %.2f %n", sumAmador);
        System.out.printf("Valor a pagar aos Atletas Profissionais: %.2f %n", sumPro);
        System.out.printf("Valor a pagar aos Atletas Semi Profissionais: %.2f %n", sumSemiPro);
        System.out.printf("Valor total a pagar: %.2f %n", sumTotal);
        System.out.println();

        //Funcionalidades da classe Clube Desportivo
        System.out.println("#### - Funcionalidades da classe Clube Desportivo - ###");
        System.out.println("Nome do clube: " + cb1.getNomeClube());
        System.out.println();
        System.out.println("#### - Adicionar um atleta: ArrayList antes de adicionar - ###");
        printArrayList(cb1.getAtletasInscritos());
        AtletaAmador aa4 = new AtletaAmador("Hector", 123, 55, 51, 500,
                Genero.MASCULINO, Atividade.CICLISMO, ObjectivoTreino.CAPACIDADE_CARDIORESPIRATORIA, 12);
        cb1.addAtleta(aa4);
        System.out.println("#### - Adicionar um atleta: ArrayList depois de adicionar - ###");
        printArrayList(cb1.getAtletasInscritos());
        System.out.println();

        System.out.println("#### - Ordenacao Alfabetica por nome: antes de ordenar - ###");
        Collections.shuffle(cb1.getAtletasInscritos());
        printArrayList(cb1.getAtletasInscritos());
        System.out.println("#### - Ordenacao Alfabetica por nome: depois de ordenar - ###");
        printArrayList(cb1.getSortedByName());
        System.out.println();

        System.out.println("#### - Ordenacao Inversa Por Premio: antes de ordenar - ###");
        Collections.shuffle(cb1.getAtletasInscritos());
        printArrayList(cb1.getAtletasInscritos());
        System.out.println("#### - Ordenacao Inversa Por Premio: depois de ordenar - ###");
        printArrayList(cb1.getReverseSortedByPremio());
        System.out.println();

        System.out.println("#### - Ordenacao Por Categoria, Modalidade, e Nome: antes de ordenar - ###");
        Collections.shuffle(cb1.getAtletasInscritos());
        printArrayList(cb1.getAtletasInscritos());
        System.out.println("#### - Ordenacao Por Categoria, Modalidade, e Nome: depois de ordenar - ###");
        printArrayList(cb1.getSortedByTypeThenActivityThenName());
        System.out.println();

        System.out.println("#### - Valor total a pagar para efeitos de IRS - ###");
        System.out.printf("Valor total do IRS: %.2f", cb1.calcularValorTotalIRS(cb1.getAtletasInscritos()));
    }

    public static void printArrayList(ArrayList<Atleta> arrayList) {
        for (Atleta a : arrayList) {
            System.out.println(a);
            System.out.println("----------------");
        }
    }
}
