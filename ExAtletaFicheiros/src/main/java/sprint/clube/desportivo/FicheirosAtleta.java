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

    public boolean importarTextoAtletaProfissional(ClubeDesportivo cd) {
        return exportarTexto(new File(NOME_FICHEIRO_ATLETA_PRO_TEXTO), cd, TipoAtleta.PROFISSIONAL);
    }

    public boolean importarTextoTodos(ClubeDesportivo cd) {
        return exportarTexto(new File(NOME_FICHEIRO_ATLETA_TEXTO), cd, TipoAtleta.ATLETA);
    }

    public boolean importarTextoAtletaAmador(ClubeDesportivo cd) {
        return exportarTexto(new File(NOME_FICHEIRO_ATLETA_AMADOR_TEXTO), cd, TipoAtleta.AMADOR);
    }

    public boolean importarTextoAtletaNaoProfissional(ClubeDesportivo cd) {
        return exportarTexto(new File(NOME_FICHEIRO_ATLETA_NPRO_TEXTO), cd, TipoAtleta.NAO_PROFISSIONAL);
    }

    public boolean importarTextoAtletaSemiProfissional(ClubeDesportivo cd) {
        return exportarTexto(new File(NOME_FICHEIRO_ATLETA_SEMIPRO_TEXTO), cd, TipoAtleta.SEMIPROFISSIONAL);
    }
    
    public boolean serializar(String nomeFicheiro, ClubeDesportivo cd, TipoAtleta tipoAtleta) {
        return serializar (new File(nomeFicheiro), cd, tipoAtleta);
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
                            lista.add(new AtletaAmador(dados[0], Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), Double.parseDouble(dados[3]),
                                    Double.parseDouble(dados[4]), Genero.valueOf(dados[5].toUpperCase()),
                                    Atividade.valueOf(dados[6].toUpperCase()), ObjectivoTreino.valueOf(dados[7].toUpperCase()), Integer.parseInt(dados[8])));
                            break;
                        case "AtletaProfissional":
                            dados = AtletaProfissional.getAtletaComoArray(linha);
                            lista.add(new AtletaProfissional(dados[0], Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), Double.parseDouble(dados[3]),
                                    Double.parseDouble(dados[4]), Genero.valueOf(dados[5].toUpperCase()),
                                    Atividade.valueOf(dados[6].toUpperCase()), ObjectivoTreino.valueOf(dados[7].toUpperCase()), Double.parseDouble(dados[8])));
                            break;
                        case "AtletaSemiProfissional":
                            dados = AtletaSemiProfissional.getAtletaComoArray(linha);
                            lista.add(new AtletaSemiProfissional(dados[0], Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), Double.parseDouble(dados[3]),
                                    Double.parseDouble(dados[4]), Genero.valueOf(dados[5].toUpperCase()),
                                    Atividade.valueOf(dados[6].toUpperCase()), ObjectivoTreino.valueOf(dados[7].toUpperCase()), Integer.parseInt(dados[8])));
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
