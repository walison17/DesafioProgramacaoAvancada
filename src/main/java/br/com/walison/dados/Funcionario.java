package br.com.walison.dados;


import br.com.walison.util.Md5;

import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Escreva a descrição da classe Funcionario aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Funcionario extends Pessoa {
    private int codigo;
    private double salario;
    private String login;
    private String senha;

    // TODO permitir os dados abaixo serem guardados no arquivo
    private double acumuladoLucroVendas;
    private int quantidadeVendas;
    
    
    public Funcionario(double salario, String login, String senha, String nome) {
        super(nome);
        this.salario = salario;
        this.login = login;
        try {
            this.senha = Md5.convertPasswordToMD5(senha);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    
    
    public void atualizarLucroDeVendas(double lucro) {
        acumuladoLucroVendas += lucro;
    }
    
    public void atualizarQuantideDeVendas(int quantidadeAtualDaVenda) {
        quantidadeVendas += quantidadeAtualDaVenda;
    }

    @Override
    public String toString() {
        return "nome="+nome+",salario="+salario+",login="+login+",senha="+senha;
    }

    public void imprimirFuncionario() {
        System.out.println(toString());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Funcionario)) return false;

        Funcionario that = (Funcionario) o;

        if (codigo != that.codigo) return false;
        if (Double.compare(that.salario, salario) != 0) return false;
        if (Double.compare(that.acumuladoLucroVendas, acumuladoLucroVendas) != 0) return false;
        if (quantidadeVendas != that.quantidadeVendas) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        return senha != null ? senha.equals(that.senha) : that.senha == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = codigo;
        temp = Double.doubleToLongBits(salario);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (senha != null ? senha.hashCode() : 0);
        temp = Double.doubleToLongBits(acumuladoLucroVendas);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + quantidadeVendas;
        return result;
    }
}
