package com.fincons.kata_gioco_oca;

import com.fincons.kata_gioco_oca.models.Giocatore;
import com.fincons.kata_gioco_oca.services.GiocatoreHelper;
import org.springframework.stereotype.Service;

@Service
public
class SimulazioneGioco {

    public static final int CASELLA_FINALE = 63;
    public static final int CASELLA_INIZIALE = 0;
    private final GiocatoreHelper giocatoreHelper;

    public SimulazioneGioco(GiocatoreHelper giocatoreHelper) {
        this.giocatoreHelper = giocatoreHelper;
    }

    public void start(Giocatore primoGiocatore) {
        System.out.println("inizio gioco");
        int posizione = CASELLA_INIZIALE;
        while (!controllaGiocoFinito(posizione)) {
            int valoreSommaDadi = giocatoreHelper.lancioDueDadi();
            posizione = calcolaNuovaPosizione(posizione, valoreSommaDadi);
            System.out
                    .println("il giocatore " + primoGiocatore.getNomeGiocatore() + " lancia i dadi e ottiene: " + valoreSommaDadi + " e ora raggiunge la casella: " + posizione);

        }
        System.out.println("il gioco è finito");
    }

    private boolean controllaGiocoFinito(int posizioneDopoLancio) {
        return posizioneDopoLancio == CASELLA_FINALE;
    }

    public int calcolaNuovaPosizione(int posizioneAttuale, int lancioDadi) {

        int posizioneDopoLancio = posizioneAttuale + lancioDadi;

        posizioneDopoLancio = controllaSeTornareIndietro(posizioneDopoLancio);

        return posizioneDopoLancio;
    }

    private int controllaSeTornareIndietro(int posizioneDopoLancio) {
        if (posizioneDopoLancio > CASELLA_FINALE) {
            int posizioneSurplus = posizioneDopoLancio - CASELLA_FINALE;
            posizioneDopoLancio = CASELLA_FINALE - posizioneSurplus;
        }
        return posizioneDopoLancio;
    }
}
