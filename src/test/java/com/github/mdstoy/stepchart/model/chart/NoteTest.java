package com.github.mdstoy.stepchart.model.chart;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NoteTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void of4(int index) {
        assertEquals(Note.QUARTER, Note.of(index, 4));
    }

    @ParameterizedTest
    @ValueSource(ints = {0})
    void of5Quarter(int index) {
        assertEquals(Note.QUARTER, Note.of(index, 5));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void of5Others(int index) {
        assertEquals(Note.OTHERS, Note.of(index, 5));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    void of6Quarter(int index) {
        assertEquals(Note.QUARTER, Note.of(index, 6));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 5})
    void of6Triplet(int index) {
        assertEquals(Note.TRIPLET, Note.of(index, 6));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 4, 6})
    void of8Quarter(int index) {
        assertEquals(Note.QUARTER, Note.of(index, 8));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7})
    void of8Eighth(int index) {
        assertEquals(Note.EIGHTH, Note.of(index, 8));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3, 6, 9})
    void of12Quarter(int index) {
        assertEquals(Note.QUARTER, Note.of(index, 12));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 5, 7, 8, 10, 11})
    void of12Triplet(int index) {
        assertEquals(Note.TRIPLET, Note.of(index, 12));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 4, 8, 12})
    void of16Quarter(int index) {
        assertEquals(Note.QUARTER, Note.of(index, 16));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 6, 10, 14})
    void of16Eighth(int index) {
        assertEquals(Note.EIGHTH, Note.of(index, 16));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9, 11, 13, 15})
    void of16Sixteenth(int index) {
        assertEquals(Note.SIXTEENTH, Note.of(index, 16));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 6, 12, 18})
    void of24Quarter(int index) {
        assertEquals(Note.QUARTER, Note.of(index, 24));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 9, 15, 21})
    void of24Eighth(int index) {
        assertEquals(Note.EIGHTH, Note.of(index, 24));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 5, 7, 8, 10, 11, 13, 14, 16, 17, 19, 20, 22, 23})
    void of24Triplet(int index) {
        assertEquals(Note.TRIPLET, Note.of(index, 24));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 8, 16, 24})
    void of32Quarter(int index) {
        assertEquals(Note.QUARTER, Note.of(index, 32));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 12, 20, 28})
    void of32Eighth(int index) {
        assertEquals(Note.EIGHTH, Note.of(index, 32));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 6, 10, 14, 18, 22, 26, 30})
    void of32Triplet(int index) {
        assertEquals(Note.SIXTEENTH, Note.of(index, 32));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31})
    void of32Others(int index) {
        assertEquals(Note.OTHERS, Note.of(index, 32));
    }
}
