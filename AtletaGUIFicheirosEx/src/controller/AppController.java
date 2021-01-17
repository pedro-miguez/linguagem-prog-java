package controller;

import model.Atleta;
import model.ClubeDesportivo;
import model.FicheirosAtleta;
import model.TipoAtleta;

import java.io.File;
import java.util.List;

public class AppController {

    private ClubeDesportivo clube;
    private FicheirosAtleta ficheirosAtleta;

    public AppController() {
        ficheirosAtleta = new FicheirosAtleta();

        desserializarTodos();
    }


    public boolean serializarTodos() {
        return ficheirosAtleta.serializarTodos(clube);
    }

    public boolean serializarAtletasProfissionais() {
        return ficheirosAtleta.serializarAtletaProfissional(clube);
    }

    public boolean serializarTodosEscolherFicheiro(File ficheiroSerializar) {
        return ficheirosAtleta.serializar(ficheiroSerializar, clube, TipoAtleta.ATLETA);
    }

    public void desserializarTodos() {
        clube = new ClubeDesportivo("Descrição", "2020", ficheirosAtleta.desserializarTodos());
    }

    public int desserializarFicheiroEscolhido(File ficheiroImportar) {
        return clube.addListaAtletas(ficheirosAtleta.desserializar(ficheiroImportar));
    }

    public int desserializarAtletasProfissionais() {
        return clube.addListaAtletas(ficheirosAtleta.desserializarAtletaProfissional());
    }

    public int importarTextoTodos() {
        return clube.addListaAtletas(ficheirosAtleta.importarTextoTodos());
    }

    public int importarTextoFicheiroEscolhido(File ficheiroImportar) {
        return clube.addListaAtletas(ficheirosAtleta.importarTexto(ficheiroImportar));
    }

    public int importarAtletasProfissionais() {
        return clube.addListaAtletas(ficheirosAtleta.importarTextoAtletaProfissional());
    }

    public boolean exportarTodos() {
        return ficheirosAtleta.exportarTextoTodos(clube);
    }

    public boolean exportarAtletasProfissionais() {
        return ficheirosAtleta.exportarTextoAtletaProfissional(clube);
    }

    public boolean exportarTodosEscolherFicheiro(File ficheiroExportar) {
        return ficheirosAtleta.exportarTexto(ficheiroExportar, clube, TipoAtleta.ATLETA);
    }

    public boolean listaVazia() {
        return clube.getAtletasInscritos().isEmpty();
    }

    public List<Atleta> getListaAtletas() {
        return clube.getAtletasInscritos();
    }

}
