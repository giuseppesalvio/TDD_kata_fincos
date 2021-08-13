package com.fincons.kata_gioco_oca;

import org.springframework.stereotype.Service;

@Service
public
class SimulazioneGioco
{

	public static final int CASELLA_FINALE = 63;
	final LancioDueDadi lancioDueDadi;

	public
	SimulazioneGioco(LancioDueDadi lancioDueDadi)
	{
		this.lancioDueDadi = lancioDueDadi;
	}

	public
	void start()
	{
	}

	public
	int aggiornaPosizione(int posizioneAttuale)
	{
		int posizioneDopoLancio = posizioneAttuale + lancioDueDadi.execute();

		posizioneDopoLancio = controllaSeTornareIndietro(posizioneDopoLancio);

		return posizioneDopoLancio;
	}

	private
	int controllaSeTornareIndietro(int posizioneDopoLancio)
	{
		if (posizioneDopoLancio > CASELLA_FINALE)
		{
			int posizioneSurplus = posizioneDopoLancio - CASELLA_FINALE;
			posizioneDopoLancio = CASELLA_FINALE - posizioneSurplus;
		}
		return posizioneDopoLancio;
	}
}
