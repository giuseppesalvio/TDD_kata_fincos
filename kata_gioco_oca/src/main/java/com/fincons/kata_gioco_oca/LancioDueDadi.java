package com.fincons.kata_gioco_oca;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public
class LancioDueDadi
{
	public
	int execute()
	{
		Random random = new Random();
		return random.nextInt(12 - 2) + 2;
	}
}
