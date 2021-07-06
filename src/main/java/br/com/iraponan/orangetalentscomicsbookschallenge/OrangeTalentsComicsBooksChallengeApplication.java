package br.com.iraponan.orangetalentscomicsbookschallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrangeTalentsComicsBooksChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrangeTalentsComicsBooksChallengeApplication.class, args);
    }
}
