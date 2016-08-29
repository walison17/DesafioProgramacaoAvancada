package br.com.walison.comunicador;

/**
 * Created by walison on 29/08/16.
 */
public enum BandeiraCartao {
    MASTERCARD {
        @Override
        public String toString() {
            return "master card";
        }
        
    }, VISA {
        @Override
        public String toString() {
            return "visa";
        }
        
    }
}
