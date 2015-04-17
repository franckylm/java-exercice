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
    private Direction d;

    /**
     * Instantiate the Coordinate object with x, y, and cardinal direction as an Enum.
     * @param x
     * @param y
     * @param d (Direction in cardinal notation)
     */
    public Coordinate(int x, int y, Direction d) {
        this(x, y);
        this.d = d;
    }

    /**
     * Instantiate the Coordinate object with x, y, and cardinal direction as a char.
     * @param x
     * @param y
     * @param d (Direction in cardinal notation)
     */
    public Coordinate(int x, int y, char d) {
        this(x, y);
        this.d = Direction.toEnum(d);
        if(this.d == null) {
            throw new IllegalArgumentException(
                    "Direction parameter must be a valid orientation" +
                            "In the cardinal notation which are {N, W, S, E}");
        }
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

    /**
     * Returns the Enum object.
     * @return Direction
     */
    public Direction getD() {
        return this.d;
    }

    /**
     * This method doesn't throw any exception, it simply
     * Falsy cardinal values are simply ignored.
     *
     * @param d (Direction in cardinal notation)
     */
    public void setD(Direction d) {
        this.d = d;
    }

    /**
     * {@link #setD(Direction) setD} method
     * @param d
     */
    public void setD(char d) {
        Direction dEnum = Direction.toEnum(d);
        if(dEnum == null) {
            return;
        }
        this.setD(dEnum);
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
}
