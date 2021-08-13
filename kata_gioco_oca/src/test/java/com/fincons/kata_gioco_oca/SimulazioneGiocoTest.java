package com.fincons.kata_gioco_oca;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
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


	@Test
	void inizioConUnSoloGiocatore() {
		ByteArrayOutputStream outSpy = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outSpy));

		when(lancioDueDadi.execute()).thenReturn(5,8,10,7,12,10,10,3,2);
		simulazioneGioco.start();
		StringBuilder expected= new StringBuilder("inizio gioco\r\n");
		expected.append("il giocatore 1 lancia i dadi e ottiene: " + 5 + " e ora raggiunge la casella: " + 5 + "\r\n");
		expected.append("il giocatore 1 lancia i dadi e ottiene: " + 8 + " e ora raggiunge la casella: " + 13 + "\r\n");
		expected.append("il giocatore 1 lancia i dadi e ottiene: " + 10 + " e ora raggiunge la casella: " + 23 + "\r\n");
		expected.append("il giocatore 1 lancia i dadi e ottiene: " + 7 + " e ora raggiunge la casella: " + 30 + "\r\n");
		expected.append("il giocatore 1 lancia i dadi e ottiene: " + 12 + " e ora raggiunge la casella: " + 42 + "\r\n");
		expected.append("il giocatore 1 lancia i dadi e ottiene: " + 10 + " e ora raggiunge la casella: " + 52 + "\r\n");
		expected.append("il giocatore 1 lancia i dadi e ottiene: " + 10 + " e ora raggiunge la casella: " + 62 + "\r\n");
		expected.append("il giocatore 1 lancia i dadi e ottiene: " + 3 + " e ora raggiunge la casella: " + 61 + "\r\n");
		expected.append("il giocatore 1 lancia i dadi e ottiene: " + 2 + " e ora raggiunge la casella: " + 63 + "\r\n");
		expected.append("il gioco è finito\r\n");

		assertThat(outSpy.toString()).isEqualTo(expected.toString());

	}


}