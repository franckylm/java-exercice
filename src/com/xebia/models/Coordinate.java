package com.xebia.models;

public class Coordinate {

    /**
     * Value of x axe in  Cartesian coordinate system.
     * eg: x = 1
     */
    private int x;

    /**
     * Value of y axe in  Cartesian coordinate system.
     * eg: y = 1
     */
    private int y;

    /**
     * Orientation property in cardinal notation.
     * o = {N,E,W,S}
     */
    private char d;

    /**
     * Instantiate the Coordinate object with x, y and orientation
     * @param x
     * @param y
     * @param d (Direction in cardinal notation)
     */
    public Coordinate(int x, int y, char d) {
        this(x, y);
        this.d = d;
    }

    /**
     * Instantiate the Coordinate object with only x, y coordinates;
     * @param x
     * @param y
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void incrementX() {
        ++this.x;
    }

    public void decrementX() {
        --this.x;
    }

    public int getY() {
        return y;
    }

    public void incrementY() {
        ++this.y;
    }

    public void decrementY() {
        --this.y;
    }

    public char getD() {
        return d;
    }

    public void setD(char d) {
        this.d = d;
    }
}
