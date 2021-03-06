package com.fincons.kata_gioco_oca;

import com.fincons.kata_gioco_oca.models.Giocatore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Collections;

@SpringBootApplication
public class KataGiocoOcaApplication {


    public static void main(String[] args) {


        ConfigurableApplicationContext applicationContext = new SpringApplication(KataGiocoOcaApplication.class).run(args);

        SimulazioneGioco simulazioneGioco = applicationContext.getBean(SimulazioneGioco.class);
        simulazioneGioco.start(Collections.singletonList(new Giocatore("Giovanna", 0)));
    }

}
