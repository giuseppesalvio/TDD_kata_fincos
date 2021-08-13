package com.fincons.kata_gioco_oca;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class SimulazioneGiocoTest {


    @Test
    void lancioDueDadi() {

        SimulazioneGioco simulazioneGioco = new SimulazioneGioco();
        int lancioResult = simulazioneGioco.lancioDueDadi();
        assertThat(lancioResult).isGreaterThanOrEqualTo(2).isLessThanOrEqualTo(12);
    }

    @Test
    void aggiornaPosizionePrimoTurno() {
        SimulazioneGioco simulazioneGioco = new SimulazioneGioco();
        int posizioneAttuale = 0;
        int nuovaPosizione = simulazioneGioco.aggiornaPosizione(posizioneAttuale);

        assertThat(nuovaPosizione).isGreaterThan(posizioneAttuale);
    }


}