/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.walison.dados;

import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author Douglas
 */
public class Venda {
    
    private int codigo;
    private Date data = new Date();
    private ArrayList<ItensVenda>itensVenda = new ArrayList<>();
    private Funcionario funcionario;
    private Cliente cliente;

    
    public Venda(Funcionario funcionario,Cliente cliente) {
        this.funcionario = funcionario;
        this.cliente = cliente;
    }

//    public void adicionarItemVenda(Produto produto, int quantidade) {
//        ItensVenda itemProduto = new ItensVenda(quantidade, produto);        
//        this.itensVenda.add(itemProduto);
//        
//        // atualizar a comissao / registro do funcionario
//        double lucro = produto.getPrecoVenda() - produto.getPrecoCusto();
//        funcionario.atualizarLucroDeVendas(lucro);
//        funcionario.atualizarQuantideDeVendas(quantidade);
//        
//    }
    
    
    
    
    public ArrayList<ItensVenda> mostrarProdutosDaVenda() {
        
        System.out.println(toString());
        
        return itensVenda;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setItensVenda(ArrayList<ItensVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<ItensVenda> getItensVenda() {
        return itensVenda;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<ItensVenda> getProdutos() {
        return itensVenda;
    }

    public int getCodigo() {
        return codigo;
    }

    public Date getData() {
        return data;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Venda{");
        sb.append("codigo=").append(codigo);
        sb.append(", data=").append(data);
        sb.append(", itensVenda=").append(itensVenda);
        sb.append(", funcionario=").append(funcionario);
        sb.append(", cliente=").append(cliente);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Venda)) return false;

        Venda venda = (Venda) o;

        if (codigo != venda.codigo) return false;
        if (data != null ? !data.equals(venda.data) : venda.data != null) return false;
        if (itensVenda != null ? !itensVenda.equals(venda.itensVenda) : venda.itensVenda != null) return false;
        if (funcionario != null ? !funcionario.equals(venda.funcionario) : venda.funcionario != null) return false;
        return cliente != null ? cliente.equals(venda.cliente) : venda.cliente == null;

    }

    @Override
    public int hashCode() {
        int result = codigo;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (itensVenda != null ? itensVenda.hashCode() : 0);
        result = 31 * result + (funcionario != null ? funcionario.hashCode() : 0);
        result = 31 * result + (cliente != null ? cliente.hashCode() : 0);
        return result;
    }

    /**
     * Como saber qual funcionário efetuou a venda?
     */
//    @Override
//    public String toString() {
//        String dadosVenda = "#######################################";
//
//        if(itensVenda.isEmpty()) {
//
//            dadosVenda += "\n- NENHUM PRODUTO ADICIONADO AINDA -";
//            dadosVenda += "\n#######################################";
//
//            return dadosVenda;
//        }
//
//        dadosVenda += "\nCódigo: "+codigo;
//        dadosVenda += "\nData: "+data.toString();
//        dadosVenda += "\nFuncinário: "+funcionario.getNome();
//        float totalCusto=0, totalVenda=0, totalLucro = 0;
//
//
//
//        for (ItensVenda itemProduto : itensVenda) {
//
//            double totalLucroDestesItens = 0;
//            double totalVendaDestesItens = 0;
//            double totalCustoDestesItens = 0;
//
//            Produto produto = itemProduto.getProduto();
//            int quantidade = itemProduto.getQuantidade();
//
//           dadosVenda += "\n-----------------------";
//           dadosVenda += "\nitens vendidos: "+quantidade;
//           dadosVenda += "\n----------- Produtos vendidos -----------";
//
//            dadosVenda += "\n"+produto;
//            dadosVenda += "\n--";
//
//            totalVendaDestesItens += produto.getPrecoVenda();
//            totalCustoDestesItens += produto.getPrecoCusto();
//            totalLucroDestesItens += (produto.getPrecoVenda()-produto.getPrecoCusto());
//
//
//            totalVenda += totalVendaDestesItens * quantidade;
//            totalCusto += totalCustoDestesItens * quantidade;
//            totalLucro += totalLucroDestesItens * quantidade;
//
//            dadosVenda += "\nvenda total destes itens: "+totalVendaDestesItens * quantidade;
//            dadosVenda += "\ncusto total destes itens: "+totalCustoDestesItens * quantidade;
//            dadosVenda += "\nlucro total destes itens: "+totalLucroDestesItens * quantidade;
//
//            dadosVenda += "\n-----------------------";
//        }
//
//        dadosVenda += "\nTOTAL Venda: "+totalVenda;
//        dadosVenda += "\nTOTAL Custo: "+totalCusto;
//        dadosVenda += "\nTOTAL Lucro: "+totalLucro;
//        dadosVenda += "\n#######################################";
//
//        return dadosVenda;
//    }
    

}
