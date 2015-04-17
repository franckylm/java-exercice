package com.xebia.models;

public enum Instruction {

    LEFT ('G'), RIGTH('D'), FORWARD('A');

    /**
     * This represents the instruction character in french.
     * eg: 'G' => LEFT (GAUCHE in french)
     */
    private final char iChar;

    Instruction(char iChar) {
        this.iChar = iChar;
    }

    public char getChar() {
        return iChar;
    }
}
