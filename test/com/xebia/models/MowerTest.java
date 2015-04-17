package com.xebia.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MowerTest {

    private Mower mower;

    @Before
    public void setUp() throws Exception {
        Mower.yCoord = new Coordinate(5,5);
    }

    @Test
    public void testMoveForward() throws Exception {
        mower = new Mower(2,2,'N');
        mower.moveForward();
        assertEquals(mower.getCoordinates().getY(), 3);

        mower.setCoordinates('E');
        mower.moveForward();
        assertEquals(mower.getCoordinates().getX(), 3);

        mower.setCoordinates('S');
        mower.moveForward();
        assertEquals(mower.getCoordinates().getY(), 2);

        mower.setCoordinates('W');
        mower.moveForward();
        assertEquals(mower.getCoordinates().getY(), 2);

    }

    @Test
    public void testLimitsMoveForward() {
        mower = new Mower(1,5,'N');
        mower.moveForward();
        assertEquals(mower.getCoordinates().getY(), 5);

        mower = new Mower(5,5,'E');
        mower.moveForward();
        assertEquals(mower.getCoordinates().getX(), 5);

        mower = new Mower(2,0,'S');
        mower.moveForward();
        assertEquals(mower.getCoordinates().getY(), 0);

        mower = new Mower(0,0,'W');
        mower.moveForward();
        assertEquals(mower.getCoordinates().getX(), 0);
    }

    @Test
    public void testTurnLeft() throws Exception {
        mower = new Mower(3, 3, 'S');
        mower.turnLeft();
        assertEquals(mower.getCoordinates().getD(), 'E');
        mower.turnLeft();
        assertEquals(mower.getCoordinates().getD(), 'N');
        mower.turnLeft();
        assertEquals(mower.getCoordinates().getD(), 'W');
        mower.turnLeft();
        assertEquals(mower.getCoordinates().getD(), 'S');
    }

    @Test
    public void testTurnRight() throws Exception {
        mower = new Mower(3, 3, 'S');
        mower.turnRight();
        assertEquals(mower.getCoordinates().getD(), 'W');
        mower.turnRight();
        assertEquals(mower.getCoordinates().getD(), 'N');
        mower.turnRight();
        assertEquals(mower.getCoordinates().getD(), 'E');
        mower.turnRight();
        assertEquals(mower.getCoordinates().getD(), 'S');
    }

    /**
     * It is important to always run this test at the end of the Class.
     * Because we're resetting Mower.yCoord class variable to null.
     * Therefore, an IllegalStateException could be thrown when not expected.
     */
    @Test(expected = IllegalStateException.class)
    public void testStateException() {
        Mower.yCoord = null;
        mower = new Mower(1,1,'N');
    }
}