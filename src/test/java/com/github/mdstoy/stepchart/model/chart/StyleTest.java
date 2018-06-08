package com.github.mdstoy.stepchart.model.chart;

import static org.junit.jupiter.api.Assertions.*;

class StyleTest {

    @org.junit.jupiter.api.Test
    void of() {
        assertEquals(Style.SINGLE, Style.of(4));
        assertEquals(Style.DOUBLE, Style.of(8));
        assertThrows(IllegalArgumentException.class, () -> Style.of(0));
    }
}