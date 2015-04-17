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
        if(d != 'N' && d != 'E' && d != 'W' && d != 'S') {
            throw new IllegalArgumentException(
                    "Direction parameter must be a valid orientation" +
                    "In the cardinal notation which are {N, W, S, E}");
        }
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

    /**
     * Although this method doesn't throw an exception, it simply
     * ignore falsy cardinal values.
     *
     * @param d (Direction in cardinal notation)
     */
    public void setD(char d) {
        if(d != 'N' && d != 'E' && d != 'W' && d != 'S') {
            return;
        }
        this.d = d;
    }
}
