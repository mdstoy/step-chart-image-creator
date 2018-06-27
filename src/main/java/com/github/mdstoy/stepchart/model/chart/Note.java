package com.github.mdstoy.stepchart.model.chart;

public enum Note {

    QUARTER,
    EIGHTH,
    SIXTEENTH,
    TRIPLET,
    OTHERS;

    public static Note of(int index, int resolution) {

        if (resolution % 2 == 0) {
            if ((index % (resolution / 2)) == 0) {
                return QUARTER;
            }
        }

        if (resolution % 4 == 0) {
            if ((index % (resolution / 4)) == 0) {
                return QUARTER;
            }
        }

        if (resolution % 8 == 0) {
            if ((index % (resolution / 8)) == 0) {
                return EIGHTH;
            }
        }

        if (resolution % 16 == 0) {
            if ((index % (resolution / 16)) == 0) {
                return SIXTEENTH;
            }
        }

        if (resolution % 3 == 0) {
            return TRIPLET;
        }

        return index == 0 ? QUARTER : OTHERS;
    }

}
