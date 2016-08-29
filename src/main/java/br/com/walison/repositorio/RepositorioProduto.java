package br.com.walison.repositorio;

import br.com.walison.dados.Produto;
import br.com.walison.util.GerenciadorArquivos;
import br.com.walison.util.GerenciadorArquivosJson;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by walison on 29/08/16.
 */
public class RepositorioProduto implements IRepositorio<Produto> {

    GerenciadorArquivos gerenciador;
    private static RepositorioProduto INSTANCE;
    
    public static RepositorioProduto getInstace() {
        
        if (INSTANCE == null) {
            return new RepositorioProduto();
        } else {
            return INSTANCE;
        }
        
    }
    
    
    private RepositorioProduto() {
        this.gerenciador = new GerenciadorArquivosJson<Produto>("JSON", "produtos");
    }

    @Override
    public void salvar(Produto produto) {

        List<Produto> listaProdutos = this.listarTodos();

        int contadorAtualizado = gerenciador.contadorAtualizado(listaProdutos);
        produto.setCodigo(contadorAtualizado);

        if (listaProdutos == null) {
            listaProdutos = new ArrayList<>();
        }

        listaProdutos.add(produto);
        gerenciador.listaParaArquivo(listaProdutos);
    }

    @Override
    public List<Produto> listarTodos() {

        List<Produto> listaProdutos = null;

        try {
            listaProdutos = gerenciador.arquivoParaLista(Produto[].class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return listaProdutos;
    }

    @Override
    public void deletar(Produto produto) {

        List<Produto> listaProdutos = this.listarTodos();

        if (listaProdutos != null) {

            for (Produto p:
                 listaProdutos) {
                if (p.equals(produto)) {
                    listaProdutos.remove(produto);
                } else {
                    System.out.println("o produto não foi encontrado");
                }
            }
        }

        gerenciador.listaParaArquivo(listaProdutos);
    }

    @Override
    public Produto buscarPorId(int codigo) {

        List<Produto> listaProdutos = this.listarTodos();

        if (listaProdutos != null) {

            for (Produto produto:
                 listaProdutos) {
                if(produto.getCodigo() == codigo) {
                    return produto;
                }
            }

        }

        return null;
    }

    @Override
    public int quantidade() {

        List<Produto> listaProdutos = this.listarTodos();

        if (listaProdutos != null) {
            return listaProdutos.size();
        }

        return 0;
    }

}
