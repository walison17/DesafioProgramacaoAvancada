package br.com.walison.comunicador.emissor;

/**
 * Created by walison on 29/08/16.
 */
public class EmissorVisa implements IEmissor {

    @Override
    public void enviar(String msg) {
        System.out.println("enviando mensangem - visa .. " + msg);
    }
}
