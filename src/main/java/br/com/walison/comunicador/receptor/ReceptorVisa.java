package br.com.walison.comunicador.receptor;

/**
 * Created by walison on 29/08/16.
 */
public class ReceptorVisa implements IReceptor {

    @Override
    public String receber() {
        return "Transação aprovada .. - Visa";
    }
}
