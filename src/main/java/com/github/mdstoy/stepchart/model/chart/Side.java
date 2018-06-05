package com.github.mdstoy.stepchart.model.chart;

public enum Side {
    ONE(0),
    TWO(1);

    private int value;

    Side(int value) {
        this.value = value;
    }

    public static Side of(int column) {
        return (column / 4 == 0) ? ONE : TWO;
    }

    public int getValue() {
        return value;
    }
}
