package com.github.mdstoy.stepchart.model.chart;

public enum Note {

    QUARTER,
    EIGHTH,
    SIXTEENTH,
    TRIPLET,
    OTHERS;

    public static Note of(int index, int resolution) {
        // FIXME : other than quarter and eighth
        return (index % (resolution / 4)) == 0 ? Note.QUARTER : Note.EIGHTH;
    }

}
