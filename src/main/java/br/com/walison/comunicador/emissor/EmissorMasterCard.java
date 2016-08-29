package br.com.walison.comunicador.emissor;

/**
 * Created by walison on 29/08/16.
 */
public class EmissorMasterCard implements IEmissor {

    @Override
    public void enviar(String msg) {
        System.out.println("enviando mensagem .. - master card " + msg);
    }
}
