package sprint.clube.desportivo;

import javax.management.InstanceAlreadyExistsException;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FicheirosAtleta {


    private static final String NOME_FICHEIRO_ATLETA = "Ficheiro Lista Atletas.ser";
    private static final String NOME_FICHEIRO_ATLETA_NPRO = "Ficheiro Lista Atletas Não Profissionais.ser";
    private static final String NOME_FICHEIRO_ATLETA_PRO = "Ficheiro Lista Atletas Profissionais.ser";
    private static final String NOME_FICHEIRO_ATLETA_AMADOR = "Ficheiro Lista Atletas Amadores.ser";
    private static final String NOME_FICHEIRO_ATLETA_SEMIPRO = "Ficheiro Lista Atletas Semi-Profissionais.ser";

    private static final String NOME_FICHEIRO_ATLETA_TEXTO = "Ficheiro Lista Atletas.txt";
    private static final String NOME_FICHEIRO_ATLETA_NPRO_TEXTO = "Ficheiro Lista Atletas Não Profissionais.txt";
    private static final String NOME_FICHEIRO_ATLETA_PRO_TEXTO = "Ficheiro Lista Atletas Profissionais.txt";
    private static final String NOME_FICHEIRO_ATLETA_AMADOR_TEXTO = "Ficheiro Lista Atletas Amadores.txt";
    private static final String NOME_FICHEIRO_ATLETA_SEMIPRO_TEXTO = "Ficheiro Lista Atletas Semi-Profissionais.txt";

    public FicheirosAtleta() {

    }

    public boolean serializarTodos(ClubeDesportivo cd) {
        return serializar(NOME_FICHEIRO_ATLETA, cd, TipoAtleta.ATLETA);
    }

    public boolean serializarAtletaAmador(ClubeDesportivo cd) {
        return serializar(NOME_FICHEIRO_ATLETA_AMADOR, cd, TipoAtleta.AMADOR);
    }

    public boolean serializarAtletaNaoProfissional(ClubeDesportivo cd) {
        return serializar(NOME_FICHEIRO_ATLETA_NPRO, cd, TipoAtleta.NAO_PROFISSIONAL);
    }

    public boolean serializarAtletaSemiProfissional(ClubeDesportivo cd) {
        return serializar(NOME_FICHEIRO_ATLETA_SEMIPRO, cd, TipoAtleta.SEMIPROFISSIONAL);
    }

    public boolean serializarAtletaProfissional(ClubeDesportivo cd) {
        return serializar(NOME_FICHEIRO_ATLETA_PRO, cd, TipoAtleta.PROFISSIONAL);
    }

    public ArrayList<Atleta> desserializarTodos() {
        return desserializar(NOME_FICHEIRO_ATLETA);
    }

    public ArrayList<Atleta> desserializarAtletaAmador() {
        return desserializar(NOME_FICHEIRO_ATLETA_AMADOR);
    }

    public ArrayList<Atleta> desserializarAtletaNaoProfissional() {
        return desserializar(NOME_FICHEIRO_ATLETA_NPRO);
    }

    public ArrayList<Atleta> desserializarAtletaSemiProfissional() {
        return desserializar(NOME_FICHEIRO_ATLETA_SEMIPRO);
    }

    public ArrayList<Atleta> desserializarAtletaProfissional() {
        return desserializar(NOME_FICHEIRO_ATLETA_PRO);
    }

    public boolean exportarTextoTodos(ClubeDesportivo cd) {
        return exportarTexto(new File(NOME_FICHEIRO_ATLETA_TEXTO), cd, TipoAtleta.ATLETA);
    }

    public boolean exportarTextoAtletaAmador(ClubeDesportivo cd) {
        return exportarTexto(new File(NOME_FICHEIRO_ATLETA_AMADOR_TEXTO), cd, TipoAtleta.AMADOR);
    }

    public boolean exportarTextoAtletaNaoProfissional(ClubeDesportivo cd) {
        return exportarTexto(new File(NOME_FICHEIRO_ATLETA_NPRO_TEXTO), cd, TipoAtleta.NAO_PROFISSIONAL);
    }

    public boolean exportarTextoAtletaSemiProfissional(ClubeDesportivo cd) {
        return exportarTexto(new File(NOME_FICHEIRO_ATLETA_SEMIPRO_TEXTO), cd, TipoAtleta.SEMIPROFISSIONAL);
    }

    public boolean exportarTextoAtletaProfissional(ClubeDesportivo cd) {
        return exportarTexto(new File(NOME_FICHEIRO_ATLETA_PRO_TEXTO), cd, TipoAtleta.PROFISSIONAL);
    }

    public ArrayList<Atleta> importarTextoAtletaProfissional() {
        return importarTexto(new File(NOME_FICHEIRO_ATLETA_PRO_TEXTO));
    }

    public ArrayList<Atleta> importarTextoTodos() {
        return importarTexto(new File(NOME_FICHEIRO_ATLETA_TEXTO));
    }

    public ArrayList<Atleta> importarTextoAtletaAmador() {
        return importarTexto(new File(NOME_FICHEIRO_ATLETA_AMADOR_TEXTO));
    }

    public ArrayList<Atleta> importarTextoAtletaNaoProfissional() {
        return importarTexto(new File(NOME_FICHEIRO_ATLETA_NPRO_TEXTO));
    }

    public ArrayList<Atleta> importarTextoAtletaSemiProfissional() {
        return importarTexto(new File(NOME_FICHEIRO_ATLETA_SEMIPRO_TEXTO));
    }

    public boolean serializar(String nomeFicheiro, ClubeDesportivo cd, TipoAtleta tipoAtleta) {
        return serializar (new File(nomeFicheiro), cd, tipoAtleta);
    }

    public ArrayList<Atleta> desserializar(String nomeFicheiro) {
        return desserializar(new File(nomeFicheiro));
    }

    public boolean serializar(File ficheiro, ClubeDesportivo cd, TipoAtleta tipoAtleta) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(ficheiro));
            try {
                out.writeObject(cd.getListaAtletasDadoTipo(tipoAtleta));
                return true;
            } finally {
                out.close();
            }
        } catch (IOException ex) {
            return false;
        }
    }

    public ArrayList<Atleta> desserializar(File ficheiro) {
        ArrayList<Atleta> listaAtletas;
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(ficheiro));
            try {
                listaAtletas = (ArrayList<Atleta>) in.readObject();

                return listaAtletas;
            } finally {
                in.close();
            }
        } catch (IOException | ClassNotFoundException ex) {
            return new ArrayList<>();
        }
    }



    public boolean exportarTexto(File ficheiro, ClubeDesportivo cd, TipoAtleta tipoAtleta) {
        try {
            PrintWriter out = new PrintWriter(ficheiro);
            String[] listaAtletasParaFicheiro = cd.getListaAtletasComoArray(tipoAtleta);

            try {
                for (int i = 0; i < listaAtletasParaFicheiro.length - 1; i++) {
                    out.print(listaAtletasParaFicheiro[i] + "\n");
                }
                out.print(listaAtletasParaFicheiro[listaAtletasParaFicheiro.length - 1]);

                return true;
            } finally {
                out.close();
            }
        } catch (IOException ex) {
            return false;
        }
    }

    public ArrayList<Atleta> importarTexto(File ficheiro) {
        try {
            ArrayList<Atleta> lista = new ArrayList<>();
            Scanner in = new Scanner(ficheiro);

            try {
                while (in.hasNextLine()) {
                    String linha = in.nextLine();
                    switch (linha.split(String.valueOf(Atleta.SEPARADOR))[0]) {
                        case "AtletaAmador":
                            String []dados = AtletaAmador.getAtletaComoArray(linha);
                            lista.add(new AtletaAmador(dados[1], Integer.parseInt(dados[2]), Integer.parseInt(dados[3]), Double.parseDouble(dados[4]),
                                    Double.parseDouble(dados[5]), Genero.valueOf(dados[6].toUpperCase()),
                                    Atividade.valueOf(dados[7].toUpperCase()), ObjectivoTreino.valueOf(dados[8].toUpperCase()), Integer.parseInt(dados[9])));
                            break;
                        case "AtletaProfissional":
                            dados = AtletaProfissional.getAtletaComoArray(linha);
                            lista.add(new AtletaProfissional(dados[1], Integer.parseInt(dados[2]), Integer.parseInt(dados[3]), Double.parseDouble(dados[4]),
                                    Double.parseDouble(dados[5]), Genero.valueOf(dados[6].toUpperCase()),
                                    Atividade.valueOf(dados[7].toUpperCase()), ObjectivoTreino.valueOf(dados[8].toUpperCase()), Double.parseDouble(dados[9])));
                            break;
                        case "AtletaSemiProfissional":
                            dados = AtletaSemiProfissional.getAtletaComoArray(linha);
                            lista.add(new AtletaSemiProfissional(dados[1], Integer.parseInt(dados[2]), Integer.parseInt(dados[3]), Double.parseDouble(dados[4]),
                                    Double.parseDouble(dados[5]), Genero.valueOf(dados[6].toUpperCase()),
                                    Atividade.valueOf(dados[7].toUpperCase()), ObjectivoTreino.valueOf(dados[8].toUpperCase()), Integer.parseInt(dados[9])));
                            break;
                    }
                }
                return lista;
            } finally {
                in.close();
            }
        } catch (IOException e) {
            return new ArrayList<Atleta>();
        }
    }


}
