package com.github.mdstoy.stepchart.model.chart;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoteTest {

    @Test
    void of() {
        assertEquals(Note.QUARTER, Note.of(0, 4));
        assertEquals(Note.QUARTER, Note.of(1, 4));
        assertEquals(Note.QUARTER, Note.of(2, 4));
        assertEquals(Note.QUARTER, Note.of(3, 4));
        assertEquals(Note.QUARTER, Note.of(0, 8));
        assertEquals(Note.EIGHTH, Note.of(1, 8));
        assertEquals(Note.QUARTER, Note.of(2, 8));
        assertEquals(Note.EIGHTH, Note.of(3, 8));
        assertEquals(Note.QUARTER, Note.of(4, 8));
        assertEquals(Note.EIGHTH, Note.of(5, 8));
        assertEquals(Note.QUARTER, Note.of(6, 8));
        assertEquals(Note.EIGHTH, Note.of(7, 8));
        assertEquals(Note.QUARTER, Note.of(0, 16));
        assertEquals(Note.SIXTEENTH, Note.of(1, 16));
        assertEquals(Note.EIGHTH, Note.of(2, 16));
        assertEquals(Note.SIXTEENTH, Note.of(3, 16));
        assertEquals(Note.QUARTER, Note.of(4, 16));
        assertEquals(Note.SIXTEENTH, Note.of(5, 16));
        assertEquals(Note.EIGHTH, Note.of(6, 16));
        assertEquals(Note.SIXTEENTH, Note.of(7, 16));
        assertEquals(Note.QUARTER, Note.of(8, 16));
        assertEquals(Note.SIXTEENTH, Note.of(9, 16));
        assertEquals(Note.EIGHTH, Note.of(10, 16));
        assertEquals(Note.SIXTEENTH, Note.of(11, 16));
        assertEquals(Note.QUARTER, Note.of(12, 16));
        assertEquals(Note.SIXTEENTH, Note.of(13, 16));
        assertEquals(Note.EIGHTH, Note.of(14, 16));
        assertEquals(Note.SIXTEENTH, Note.of(15, 16));
    }
}