/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.walison.aula03;

import br.com.walison.dados.Cliente;
import br.com.walison.dados.Funcionario;
import br.com.walison.dados.Venda;
import br.com.walison.repositorio.IRepositorio;
import br.com.walison.repositorio.RepositorioFuncionario;
import br.com.walison.repositorio.RepositorioVenda;
import br.com.walison.telas.TelaLogin;
import br.com.walison.telas.cadastro.CadastroFuncionario;

import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author walison
 */
public class Main {

    public static void main(String[] args) {

        RepositorioFuncionario repositorioFuncionario = RepositorioFuncionario.getInstance();

        List<Funcionario> listaFuncionarios = repositorioFuncionario.listarTodos();

        if (!listaFuncionarios.isEmpty()) {

            new TelaLogin().setVisible(true);

        } else {

            int opcao = JOptionPane.showConfirmDialog(null, "nenhum funcionário cadastrado, deseja cadastrar agora?", "Aviso", JOptionPane.YES_NO_OPTION);

            if (opcao == JOptionPane.YES_OPTION) {

                //chamar tela de cadastro
                new CadastroFuncionario().setVisible(true);

            } else {

                //fecha a aplicação
                System.exit(1);

            }

        }

    }

}
