package br.com.walison.repositorio;

import br.com.walison.dados.Funcionario;
import br.com.walison.util.GerenciadorArquivos;
import br.com.walison.util.GerenciadorArquivosJson;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by walison on 29/08/16.
 */
public class RepositorioFuncionario implements IRepositorio<Funcionario> {

    private GerenciadorArquivos gerenciador;
    private static RepositorioFuncionario INSTANCE;

    private RepositorioFuncionario() {
        this.gerenciador = new GerenciadorArquivosJson<Funcionario>("JSON", "funcionarios");;
    }
    
    public static RepositorioFuncionario getInstance() {
        
        if (INSTANCE == null) {
            return new RepositorioFuncionario();
        } else {
            return INSTANCE;
        }
        
    }
    

    @Override
    public void salvar(Funcionario funcionario) {

        List<Funcionario> listaFuncionarios = this.listarTodos();

        funcionario.setCodigo(this.contadorAtualizado()); //insere o código do funcionario

        if (listaFuncionarios != null) {
            listaFuncionarios.add(funcionario);

        } else {
            listaFuncionarios = new ArrayList<>();
            listaFuncionarios.add(funcionario);
        }

        gerenciador.listaParaArquivo(listaFuncionarios);
    }

    @Override
    public List<Funcionario> listarTodos() {

        List<Funcionario> listaFuncionarios = null;

        try {
            listaFuncionarios = gerenciador.arquivoParaLista(Funcionario[].class);
        }  catch (FileNotFoundException e) {
            System.out.println("arquivo json não encontrado");
        }

        return listaFuncionarios;
    }

    @Override
    public void deletar(Funcionario funcionario) {

        List<Funcionario> listaFuncionarios = this.listarTodos();

        if (listaFuncionarios != null) {

            for (Funcionario f:
                 listaFuncionarios) {
                if (f.equals(funcionario)) {
                    listaFuncionarios.remove(f);
                }
            }
        }

        gerenciador.listaParaArquivo(listaFuncionarios); //atualiza a lista de arquivos no json
    }

    @Override
    public Funcionario buscarPorId(int codigo) {

        List<Funcionario> listaFuncionarios = this.listarTodos();

        if (listaFuncionarios != null) {
            for (Funcionario funcionario:
                 listaFuncionarios) {
                if (funcionario.getCodigo() == codigo) {
                    return funcionario;
                }
            }
        }

        return null;
    }

    @Override
    public int quantidade() {

        List<Funcionario> listaFuncionarios = this.listarTodos();
        return listaFuncionarios.size();

    }

    public int contadorAtualizado() {

        int contador = 1;
        List<Funcionario> listaFuncionarios = this.listarTodos();

        if (listaFuncionarios != null) {
            contador = listaFuncionarios.size() + 1;
        }

        return contador;
    }

    
    public void atualizar(Funcionario funcionario, double lucro) {
        
        List<Funcionario> listaFuncionarios = this.listarTodos();
        
        if (listaFuncionarios != null) {
            
            for (Funcionario func : listaFuncionarios) {
                if (func.equals(funcionario)) {
                    
                    func.atualizarLucroDeVendas(lucro);
                    func.atualizarQuantideDeVendas(1);
                    System.out.println("dados do funcionario atualizados");
                    
                } else {
                    
                    System.out.println("funcionario não encontrado");
                }
            }
            
        }
        
        gerenciador.listaParaArquivo(listaFuncionarios);
        
    }
    
}
