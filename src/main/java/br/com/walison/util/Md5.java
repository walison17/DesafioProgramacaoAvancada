package br.com.walison.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by walison on 29/08/16.
 */
public class Md5 {

    public static String convertPasswordToMD5(String password)
            throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");

        BigInteger hash = new BigInteger(1, md.digest(password.getBytes()));

        return String.format("%32x", hash);
    }

}
