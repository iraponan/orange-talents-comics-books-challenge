package br.com.iraponan.orangetalentscomicsbookschallenge;

import br.com.iraponan.orangetalentscomicsbookschallenge.enuns.DiasDaSemanaComDesconto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

@SpringBootApplication
@EnableFeignClients
public class OrangeTalentsComicsBooksChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrangeTalentsComicsBooksChallengeApplication.class, args);
        String url = "http://gateway.marvel.com/v1/public/";
        String dado = "comics/";
        int id = 323;
        Long ts = System.currentTimeMillis();
        String privateKey = "f1122ed630f58356b2adae00c243d890247ddc9c";
        String publicKey = "64f731cbafb2e19f4cf9bd4fca2e63bc";
        MessageDigest m= null;
        String hash = ts + privateKey + publicKey;
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        m.update(hash.getBytes(),0,hash.length());
        System.out.println("ts = " + ts);
        System.out.println("privateKey = " + privateKey);
        System.out.println("publicKey = " + publicKey);
        System.out.println(url + dado + id + "?ts=" + ts + "&apikey=" + publicKey + "&hash=" +
                new BigInteger(1,m.digest()).toString(16));

        //Verifica se tem desconto hoje
        System.out.println(DiasDaSemanaComDesconto.valueOf(weekDay(new GregorianCalendar()).toUpperCase()).isDiaDeDesconto());
    }

    public static String weekDay(Calendar cal) {
        return new DateFormatSymbols().getWeekdays()[cal.get(Calendar.DAY_OF_WEEK)];
    }
}
