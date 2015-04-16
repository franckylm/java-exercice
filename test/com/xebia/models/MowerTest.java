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
    public void testForward() throws Exception {
        mower = new Mower(2,2,'N');
        mower.forward();
        assertEquals(mower.getCoordinates().getY(), 3);

        mower.setCoordinates('E');
        mower.forward();
        assertEquals(mower.getCoordinates().getX(), 3);

        mower.setCoordinates('S');
        mower.forward();
        assertEquals(mower.getCoordinates().getY(), 2);

        mower.setCoordinates('W');
        mower.forward();
        assertEquals(mower.getCoordinates().getY(), 2);

    }

    @Test
    public void testLimits() {
        mower = new Mower(1,5,'N');
        mower.forward();
        assertEquals(mower.getCoordinates().getY(), 5);

        mower = new Mower(5,5,'E');
        mower.forward();
        assertEquals(mower.getCoordinates().getX(), 5);

        mower = new Mower(2,0,'S');
        mower.forward();
        assertEquals(mower.getCoordinates().getY(), 0);

        mower = new Mower(0,0,'W');
        mower.forward();
        assertEquals(mower.getCoordinates().getX(), 0);
    }

    @Test
    public void testPivotLeft() throws Exception {

    }

    @Test
    public void testPivotRight() throws Exception {

    }

    @Test
    public void testGetCoordinates() throws Exception {

    }
}