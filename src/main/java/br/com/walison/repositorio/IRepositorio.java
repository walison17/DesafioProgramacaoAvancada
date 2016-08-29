/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.walison.repositorio;

import java.util.List;

/**
 *
 * @author walison
 */
public interface IRepositorio<T> {
    
    void salvar(T obj);
    
    List<T> listarTodos();
    
    void deletar(T obj);
    
    T buscarPorId(int codigo);
    
    int quantidade();
    
}
