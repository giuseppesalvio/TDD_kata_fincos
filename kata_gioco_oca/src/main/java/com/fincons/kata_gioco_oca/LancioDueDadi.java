package com.fincons.kata_gioco_oca;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public
class LancioDueDadi
{

	public static final int VALORE_MASSIMO_SOMMA = 12;
	public static final int VALORE_MINIMO_SOMMA = 2;

	public
	int execute()
	{
		Random random = new Random();
		return random.nextInt(VALORE_MASSIMO_SOMMA - VALORE_MINIMO_SOMMA) + VALORE_MINIMO_SOMMA;
	}
}
