package com.fincons.kata_gioco_oca;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SimulazioneGiocoTest
{
	@InjectMocks
	SimulazioneGioco simulazioneGioco;

	@Mock
	LancioDueDadi lancioDueDadi;

	@Test
	void aggiornaPosizionePrimoTurno()
	{
		int posizioneAttuale = 0;
		when(lancioDueDadi.execute()).thenReturn(2);

		int nuovaPosizione = simulazioneGioco.aggiornaPosizione(posizioneAttuale);

		assertThat(nuovaPosizione).isGreaterThan(posizioneAttuale);
	}

	@Test
	void aggiornaPosizioneSeSuperoCasellaFinale()
	{
		int posizioneAttuale = 62;
		when(lancioDueDadi.execute()).thenReturn(5);

		int nuovaPosizione = simulazioneGioco.aggiornaPosizione(posizioneAttuale);

		assertThat(nuovaPosizione).isEqualTo(59);
	}
}