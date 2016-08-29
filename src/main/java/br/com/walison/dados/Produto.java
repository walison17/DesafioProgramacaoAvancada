/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.walison.dados;

/**
 *
 * @author Douglas
 */
public class Produto {
    
    // ATRIBUTOS
    private int codigo;
    private String nome;
    private String desc;
    private double precoVenda;
    private double precoCusto;

    
    // Construtor default
    public Produto() {
        System.out.println("Construtor default de Produto");

    }
    
    public Produto(String nome,
                   String desc,
                   double precoVenda, 
                   double precoCusto) {

        System.out.println("Construtor com argumentos");

        this.nome = nome;
        this.desc = desc;
        this.precoVenda = precoVenda;
        this.precoCusto = precoCusto;
    }
    

    // METODOS

    public void imprimirDados() {
        
        System.out.println( toString() );
    }
    
    
    // sobrecarga do método toString da classe Object
    @Override
    public String toString() {
        
        String relatorio = "";
        relatorio += "Código: "+codigo;
        relatorio += "\nNome: "+nome;
        relatorio += "\nDescrição: "+desc;
        relatorio += "\nPreço custo: "+precoCusto;        
        relatorio += "\nPreço venda: "+precoVenda;
        relatorio += "\nLucro: "+(precoVenda-precoCusto);
        
        return relatorio;
    }


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }
    
}
