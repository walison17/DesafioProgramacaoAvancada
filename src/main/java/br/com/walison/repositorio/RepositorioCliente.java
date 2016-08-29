/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.walison.repositorio;

import br.com.walison.dados.Cliente;
import br.com.walison.util.GerenciadorArquivos;
import br.com.walison.util.GerenciadorArquivosJson;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author walison
 */
public class RepositorioCliente implements IRepositorio<Cliente>{

    GerenciadorArquivos gerenciador;
    private static RepositorioCliente INSTANCE;
    
    private RepositorioCliente() {
        gerenciador = new GerenciadorArquivosJson<Cliente>("JSON", "clientes");
    }
    
    public static RepositorioCliente getInstance() {
        
        if (INSTANCE == null) {
            return new RepositorioCliente();
        } else {
            return INSTANCE;
        }
         
    }
    
    @Override
    public void salvar(Cliente cliente) {

        cliente.setCodigo(this.contadorAtualizado());

        List<Cliente> listaClientes = this.listarTodos(); 
        
        if (listaClientes != null) {
            listaClientes.add(cliente);
            
            gerenciador.listaParaArquivo(listaClientes);
        
        } else {
            listaClientes = new ArrayList<>();
            listaClientes.add(cliente);
            
            gerenciador.listaParaArquivo(listaClientes);
        }
        
    }

    @Override
    public List<Cliente> listarTodos() {
        
        List<Cliente> listaClientes = null; 
        
        try { 
            listaClientes = gerenciador.arquivoParaLista(Cliente[].class);
        } catch (FileNotFoundException ex) {
            System.out.println("arquivo json não encontrado");
        } 
        
        return listaClientes;
        
    }

    @Override
    public void deletar(Cliente cliente) {
        
        List<Cliente> listaClientes = this.listarTodos();
        
        if (listaClientes != null) {

            for (Cliente c:
                 listaClientes) {
                if (c.equals(cliente)) {
                    listaClientes.remove(c);
                }
            }
        }

        gerenciador.listaParaArquivo(listaClientes);
        
    }

    @Override
    public Cliente buscarPorId(int codigo) {
        
        List<Cliente> listaClientes = this.listarTodos();
        
        if (listaClientes != null) {
            
            for (Cliente cliente : listaClientes) {
                if (cliente.getCodigo() == codigo) {
                    return cliente; 
                } 
            }
            
        }
        
        return null;
    }

    @Override
    public int quantidade() {
        
        List<Cliente> listaClientes = this.listarTodos();
        
        if (listaClientes != null) {
            
            return listaClientes.size();
        } else {
            
            return 0;
        }
        
    }

    public int contadorAtualizado() {

        int contador = 1;
        List<Cliente> listaClientes = this.listarTodos();

        if (listaClientes != null) {
            contador =  listaClientes.size() + 1;
        }

        return contador;
    }
    
}
