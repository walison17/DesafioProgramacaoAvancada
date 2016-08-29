package br.com.walison.comunicador.receptor;

/**
 * Created by walison on 29/08/16.
 */
public class ReceptorMasterCard implements IReceptor {

    @Override
    public String receber() {
        return "Transação aprovada.. - MasterCard";
    }
}
