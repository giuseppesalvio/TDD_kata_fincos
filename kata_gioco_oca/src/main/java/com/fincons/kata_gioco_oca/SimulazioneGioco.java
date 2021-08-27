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
	private boolean giocoFinito;

	public SimulazioneGioco(GiocatoreHelper giocatoreHelper) {
        this.giocatoreHelper = giocatoreHelper;
    }

    public void start(List<Giocatore> giocatori) {

	    stampaInizioGioco();
	    while (!giocoFinito) {
	        for (Giocatore giocatore : giocatori)
	        {
		        turnoGiocatore(giocatore);
		        if (isPosizioneFinaleRaggiunta(giocatore))
		        {
			        break;
		        }
	        }


        }

    }

	private
	void turnoGiocatore(Giocatore giocatore)
	{
		int valoreSommaDadi = giocatoreHelper.lancioDueDadi();
		spostaGiocatore(giocatore, valoreSommaDadi);
		stampaGameStatus(valoreSommaDadi, giocatore);
	}

	private
	boolean isPosizioneFinaleRaggiunta(Giocatore giocatore)
	{
		if(giocatore.getPosizioneAttuale() == CASELLA_FINALE)
		{
			stampaVincitore(giocatore.getNomeGiocatore());
			giocoFinito = true;
		}
		return giocoFinito;
	}

	private
	void stampaInizioGioco()
	{
		System.out.println("inizio gioco");
	}

	private
	void stampaVincitore(String nomeGiocatore)
	{
		System.out.println("il gioco è finito, ha vinto " +nomeGiocatore);
	}

	private void stampaGameStatus(int valoreSommaDadi, Giocatore giocatore) {
        System.out
                .println("il giocatore " + giocatore.getNomeGiocatore() + " lancia i dadi e ottiene: "
                         + valoreSommaDadi + " e ora raggiunge la casella: " + giocatore.getPosizioneAttuale());
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

	private int controllaSeTornareIndietro(int posizioneDopoLancio) {
        if (posizioneDopoLancio > CASELLA_FINALE) {
            int posizioneSurplus = posizioneDopoLancio - CASELLA_FINALE;
            posizioneDopoLancio = CASELLA_FINALE - posizioneSurplus;
        }
        return posizioneDopoLancio;
    }
}
