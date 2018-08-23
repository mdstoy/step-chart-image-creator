package com.github.mdstoy.stepchart.model.chart;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StyleTest {

    @Test
    void of() {
        assertEquals(Style.SINGLE, Style.of(4));
        assertEquals(Style.DOUBLE, Style.of(8));
        assertThrows(IllegalArgumentException.class, () -> Style.of(0));
    }
}