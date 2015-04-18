package com.xebia.models;

public enum Direction {

    NORTH('N'), EAST('E'), WEST('W'), SOUTH('S');

    /**
     * This represents the direction character.
     * eg: 'N' => NORTH
     */
    private final char dChar;

    Direction(char dChar) {
        this.dChar = dChar;
    }

    /**
     * Get the Enum version of the cardinal coordinate.
     * If no character matches, then return null.
     *
     * @param dChar
     *        char to be converted into {@link Direction} type
     *
     * @return the resulting {@link Direction} or null
     */
    public static Direction toEnum(char dChar) {
        for (Direction d : Direction.values()) {
            if (dChar == d.getChar()) {
                return d;
            }
        }
        return null;
    }

    /**
     * {@link #toEnum(char)}
     *
     * @param dString
     *        string to be converted into {@link Direction} type
     */
    public static Direction toEnum(String dString) {
        return Direction.toEnum(dString.charAt(0));
    }

    public char getChar() {
        return this.dChar;
    }
}
