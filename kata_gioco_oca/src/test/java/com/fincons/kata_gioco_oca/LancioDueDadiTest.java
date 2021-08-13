package com.fincons.kata_gioco_oca;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LancioDueDadiTest
{

	@Test
	void lancioDueDadi()
	{
		LancioDueDadi lancioDueDadi = new LancioDueDadi();
		int lancioResult = lancioDueDadi.execute();
		assertThat(lancioResult).isGreaterThanOrEqualTo(2).isLessThanOrEqualTo(12);
	}
}