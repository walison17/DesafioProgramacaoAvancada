/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.walison.util;

import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author walison
 */
public class GerenciadorArquivosJson<T> extends GerenciadorArquivos {

    public GerenciadorArquivosJson(String nomePasta, String nomeArquivo) {
        NOME_PASTA = nomePasta;
        NOME_ARQUIVO = nomeArquivo + ".json";

        this.verificarPasta();
        this.inicializarJson();
    }

    @Override
    public <T> List<T> arquivoParaLista(Class<T[]> clazz) throws FileNotFoundException {
        if (this.verificarArquivoJson()) {

            BufferedReader json = new BufferedReader(new FileReader(NOME_PASTA + File.separator + NOME_ARQUIVO));

            T[] array = new Gson().fromJson(json, clazz);

            List<T> lista = new ArrayList<>();
            for (T obj:
                 array) {
                lista.add(obj);
            }

            return lista;

        } else {
            throw new FileNotFoundException("Arquivo json não encontrado na pasta " + NOME_PASTA);
        }
    }

    @Override
    public void listaParaArquivo(List lista) {
        Gson gson = new Gson();
        String json = gson.toJson(lista);

        if (this.verificarArquivoJson()) {
            gravarArquivo(json);
        } else {
            inicializarJson();
            gravarArquivo(json);
        }
    }

    private boolean verificarArquivoJson() {
        File json = new File(NOME_PASTA + File.separator + NOME_ARQUIVO);
        return json.exists();
    }

    private void gravarArquivo(String json) {
        try (FileWriter filewriter = new FileWriter(NOME_PASTA + File.separator + NOME_ARQUIVO)) {
            filewriter.write(json);
            filewriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void inicializarJson() {
        if (!this.verificarArquivoJson()) {
            List<T> listaVazia = new ArrayList<>();

            File json = new File(NOME_PASTA + File.separator + NOME_ARQUIVO);

            try {
                json.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            this.listaParaArquivo(listaVazia);
        }
    }

    @Override
    public int contadorAtualizado(List lista) {
        int contador = 1;

        if (lista != null) {
            contador = lista.size() + 1;
        }

        return contador;
    }

}
