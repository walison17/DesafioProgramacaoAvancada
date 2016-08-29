/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.walison.telas;

import br.com.walison.dados.ItensVenda;
import br.com.walison.dados.Produto;
import br.com.walison.dados.Venda;
import br.com.walison.repositorio.RepositorioVenda;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author walison
 */
public class TabelaVendas extends AbstractTableModel {

    private final int COD_FUNCIONARIO = 0;
    private final int COD_VENDA = 1;
    private final int COD_CLIENTE = 2;
    private final int DATA_VENDA = 3;
    private final int ITENS_VENDIDOS = 4;
    
    private List<Venda> listaVendas;
    private final String[] colunas = {"cod. funcionario", "cod. venda", "cod. cliente", "data venda", "itens vendidos"};

    public TabelaVendas() {
        
        this.listaVendas = RepositorioVenda.getInstance().listarTodos();
        
    }
    
    
    @Override
    public int getRowCount() {
        return this.listaVendas.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       
        Venda venda = this.listaVendas.get(rowIndex);
        
        switch(columnIndex) {
            
            case (COD_CLIENTE):
                return venda.getCliente().getCodigo();
                
            case (COD_FUNCIONARIO):
                return venda.getFuncionario().getCodigo();
                
            case (COD_VENDA):
                return venda.getCodigo();
            
            case (DATA_VENDA):
                return venda.getData();
                
            case (ITENS_VENDIDOS):
                String listaItens = "";
                
                for (ItensVenda itens : venda.getProdutos()) {
                    listaItens += itens.getProduto().getNome() + ", ";
                }
                
                return listaItens;
                
            default:
                return null;
        }
        
    }
    
    
    @Override
    public String getColumnName(int columnIndex) {
        
        return this.colunas[columnIndex];
        
    }
    
}
