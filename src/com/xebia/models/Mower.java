package com.xebia.models;

public class Mower {

    /**
     * Coordinates of the highest point of the yard.
     * Class variable, shared by all Mower instances.
     */
    public static Coordinate yCoord;

    /**
     * Mower own coordinates.
     */
    private Coordinate mCoord;

    /**
     * Instantiate a {@link Mower} object with it's coordinates.
     *
     * Look {@link com.xebia.models.Coordinate#Coordinate(int, int, Direction)}.
     */
    public Mower(int x, int y, Direction d) {
        this(x, y);
        this.mCoord = new Coordinate(x, y, d);
    }

    /**
     * Instantiate a {@link Mower} object with it's coordinates.
     *
     * Look {@link com.xebia.models.Coordinate#Coordinate(int, int, char)}
     */
    public Mower(int x, int y, char d) {
        this(x, y);
        this.mCoord = new Coordinate(x, y, d);
    }

    /**
     * Instantiate a {@link Mower} object with it's coordinates.
     * Throw an {@link IllegalStateException} if {@link #yCoord} class variable is not instantiated.
     *
     * Look {@link com.xebia.models.Coordinate#Coordinate(String)}
     */
    public Mower(String str) {
        if (yCoord == null) {
            throw new IllegalStateException(
                    "Yard coordinates must be specified before any " +
                    "Mower object is instantiated.");
        }
        this.mCoord = new Coordinate(str);
    }

    /**
     * Instantiate a {@link Mower} object with it's coordinates.
     * Can only be used inside the class to avoid Mower object without {@link Direction} specified.
     *
     * Throw an {@link IllegalStateException} if {@link #yCoord} class variable is not instantiated.
     *
     * Look {@link com.xebia.models.Coordinate#Coordinate(int, int)}
     */
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
     * Instructions must be valid {@link Instruction} otherwise, will be ignored.
     *
     * @param str
     *        list of instructions to be executed by the Mower
     */
    public void executeInstructions(String str) {
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            Instruction single = Instruction.toEnum(aChar);
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
        this.tellMyPosition();
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

    public Coordinate getCoordinates() {
        return this.mCoord;
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

    public void setCoordinates(char d) {
        this.mCoord.setD(d);
    }

    public String toString() {
        return "(" +
                this.mCoord.getX() + ", " +
                this.mCoord.getY() + ", " +
                this.mCoord.getD().getChar() +
                ")";
    }

    private void tellMyPosition() {
        System.out.println(this.toString());
    }

}
