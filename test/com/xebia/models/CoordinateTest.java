package com.xebia.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinateTest {

    private Coordinate coord;

    @Test(expected = IllegalArgumentException.class)
    public void testArgumentException() {
        coord = new Coordinate(0, 1, 'D');
    }

    @Test
    public void testSetCoordinates() throws Exception {
        coord = new Coordinate(0, 1, 'N');
        coord.setD('D');
        assertEquals(coord.getD(), 'N');
    }

}