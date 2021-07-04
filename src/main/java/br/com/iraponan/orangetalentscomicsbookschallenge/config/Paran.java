package br.com.iraponan.orangetalentscomicsbookschallenge.config;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Paran {

    public static final String url = "http://gateway.marvel.com/v1/public";
    public static String dado = "/comics";
    public static final String privateKey = "f1122ed630f58356b2adae00c243d890247ddc9c";
    public static final String publicKey = "64f731cbafb2e19f4cf9bd4fca2e63bc";
    public static final Long ts = System.currentTimeMillis();
    public static final String hash = ts + privateKey + publicKey;
    public static final String urlKey = "?ts=" + ts + "&apikey=" + publicKey + "&hash=" + md5();
    public static final String urlCompleta = url + dado + "?ts=" + ts + "&apikey=" + publicKey + "&hash=" + md5();

    public static String md5() {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md5.update(hash.getBytes(), 0, hash.length());
        return new BigInteger(1, md5.digest()).toString(16);
    }
}
