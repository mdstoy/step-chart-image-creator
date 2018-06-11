package com.github.mdstoy.stepchart.model.chart;

public enum Note {

    QUARTER,
    EIGHTH,
    SIXTEENTH,
    TRIPLET,
    OTHERS;

    public static Note of(int index, int resolution) {
        if (resolution == 4) {
            return QUARTER;
        }

        if (resolution == 6) {
            return (index % 3) == 0 ? QUARTER : TRIPLET;
        }

        if (resolution == 8) {
            return (index % 2) == 0 ? QUARTER : EIGHTH;
        }

        if (resolution == 12) {
            return (index % 3) == 0 ? QUARTER : TRIPLET;
        }

        if (resolution == 16) {
            return (index % 4) == 0 ? QUARTER : (index % 2) == 0 ? EIGHTH : SIXTEENTH;
        }

        return OTHERS;
    }

}
