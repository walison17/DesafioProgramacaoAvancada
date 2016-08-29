package br.com.walison.comunicador;

import br.com.walison.comunicador.emissor.IEmissor;
import br.com.walison.comunicador.receptor.IReceptor;

/**
 * Created by walison on 29/08/16.
 */
public interface IComunicadorFactory {

    public IEmissor createEmissor();

    public IReceptor createReceptor();

}
