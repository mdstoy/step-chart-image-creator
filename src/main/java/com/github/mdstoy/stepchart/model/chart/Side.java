package com.github.mdstoy.stepchart.model.chart;

public enum Side {
    ONE, TWO;

    public static Side of(int column) {
        return (column / 4 == 0) ? ONE : TWO;
    }
}
