package to.grindelf.circuitclash.domain;


/**
 * Representation of a position of a piece on the game field.
 * Characterizes the piece's position by its x and y coordinates.
 *
 * @param x The x coordinate of the position.
 * @param y The y coordinate of the position.
 */
record Position(int x, int y) {

    /**
     * Position constructor. Checks if the provided position is on the board.
     *
     * @param x the x coordinate of the position.
     * @param y the y coordinate of the position.
     */
    Position(int x, int y) {
        if (coordinatesAreOnBoard(x, y)) {
            this.x = x;
            this.y = y;
        } else {
            throw new IllegalArgumentException("Position is not on the board");
        }
    }

    /**
     * Getter for the x coordinate of the position.
     *
     * @return the x coordinate of the position.
     */
    @Override
    public int x() {
        return x;
    }

    /**
     * Getter for the y coordinate of the position.
     *
     * @return the y coordinate of the position.
     */
    @Override
    public int y() {
        return y;
    }

    /**
     * Checks if the coordinates are on the board.
     *
     * @return true if the coordinates are on the board, false otherwise.
     */
    private boolean coordinatesAreOnBoard(int x, int y) {
        return x > 0 && x < 8 && y > 0 && y < 8;
    }
}
