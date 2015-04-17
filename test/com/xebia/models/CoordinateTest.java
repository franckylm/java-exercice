package com.xebia.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoordinateTest {

    private Coordinate coord;

    /**
     * Both public constructors must have the same results.
     */
    @Test
    public void testParamsConstructor() {
        Coordinate c1 = new Coordinate(2, 2, Direction.NORTH);
        Coordinate c2 = new Coordinate(2, 2, 'N');
        assertEquals(c1.getX(), c2.getX());
        assertEquals(c1.getY(), c2.getY());
        assertEquals(c1.getD(), c2.getD());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArgumentException() {
        coord = new Coordinate(0, 1, 'D');
    }

    @Test
    public void testSetCoordinates() throws Exception {
        coord = new Coordinate(0, 1, 'N');

        coord.setD('D');
        assertEquals(coord.getD(), Direction.NORTH);

        coord.setD(Direction.SOUTH);
        assertEquals(coord.getD(), Direction.SOUTH);
    }

}