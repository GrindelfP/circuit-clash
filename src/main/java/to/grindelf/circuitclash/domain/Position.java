package to.grindelf.circuitclash.domain;

import org.jetbrains.annotations.NotNull;

record Position(int x, int y) {

    /**
     * Checks if the position is on the board.
     * @return true if the position is on the board, false otherwise.
     */
    public boolean isOnBoard() {
        return this.x() >= 0 && this.x() < 8 && this.y() >= 0 && this.y() < 8;
    }

    /**
     * Representation of a movement up by one cell.
     * @param color color of the piece which influences the direction of the movement.
     * @return new position after the movement.
     */
    @NotNull
    public Position moveUp(PieceColor color) {
        return color == PieceColor.WHITE ? new Position(this.x(), this.y() + 1) :
                new Position(this.x(), this.y() - 1);
    }

    /**
     * Representation of a movement down by one cell.
     * @param color color of the piece which influences the direction of the movement.
     * @return new position after the movement.
     */
    @NotNull
    public Position moveDown(PieceColor color) {
        return color == PieceColor.WHITE ? new Position(this.x(), this.y() - 1) :
                new Position(this.x(), this.y() + 1);
    }

    /**
     * Representation of a movement left by one cell.
     * @param color color of the piece which influences the direction of the movement.
     * @return new position after the movement.
     */
    @NotNull
    public Position moveLeft(PieceColor color) {
        return color == PieceColor.WHITE ? new Position(this.x() - 1, this.y()) :
                new Position(this.x() + 1, this.y());
    }

    /**
     * Representation of a movement right by one cell.
     * @param color color of the piece which influences the direction of the movement.
     * @return new position after the movement.
     */
    @NotNull
    public Position moveRight(PieceColor color) {
        return color == PieceColor.WHITE ? new Position(this.x() + 1, this.y()) :
                new Position(this.x() - 1, this.y());
    }

    /**
     * Representation of a movement up left by one cell.
     * @param color color of the piece which influences the direction of the movement.
     * @return new position after the movement.
     */
    @NotNull
    public Position moveUpLeft(PieceColor color) {
        return color == PieceColor.WHITE ? new Position(this.x() - 1, this.y() + 1) :
                new Position(this.x() + 1, this.y() - 1);
    }

    /**
     * Representation of a movement up right by one cell.
     * @param color color of the piece which influences the direction of the movement.
     * @return new position after the movement.
     */
    @NotNull
    public Position moveUpRight(PieceColor color) {
        return color == PieceColor.WHITE ? new Position(this.x() + 1, this.y() + 1) :
                new Position(this.x() - 1, this.y() - 1);
    }

    /**
     * Representation of a movement down left by one cell.
     * @param color color of the piece which influences the direction of the movement.
     * @return new position after the movement.
     */
    @NotNull
    public Position moveDownLeft(PieceColor color) {
        return color == PieceColor.WHITE ? new Position(this.x() - 1, this.y() - 1) :
                new Position(this.x() + 1, this.y() + 1);
    }

    /**
     * Representation of a movement down right by one cell.
     * @param color color of the piece which influences the direction of the movement.
     * @return new position after the movement.
     */
    @NotNull
    public Position moveDownRight(PieceColor color) {
        return color == PieceColor.WHITE ? new Position(this.x() + 1, this.y() - 1) :
                new Position(this.x() - 1, this.y() + 1);
    }

    /**
     * Representation of a special move of a Knight, first up then left.
     * @param color color of the piece which influences the direction of the movement.
     * @return new position after the movement.
     */
    @NotNull
    public Position jumpUpLeft(PieceColor color) {
        return color == PieceColor.WHITE ? new Position(this.x() - 2, this.y() + 1) :
                new Position(this.x() + 2, this.y() - 1);
    }

    /**
     * Representation of a special move of a Knight, first up then right.
     * @param color color of the piece which influences the direction of the movement.
     * @return new position after the movement.
     */
    @NotNull
    public Position jumpUpRight(PieceColor color) {
        return color == PieceColor.WHITE ? new Position(this.x() + 2, this.y() + 1) :
                new Position(this.x() - 2, this.y() - 1);
    }

    /**
     * Representation of a special move of a Knight, first down then left.
     * @param color color of the piece which influences the direction of the movement.
     * @return new position after the movement.
     */
    @NotNull
    public Position jumpDownLeft(PieceColor color) {
        return color == PieceColor.WHITE ? new Position(this.x() - 2, this.y() - 1) :
                new Position(this.x() + 2, this.y() + 1);
    }

    /**
     * Representation of a special move of a Knight, first down then right.
     * @param color color of the piece which influences the direction of the movement.
     * @return new position after the movement.
     */
    @NotNull
    public Position jumpDownRight(PieceColor color) {
        return color == PieceColor.WHITE ? new Position(this.x() + 2, this.y() - 1) :
                new Position(this.x() - 2, this.y() + 1);
    }

    /**
     * Representation of a special move of a Knight, first left then up.
     * @param color color of the piece which influences the direction of the movement.
     * @return new position after the movement.
     */
    @NotNull
    public Position jumpLeftUp(PieceColor color) {
        return color == PieceColor.WHITE ? new Position(this.x() - 1, this.y() + 2) :
                new Position(this.x() + 1, this.y() - 2);
    }

    /**
     * Representation of a special move of a Knight, first right then up.
     * @param color color of the piece which influences the direction of the movement.
     * @return new position after the movement.
     */
    @NotNull
    public Position jumpRightUp(PieceColor color) {
        return color == PieceColor.WHITE ? new Position(this.x() + 1, this.y() + 2) :
                new Position(this.x() - 1, this.y() - 2);
    }

    /**
     * Representation of a special move of a Knight, first left then down.
     * @param color color of the piece which influences the direction of the movement.
     * @return new position after the movement.
     */
    @NotNull
    public Position jumpLeftDown(PieceColor color) {
        return color == PieceColor.WHITE ? new Position(this.x() - 1, this.y() - 2) :
                new Position(this.x() + 1, this.y() + 2);
    }

    /**
     * Representation of a special move of a Knight, first right then down.
     * @param color color of the piece which influences the direction of the movement.
     * @return new position after the movement.
     */
    @NotNull
    public Position jumpRightDown(PieceColor color) {
        return color == PieceColor.WHITE ? new Position(this.x() + 1, this.y() - 2) :
                new Position(this.x() - 1, this.y() + 2);
    }

    /**
     * Overrides equals method for the Position class.
     * @param o the reference object with which to compare.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Position position = (Position) o;

        return x == position.x && y == position.y;
    }
}
