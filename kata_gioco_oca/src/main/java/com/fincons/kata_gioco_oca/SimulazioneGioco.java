package com.fincons.kata_gioco_oca;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SimulazioneGioco {

    public void start() {
    }

    public int lancioDueDadi() {

        Random random = new Random();
        return random.nextInt(12 - 2) + 2;

    }

    public int aggiornaPosizione(int posizioneAttuale) {

        return  posizioneAttuale  + lancioDueDadi();
    }
}
