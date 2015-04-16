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
     * Step forward in the current direction.
     * If off limits, then do nothing.
     */
    public void forward() {
        switch (this.mCoord.getD()) {
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
    public void pivotLeft() {

    }

    /**
     * Turns on 90° to the right.
     */
    public void pivotRight() {

    }

    /**
     * Returns the Mower coordinates.
     * @return
     */
    public Coordinate getCoordinates() {
        return this.mCoord;
    }

    /**
     * Only enable the change of the direction.
     * Doesn't take into account false direction.
     * @param d (Direction in cardinal notation)
     */
    public void setCoordinates(char d) {
        if(d != 'N' && d != 'E' && d != 'W' && d != 'S') {
            return;
        }
        this.mCoord.setD(d);
    }

}
