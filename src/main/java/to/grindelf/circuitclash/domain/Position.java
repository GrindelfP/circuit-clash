package to.grindelf.circuitclash.domain;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

record Position(int x, int y, MovementMode movementMode) {

    /**
     * Method wrapping the constructor of the Position instance with
     * the same movement mode as the current one.
     *
     * @return new Position instance with the same movement mode as the current one.
     */
    @NotNull
    @Contract("_, _ -> new")
    private Position positionOfSameMovementMode(int x, int y) {
        return new Position(x, y, this.movementMode);
    }

    /**
     * Constructor of the Position instance with the NORMAL movement mode. It is used for tests.
     *
     * @param x the x coordinate of the position.
     * @param y the y coordinate of the position.
     */
    public Position(int x, int y) {
        this(x, y, MovementMode.NORMAL);
    }

    /**
     * Checks if the position is on the board.
     *
     * @return true if the position is on the board, false otherwise.
     */
    public boolean isOnBoard() {
        return this.x() >= 0 && this.x() < 8 && this.y() >= 0 && this.y() < 8;
    }

    /**
     * Representation of a movement up by one cell.
     *
     * @return new position after the movement.
     */
    @NotNull
    public Position moveUp() {
        return this.movementMode == MovementMode.NORMAL ? positionOfSameMovementMode(this.x, this.y + 1) :
                positionOfSameMovementMode(this.x, this.y - 1);
    }

    /**
     * Representation of a movement down by one cell.
     *
     * @return new position after the movement.
     */
    @NotNull
    public Position moveDown() {
        return this.movementMode == MovementMode.NORMAL ? positionOfSameMovementMode(this.x, this.y - 1) :
                positionOfSameMovementMode(this.x, this.y + 1);
    }

    /**
     * Representation of a movement left by one cell.
     *
     * @return new position after the movement.
     */
    @NotNull
    public Position moveLeft() {
        return this.movementMode == MovementMode.NORMAL ? positionOfSameMovementMode(this.x - 1, this.y) :
                positionOfSameMovementMode(this.x + 1, this.y);
    }

    /**
     * Representation of a movement right by one cell.
     *
     * @return new position after the movement.
     */
    @NotNull
    public Position moveRight() {
        return this.movementMode == MovementMode.NORMAL ? positionOfSameMovementMode(this.x + 1, this.y) :
                positionOfSameMovementMode(this.x - 1, this.y);
    }

    /**
     * Representation of a movement up left by one cell.
     *
     * @return new position after the movement.
     */
    @NotNull
    public Position moveUpLeft() {
        return this.movementMode == MovementMode.NORMAL ? positionOfSameMovementMode(this.x - 1, this.y + 1) :
                positionOfSameMovementMode(this.x + 1, this.y - 1);
    }

    /**
     * Representation of a movement up right by one cell.
     *
     * @return new position after the movement.
     */
    @NotNull
    public Position moveUpRight() {
        return this.movementMode == MovementMode.NORMAL ? positionOfSameMovementMode(this.x + 1, this.y + 1) :
                positionOfSameMovementMode(this.x - 1, this.y - 1);
    }

    /**
     * Representation of a movement down left by one cell.
     *
     * @return new position after the movement.
     */
    @NotNull
    public Position moveDownLeft() {
        return this.movementMode == MovementMode.NORMAL ? positionOfSameMovementMode(this.x - 1, this.y - 1) :
                positionOfSameMovementMode(this.x + 1, this.y + 1);
    }

    /**
     * Representation of a movement down right by one cell.
     *
     * @return new position after the movement.
     */
    @NotNull
    public Position moveDownRight() {
        return this.movementMode == MovementMode.NORMAL ? positionOfSameMovementMode(this.x + 1, this.y - 1) :
                positionOfSameMovementMode(this.x - 1, this.y + 1);
    }

    /**
     * Representation of a special move of a Knight, first up then left.
     *
     * @return new position after the movement.
     */
    @NotNull
    public Position jumpUpLeft() {
        return this.movementMode == MovementMode.NORMAL ? positionOfSameMovementMode(this.x - 1, this.y + 2) :
                positionOfSameMovementMode(this.x + 1, this.y - 2);
    }

    /**
     * Representation of a special move of a Knight, first up then right.
     *
     * @return new position after the movement.
     */
    @NotNull
    public Position jumpUpRight() {
        return this.movementMode == MovementMode.NORMAL ? positionOfSameMovementMode(this.x + 1, this.y + 2) :
                positionOfSameMovementMode(this.x - 1, this.y - 2);
    }

    /**
     * Representation of a special move of a Knight, first down then left.
     *
     * @return new position after the movement.
     */
    @NotNull
    public Position jumpDownLeft() {
        return this.movementMode == MovementMode.NORMAL ? positionOfSameMovementMode(this.x - 1, this.y - 2) :
                positionOfSameMovementMode(this.x + 1, this.y + 2);
    }

    /**
     * Representation of a special move of a Knight, first down then right.
     *
     * @return new position after the movement.
     */
    @NotNull
    public Position jumpDownRight() {
        return this.movementMode == MovementMode.NORMAL ? positionOfSameMovementMode(this.x + 1, this.y - 2) :
                positionOfSameMovementMode(this.x - 1, this.y + 2);
    }

    /**
     * Representation of a special move of a Knight, first left then up.
     *
     * @return new position after the movement.
     */
    @NotNull
    public Position jumpLeftUp() {
        return this.movementMode == MovementMode.NORMAL ? positionOfSameMovementMode(this.x - 2, this.y + 1) :
                positionOfSameMovementMode(this.x + 2, this.y - 1);
    }

    /**
     * Representation of a special move of a Knight, first right then up.
     *
     * @return new position after the movement.
     */
    @NotNull
    public Position jumpRightUp() {
        return this.movementMode == MovementMode.NORMAL ? positionOfSameMovementMode(this.x + 2, this.y + 1) :
                positionOfSameMovementMode(this.x - 2, this.y - 1);
    }

    /**
     * Representation of a special move of a Knight, first left then down.
     *
     * @return new position after the movement.
     */
    @NotNull
    public Position jumpLeftDown() {
        return this.movementMode == MovementMode.NORMAL ? positionOfSameMovementMode(this.x - 2, this.y - 1) :
                positionOfSameMovementMode(this.x + 2, this.y + 1);
    }

    /**
     * Representation of a special move of a Knight, first right then down.
     *
     * @return new position after the movement.
     */
    @NotNull
    public Position jumpRightDown() {
        return this.movementMode == MovementMode.NORMAL ? positionOfSameMovementMode(this.x + 2, this.y - 1) :
                positionOfSameMovementMode(this.x - 2, this.y + 1);
    }

    /**
     * Overrides equals method for the Position class.
     *
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

enum MovementMode {
    NORMAL, REVERSED
}
