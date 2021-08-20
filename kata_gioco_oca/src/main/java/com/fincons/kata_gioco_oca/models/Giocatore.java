package com.fincons.kata_gioco_oca.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Giocatore {
    private String nomeGiocatore;
    private int posizioneAttuale=0;
}
