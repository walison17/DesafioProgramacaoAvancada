/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.walison.telas;

import br.com.walison.dados.ItensVenda;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author walison
 */
public class TabelaCarrinho extends AbstractTableModel {

    //Constantes 
    private final int CODIGO = 0; 
    private final int NOME_PRODUTO = 1; 
    private final int PRECO_UNIT = 2; 
    private final int QUANTIDADE = 3; 
    
    private final String[] colunas = {"cód", "nome", "preço", "quantidade"};  
    private ArrayList<ItensVenda> itensCarrinho = new ArrayList<>();
    
    public void adicionarItem(ItensVenda item) {
        this.itensCarrinho.add(item);
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return this.colunas[columnIndex];
    }
    
    @Override
    public int getRowCount() {
        return this.itensCarrinho.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         
        ItensVenda item = this.itensCarrinho.get(rowIndex);
        
        switch (columnIndex) {
            
            case (CODIGO):
                return item.getProduto().getCodigo();
            
            case (NOME_PRODUTO):
                return item.getProduto().getNome();
            
            case (PRECO_UNIT):
                return item.getProduto().getPrecoVenda();
               
            case (QUANTIDADE):
                return item.getQuantidade();
               
            default:
                return null;
        }
    }
    
}
