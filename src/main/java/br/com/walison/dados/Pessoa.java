package br.com.walison.dados;

import java.io.Serializable;

/**
 * Escreva a descrição da classe Pessoa aqui.
 *
 * @author (seu nome)
 * @version (número de versão ou data)
 */
public abstract class Pessoa implements Serializable {

    protected String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

}
