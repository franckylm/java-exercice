package com.xebia.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DirectionTest {

    @Test
    public void testGetChar() throws Exception {
        assertEquals(Direction.NORTH.getChar(), 'N');
        assertEquals(Direction.SOUTH.getChar(), 'S');
        assertEquals(Direction.EAST.getChar(), 'E');
        assertEquals(Direction.WEST.getChar(), 'W');
    }

    @Test
    public void testToEnum() throws Exception {
        assertEquals(Direction.toEnum('N'), Direction.NORTH);
        assertEquals(Direction.toEnum('S'), Direction.SOUTH);
        assertEquals(Direction.toEnum('E'), Direction.EAST);
        assertEquals(Direction.toEnum('W'), Direction.WEST);
        assertEquals(Direction.toEnum('D'), null);
    }
}