package br.com.walison.comunicador.receptor;

import br.com.walison.comunicador.BandeiraCartao;

/**
 * Created by walison on 29/08/16.
 */
public class ReceptorCreator {

    public IReceptor create(Enum<BandeiraCartao> bandeiraCartao) {

        if (bandeiraCartao == BandeiraCartao.VISA) {
            return new ReceptorVisa();
        } else if (bandeiraCartao == BandeiraCartao.MASTERCARD) {
            return new ReceptorMasterCard();
        }

        return null;
    }

}
