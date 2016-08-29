package br.com.walison.comunicador;

import br.com.walison.comunicador.emissor.EmissorCreator;
import br.com.walison.comunicador.emissor.IEmissor;
import br.com.walison.comunicador.receptor.IReceptor;
import br.com.walison.comunicador.receptor.ReceptorCreator;

/**
 * Created by walison on 29/08/16.
 */
public class VisaComunicadorFactory implements IComunicadorFactory {

    private EmissorCreator emissorCreator = new EmissorCreator();
    private ReceptorCreator receptorCreator = new ReceptorCreator();

    @Override
    public IEmissor createEmissor() {
        return emissorCreator.create(BandeiraCartao.VISA);
    }

    @Override
    public IReceptor createReceptor() {
        return receptorCreator.create(BandeiraCartao.VISA);
    }
}
