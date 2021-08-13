package com.fincons.kata_gioco_oca;

import com.fincons.kata_gioco_oca.services.GiocatoreHelper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GiocatoreHelperTest {

    @Test
    void lancioDueDadi() {
        GiocatoreHelper giocatoreHelper = new GiocatoreHelper();
        int lancioResult = giocatoreHelper.lancioDueDadi();
        assertThat(lancioResult).isGreaterThanOrEqualTo(2).isLessThanOrEqualTo(12);
    }
}