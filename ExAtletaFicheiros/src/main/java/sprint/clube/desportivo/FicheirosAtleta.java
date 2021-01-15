package sprint.clube.desportivo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FicheirosAtleta {


    private static final int ATLETA = 1;
    private static final String NOME_FICHEIRO_ATLETA = "Ficheiro Lista Atletas.ser";

    private static final int ATLETA_NAO_PROFISSIONAL = 2;
    private static final String NOME_FICHEIRO_ATLETA_NPRO = "Ficheiro Lista Atletas Não Profissionais.ser";

    private static final int ATLETA_PROFISSIONAL = 3;
    private static final String NOME_FICHEIRO_ATLETA_PRO = "Ficheiro Lista Atletas Profissionais.ser";

    private static final int ATLETA_AMADOR = 4;
    private static final String NOME_FICHEIRO_ATLETA_AMADOR = "Ficheiro Lista Atletas Amadores.ser";

    private static final int ATLETA_SEMI_PROFISSIONAL = 5;
    private static final String NOME_FICHEIRO_ATLETA_SEMIPRO = "Ficheiro Lista Atletas Semi-Profissionais.ser";

    public boolean serializar(File ficheiro, ClubeDesportivo cb, TipoAtleta tipoAtleta) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(ficheiro));
            try {
                out.writeObject(cb.getListaAtletasDadoTipo(cb.getAtletasInscritos(), tipoAtleta));
                return true;
            } finally {
                out.close();
            }
        } catch (IOException ex) {
            return false;
        }
    }


}
