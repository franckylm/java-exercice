package com.xebia.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MowerTest {

    private Mower mower;

    @Before
    public void setUp() throws Exception {
        Mower.yCoord = new Coordinate(5, 5);
    }

    @Test
    public void testMoveForward() throws Exception {
        mower = new Mower(2, 2, Direction.NORTH);
        mower.moveForward();
        assertEquals(mower.getCoordinates().getY(), 3);

        mower.setCoordinates(Direction.EAST);
        mower.moveForward();
        assertEquals(mower.getCoordinates().getX(), 3);

        mower.setCoordinates(Direction.SOUTH);
        mower.moveForward();
        assertEquals(mower.getCoordinates().getY(), 2);

        mower.setCoordinates(Direction.WEST);
        mower.moveForward();
        assertEquals(mower.getCoordinates().getY(), 2);
    }

    @Test
    public void testLimitsMoveForward() throws Exception {
        mower = new Mower(1, 5, Direction.NORTH);
        mower.moveForward();
        assertEquals(mower.getCoordinates().getY(), 5);

        mower = new Mower(5, 5, Direction.EAST);
        mower.moveForward();
        assertEquals(mower.getCoordinates().getX(), 5);

        mower = new Mower(2, 0, Direction.SOUTH);
        mower.moveForward();
        assertEquals(mower.getCoordinates().getY(), 0);

        mower = new Mower(0, 0, Direction.WEST);
        mower.moveForward();
        assertEquals(mower.getCoordinates().getX(), 0);
    }

    @Test
    public void testTurnLeft() throws Exception {
        mower = new Mower(3, 3, Direction.SOUTH);
        mower.turnLeft();
        assertEquals(mower.getCoordinates().getD(), Direction.EAST);
        mower.turnLeft();
        assertEquals(mower.getCoordinates().getD(), Direction.NORTH);
        mower.turnLeft();
        assertEquals(mower.getCoordinates().getD(), Direction.WEST);
        mower.turnLeft();
        assertEquals(mower.getCoordinates().getD(), Direction.SOUTH);
    }

    @Test
    public void testTurnRight() throws Exception {
        mower = new Mower(3, 3, Direction.SOUTH);
        mower.turnRight();
        assertEquals(mower.getCoordinates().getD(), Direction.WEST);
        mower.turnRight();
        assertEquals(mower.getCoordinates().getD(), Direction.NORTH);
        mower.turnRight();
        assertEquals(mower.getCoordinates().getD(), Direction.EAST);
        mower.turnRight();
        assertEquals(mower.getCoordinates().getD(), Direction.SOUTH);
    }

    @Test
    public void testExecuteInstruction() throws Exception {
        mower = new Mower(1, 2, 'N');
        mower.executeInstructions("GAGAGAGAA");
        assertEquals(mower.getCoordinates().getX(), 1);
        assertEquals(mower.getCoordinates().getY(), 3);
        assertEquals(mower.getCoordinates().getD(), Direction.toEnum('N'));

        mower = new Mower(1, 2, 'N');
        mower.executeInstructions("ZGAGA GAGAAS");
        assertEquals(mower.getCoordinates().getX(), 1);
        assertEquals(mower.getCoordinates().getY(), 3);
        assertEquals(mower.getCoordinates().getD(), Direction.toEnum('N'));
    }

    @Test
    public void testToString() throws Exception {
        mower = new Mower(1, 4, 'S');
        assertEquals(mower.toString(), "1 4 S");
    }

    /**
     * It is important to always run this test at the end of the Class.
     * Because we're resetting Mower.yCoord class variable to null.
     * Therefore, an IllegalStateException could be thrown when not expected.
     */
    @Test(expected = IllegalStateException.class)
    public void testStateException() {
        Mower.yCoord = null;
        mower = new Mower(1, 1, 'N');
    }

}