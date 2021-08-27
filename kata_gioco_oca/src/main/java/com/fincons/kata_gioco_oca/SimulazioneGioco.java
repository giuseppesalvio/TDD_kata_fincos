package com.fincons.kata_gioco_oca;

import com.fincons.kata_gioco_oca.models.Giocatore;
import com.fincons.kata_gioco_oca.services.GiocatoreHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class SimulazioneGioco {

    public static final int CASELLA_FINALE = 63;
    private final GiocatoreHelper giocatoreHelper;

    public SimulazioneGioco(GiocatoreHelper giocatoreHelper) {
        this.giocatoreHelper = giocatoreHelper;
    }

    public void start(List<Giocatore> giocatori) {

        System.out.println("inizio gioco");
        while (!controllaGiocoFinito(giocatori.get(0).getPosizioneAttuale())) {
            int valoreSommaDadi = giocatoreHelper.lancioDueDadi();
            spostaGiocatore(giocatori.get(0), valoreSommaDadi);
            stampaGameStatus(giocatori, valoreSommaDadi);

        }
        System.out.println("il gioco è finito");
    }

    private void stampaGameStatus(List<Giocatore> giocatori, int valoreSommaDadi) {
        System.out
                .println("il giocatore " + giocatori.get(0).getNomeGiocatore() + " lancia i dadi e ottiene: "
                        + valoreSommaDadi + " e ora raggiunge la casella: " + giocatori.get(0).getPosizioneAttuale());
    }

    private void spostaGiocatore(Giocatore giocatore, int valoreSommaDadi) {
        int posizioneAttuale = calcolaNuovaPosizione(giocatore.getPosizioneAttuale(), valoreSommaDadi);
        giocatore.setPosizioneAttuale(posizioneAttuale);
    }


    public int calcolaNuovaPosizione(int posizioneAttuale, int lancioDadi) {

        int posizioneDopoLancio = posizioneAttuale + lancioDadi;

        posizioneDopoLancio = controllaSeTornareIndietro(posizioneDopoLancio);

        return posizioneDopoLancio;
    }

    private boolean controllaGiocoFinito(int posizioneDopoLancio) {
        return posizioneDopoLancio == CASELLA_FINALE;
    }

    private int controllaSeTornareIndietro(int posizioneDopoLancio) {
        if (posizioneDopoLancio > CASELLA_FINALE) {
            int posizioneSurplus = posizioneDopoLancio - CASELLA_FINALE;
            posizioneDopoLancio = CASELLA_FINALE - posizioneSurplus;
        }
        return posizioneDopoLancio;
    }
}
