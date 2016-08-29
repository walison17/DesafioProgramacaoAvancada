package br.com.walison.repositorio;

import br.com.walison.dados.Funcionario;
import br.com.walison.dados.Venda;
import br.com.walison.util.GerenciadorArquivos;
import br.com.walison.util.GerenciadorArquivosJson;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by walison on 29/08/16.
 */
public class RepositorioVenda implements IRepositorio<Venda> {

    GerenciadorArquivos gerenciador;
    private static RepositorioVenda INSTANCE;

    private RepositorioVenda() {
        this.gerenciador = new GerenciadorArquivosJson<Venda>("JSON", "vendas");
    }
    
    
    public static RepositorioVenda getInstance() {
        
        if (INSTANCE == null) {
            return new RepositorioVenda();
        } else {
            return INSTANCE;
        }
        
    }

    @Override
    public void salvar(Venda venda) {

        List<Venda> listaVendas = this.listarTodos();
        venda.setCodigo(gerenciador.contadorAtualizado(listaVendas));

        if (listaVendas == null) {
            listaVendas = new ArrayList<>();
        }

        listaVendas.add(venda);
        gerenciador.listaParaArquivo(listaVendas);
    }

    @Override
    public List<Venda> listarTodos() {

        List<Venda> listaVendas = null;

        try {
            listaVendas = gerenciador.arquivoParaLista(Venda[].class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return listaVendas;
    }

    @Override
    public void deletar(Venda venda) {

        List<Venda> listaVendas = this.listarTodos();

        if (listaVendas != null) {

            for (Venda v:
                 listaVendas) {
                if(v.equals(venda))
                    listaVendas.remove(venda);
            }
        }

        gerenciador.listaParaArquivo(listaVendas); //atualiza a lista do json
    }

    @Override
    public Venda buscarPorId(int codigo) {

        List<Venda> listaVendas = this.listarTodos();

        if (listaVendas != null) {

            for (Venda v:
                 listaVendas) {
                if (v.getCodigo() == codigo) return v;
                else System.out.println("Venda não encontrada");
            }
        }

        return null;
    }

    @Override
    public int quantidade() {

        List<Venda> listaVendas = this.listarTodos();

        if (listaVendas != null) {
            return listaVendas.size();
        } else {
            return 0;
        }
    }
}
