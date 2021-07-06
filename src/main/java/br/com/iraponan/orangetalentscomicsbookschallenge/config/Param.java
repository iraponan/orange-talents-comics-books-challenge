package br.com.iraponan.orangetalentscomicsbookschallenge.config;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Param {

    public static final String privateKey = "f1122ed630f58356b2adae00c243d890247ddc9c";
    public static final String publicKey = "64f731cbafb2e19f4cf9bd4fca2e63bc";
    public static final Long ts = System.currentTimeMillis();

    public static String hashMd5() {
        String hash = ts + privateKey + publicKey;
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
