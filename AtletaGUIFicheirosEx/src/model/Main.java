package model;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        FicheirosAtleta ficheiro = new FicheirosAtleta();

        //Criação do clube desportivo
        ClubeDesportivo cb1 = new ClubeDesportivo("Vigorosa", "30-5-1965", ficheiro.desserializarTodos());

        cb1.addListaAtletas(ficheiro.importarTextoTodos());

       /* //Criação de 3 instâncias de Atleta Amador
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
                Genero.FEMININO, Atividade.NATACAO, ObjectivoTreino.CAPACIDADE_CARDIORESPIRATORIA, 21);*/
/*
        //Armazenamento das instâncias criadas no Clube Desportivo
        cb1.addAtleta(aa1);
        cb1.addAtleta(aa2);
        cb1.addAtleta(aa3);
        cb1.addAtleta(ap1);
        cb1.addAtleta(ap2);
        cb1.addAtleta(ap3);
        cb1.addAtleta(asp1);
        cb1.addAtleta(asp2);
        cb1.addAtleta(asp3);*/

        ficheiro.exportarTextoAtletaSemiProfissional(cb1);
        ficheiro.exportarTextoAtletaAmador(cb1);
        ficheiro.serializarAtletaProfissional(cb1);
        ficheiro.serializarAtletaAmador(cb1);



        cb1.addListaAtletas(ficheiro.importarTextoAtletaAmador());

        System.out.println(cb1.getAtletasInscritos());

        ficheiro.serializarTodos(cb1);

    }

    public static void printArrayList(ArrayList<Atleta> arrayList) {
        for (Atleta a : arrayList) {
            System.out.println(a);
            System.out.println("----------------");
        }
    }
}
