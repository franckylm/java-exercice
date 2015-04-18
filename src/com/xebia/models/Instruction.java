package com.xebia.models;

public enum Instruction {

    LEFT('G'), RIGHT('D'), FORWARD('A');

    /**
     * This represents the instruction character in french.
     * eg: 'G' => LEFT (GAUCHE in french)
     */
    private final char iChar;

    Instruction(char iChar) {
        this.iChar = iChar;
    }

    /**
     * Get the Enum version of the cardinal coordinate.
     * If no character matches, then return null.
     *
     * @param iChar
     *        char to be converted into {@link Instruction} type
     *
     * @return the resulting {@link Instruction} or null
     */
    public static Instruction toEnum(char iChar) {
        for (Instruction i : Instruction.values()) {
            if (iChar == i.getChar()) {
                return i;
            }
        }
        return null;
    }

    public char getChar() {
        return iChar;
    }
}
