package com.fincons.kata_gioco_oca.services;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GiocatoreHelper {
    public static final int VALORE_MASSIMO_SOMMA = 12;
    public static final int VALORE_MINIMO_SOMMA = 2;

    public int lancioDueDadi() {
        Random random = new Random();
        return random.nextInt(VALORE_MASSIMO_SOMMA - VALORE_MINIMO_SOMMA) + VALORE_MINIMO_SOMMA;
    }
}
