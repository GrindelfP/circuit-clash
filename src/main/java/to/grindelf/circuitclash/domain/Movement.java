package to.grindelf.circuitclash.domain;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Representation of a movement, performed on a piece on the game field.
 *
 * @param position the initial position of the piece, from which the movement starts.
 * @param movementMode    the mode of the movement, normal or reversed (white pieces movement is taken
 *                        as normal, black pieces movement is taken as reversed).
 */
record Movement(Position position, MovementMode movementMode) {

    /**
     * Method wrapping the constructor of the Movement instance with
     * the same movement mode as the current one. It is important for creating a sequence of
     * movements, which are of the same mode, but the initial position moves at each iteration.
     *
     * @param position the position of the piece, from which the next movement will start.
     * @return new Movement instance with the same movement mode as the current one and
     * different initial position.
     */
    @NotNull
    @Contract("_ -> new")
    private Movement movementOfSameMode(Position position) {
        return new Movement(position, this.movementMode);
    }

    /**
     * Representation of a movement up by one cell.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement moveUp() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(position.x(), position.y() + 1)) :
                movementOfSameMode(new Position(position.x(), position.y() - 1));
    }

    /**
     * Representation of a movement down by one cell.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement moveDown() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(position.x(), position.y() - 1)) :
                movementOfSameMode(new Position(position.x(), position.y() + 1));
    }

    /**
     * Representation of a movement left by one cell.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement moveLeft() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(position.x() - 1, position.y())) :
                movementOfSameMode(new Position(position.x() + 1, position.y()));
    }

    /**
     * Representation of a movement right by one cell.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement moveRight() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(position.x() + 1, position.y())) :
                movementOfSameMode(new Position(position.x() - 1, position.y()));
    }

    /**
     * Representation of a movement up left by one cell.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement moveUpLeft() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(position.x() - 1, position.y() + 1)) :
                movementOfSameMode(new Position(position.x() + 1, position.y() - 1));
    }

    /**
     * Representation of a movement up right by one cell.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement moveUpRight() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(position.x() + 1, position.y() + 1)) :
                movementOfSameMode(new Position(position.x() - 1, position.y() - 1));
    }

    /**
     * Representation of a movement down left by one cell.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement moveDownLeft() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(position.x() - 1, position.y() - 1)) :
                movementOfSameMode(new Position(position.x() + 1, position.y() + 1));
    }

    /**
     * Representation of a movement down right by one cell.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement moveDownRight() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(position.x() + 1, position.y() - 1)) :
                movementOfSameMode(new Position(position.x() - 1, position.y() + 1));
    }

    /**
     * Representation of a special move of a Knight, first up then left.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement jumpUpLeft() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(position.x() - 1, position.y() + 2)) :
                movementOfSameMode(new Position(position.x() + 1, position.y() - 2));
    }

    /**
     * Representation of a special move of a Knight, first up then right.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement jumpUpRight() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(position.x() + 1, position.y() + 2)) :
                movementOfSameMode(new Position(position.x() - 1, position.y() - 2));
    }

    /**
     * Representation of a special move of a Knight, first down then left.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement jumpDownLeft() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(position.x() - 1, position.y() - 2)) :
                movementOfSameMode(new Position(position.x() + 1, position.y() + 2));
    }

    /**
     * Representation of a special move of a Knight, first down then right.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement jumpDownRight() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(position.x() + 1, position.y() - 2)) :
                movementOfSameMode(new Position(position.x() - 1, position.y() + 2));
    }

    /**
     * Representation of a special move of a Knight, first left then up.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement jumpLeftUp() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(position.x() - 2, position.y() + 1)) :
                movementOfSameMode(new Position(position.x() + 2, position.y() - 1));
    }

    /**
     * Representation of a special move of a Knight, first right then up.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement jumpRightUp() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(position.x() + 2, position.y() + 1)) :
                movementOfSameMode(new Position(position.x() - 2, position.y() - 1));
    }

    /**
     * Representation of a special move of a Knight, first left then down.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement jumpLeftDown() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(position.x() - 2, position.y() - 1)) :
                movementOfSameMode(new Position(position.x() + 2, position.y() + 1));
    }

    /**
     * Representation of a special move of a Knight, first right then down.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement jumpRightDown() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(position.x() + 2, position.y() - 1)) :
                movementOfSameMode(new Position(position.x() - 2, position.y() + 1));
    }
}

/**
 * Enumeration of the movement modes, normal and reversed.
 */
enum MovementMode {
    NORMAL, REVERSED
}
