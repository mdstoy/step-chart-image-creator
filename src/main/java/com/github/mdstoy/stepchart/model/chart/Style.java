package com.github.mdstoy.stepchart.model.chart;

public enum Style {
    SINGLE, DOUBLE;

    public static Style of(int width) {
        switch (width) {
            case 4:
                return SINGLE;
            case 8:
                return DOUBLE;
            default:
                // FIXME
                throw new IllegalArgumentException("4 or 8");
        }
    }
}
