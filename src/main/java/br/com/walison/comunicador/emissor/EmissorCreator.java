package br.com.walison.comunicador.emissor;

import br.com.walison.comunicador.BandeiraCartao;

/**
 * Created by walison on 29/08/16.
 */
public class EmissorCreator {

    public IEmissor create(Enum<BandeiraCartao> bandeiraCartao) {

        if (bandeiraCartao == BandeiraCartao.MASTERCARD) {
            return new EmissorMasterCard();
        } else if (bandeiraCartao == BandeiraCartao.VISA) {
            return new EmissorVisa();
        }

        return null;
    }
}

