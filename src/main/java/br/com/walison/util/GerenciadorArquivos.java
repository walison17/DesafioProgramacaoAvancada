/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.walison.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author walison
 */
abstract public class GerenciadorArquivos {

    protected static String NOME_PASTA;
    protected static String NOME_ARQUIVO;

    protected void verificarPasta() {

        File pasta = new File(NOME_PASTA);

        if (!pasta.exists()) {
            try {
                pasta.mkdir();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    abstract public void listaParaArquivo(List lista) ;

    abstract public <T> List<T> arquivoParaLista(Class<T[]> clazz) throws FileNotFoundException;

    abstract public int contadorAtualizado(List lista);

}
