package com.xebia.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InstructionTest {

    @Test
    public void testGetChar() throws Exception {
        assertEquals(Instruction.LEFT.getChar(), 'G');
        assertEquals(Instruction.RIGHT.getChar(), 'D');
        assertEquals(Instruction.FORWARD.getChar(), 'A');
    }

    @Test
    public void testToEnum() throws Exception {
        assertEquals(Instruction.toEnum('G'), Instruction.LEFT);
        assertEquals(Instruction.toEnum('D'), Instruction.RIGHT);
        assertEquals(Instruction.toEnum('A'), Instruction.FORWARD);
        assertEquals(Direction.toEnum('Z'), null);
    }
}