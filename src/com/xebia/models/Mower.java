package com.xebia.models;

public class Mower {

    /**
     * Mower own coordinates.
     */
    private Coordinate mCoord;

    /**
     * Coordinates of the highest point of the yard.
     * Shared between all Mower instances.
     */
    public static Coordinate yCoord;

    public Mower(int x, int y, char d) {
        if(yCoord == null){
            throw new IllegalStateException(
                    "Yard coordinates must be specified before any " +
                    "Mower object is instantiated.");
        }
        this.mCoord = new Coordinate(x, y, d);
    }

    /**
     * Step moveForward in the current direction.
     * If off limits, then do nothing.
     */
    public void moveForward() {
        switch (mCoord.getD()) {
            case 'N':
                if(mCoord.getY() < yCoord.getY()){
                   mCoord.incrementY();
                }
                break;
            case 'E':
                if(mCoord.getX() < yCoord.getX()){
                    mCoord.incrementX();
                }
                break;
            case 'W':
                if(mCoord.getX() > 0){
                    mCoord.decrementX();
                }
                break;
            case 'S':
                if(mCoord.getY() > 0){
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
            case 'N':
                this.setCoordinates('W');
                break;
            case 'E':
                this.setCoordinates('N');
                break;
            case 'S':
                this.setCoordinates('E');
                break;
            case 'W':
                this.setCoordinates('S');
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
            case 'N':
                this.setCoordinates('E');
                break;
            case 'E':
                this.setCoordinates('S');
                break;
            case 'S':
                this.setCoordinates('W');
                break;
            case 'W':
                this.setCoordinates('N');
                break;
            default:
                break;
        }
    }

    /**
     * Returns the Mower coordinates.
     * @return
     */
    public Coordinate getCoordinates() {
        return this.mCoord;
    }

    /**
     * This method uses the setD() method of the Coordinates class.
     * Check that method for more information.
     * @param d (Direction in cardinal notation)
     */
    public void setCoordinates(char d) {
        this.mCoord.setD(d);
    }

}
