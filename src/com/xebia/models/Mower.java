package com.xebia.models;

public class Mower {

    /**
     * Coordinates of the highest point of the yard.
     * Shared between all Mower instances.
     */
    public static Coordinate yCoord;
    /**
     * Mower own coordinates.
     */
    private Coordinate mCoord;

    public Mower(int x, int y, Direction d) {
        this(x, y);
        this.mCoord = new Coordinate(x, y, d);
    }

    public Mower(int x, int y, char d) {
        this(x, y);
        this.mCoord = new Coordinate(x, y, d);
    }

    private Mower(int x, int y) {
        if (yCoord == null) {
            throw new IllegalStateException(
                    "Yard coordinates must be specified before any " +
                            "Mower object is instantiated.");
        }
        this.mCoord = new Coordinate(x, y);
    }

    /**
     * Take a group of instructions as a string and executes them all.
     *
     * @param str
     */
    public void executeInstructions(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Instruction single = Instruction.toEnum(chars[i]);
            if (single == null) {
                continue;
            }
            switch (single) {
                case FORWARD:
                    this.moveForward();
                    break;
                case LEFT:
                    this.turnLeft();
                    break;
                case RIGHT:
                    this.turnRight();
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Step moveForward in the current direction.
     * If off limits, then do nothing.
     */
    public void moveForward() {
        switch (mCoord.getD()) {
            case NORTH:
                if (mCoord.getY() < yCoord.getY()) {
                    mCoord.incrementY();
                }
                break;
            case EAST:
                if (mCoord.getX() < yCoord.getX()) {
                    mCoord.incrementX();
                }
                break;
            case WEST:
                if (mCoord.getX() > 0) {
                    mCoord.decrementX();
                }
                break;
            case SOUTH:
                if (mCoord.getY() > 0) {
                    mCoord.decrementY();
                }
                break;
            default:
                break;
        }
    }

    /**
     * Turns on 90° to the left.
     */
    public void turnLeft() {
        switch (mCoord.getD()) {
            case NORTH:
                this.setCoordinates(Direction.WEST);
                break;
            case EAST:
                this.setCoordinates(Direction.NORTH);
                break;
            case SOUTH:
                this.setCoordinates(Direction.EAST);
                break;
            case WEST:
                this.setCoordinates(Direction.SOUTH);
                break;
            default:
                break;
        }
    }

    /**
     * Turns on 90° to the right.
     */
    public void turnRight() {
        switch (mCoord.getD()) {
            case NORTH:
                this.setCoordinates(Direction.EAST);
                break;
            case EAST:
                this.setCoordinates(Direction.SOUTH);
                break;
            case SOUTH:
                this.setCoordinates(Direction.WEST);
                break;
            case WEST:
                this.setCoordinates(Direction.NORTH);
                break;
            default:
                break;
        }
    }

    /**
     * Returns the Mower coordinates.
     *
     * @return
     */
    public Coordinate getCoordinates() {
        return this.mCoord;
    }

    public void setCoordinates(char d) {
        this.mCoord.setD(d);
    }

    /**
     * This method uses the setD() method of the Coordinates class.
     * Check that method for more information.
     *
     * @param d (Direction in cardinal notation)
     */
    public void setCoordinates(Direction d) {
        this.mCoord.setD(d);
    }

}
