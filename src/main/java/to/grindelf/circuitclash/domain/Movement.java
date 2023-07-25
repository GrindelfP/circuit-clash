package to.grindelf.circuitclash.domain;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

record Movement(Position initialPosition, MovementMode movementMode) {

    /**
     * Method wrapping the constructor of the Movement instance with
     * the same movement mode as the current one.
     *
     * @return new Movement instance with the same movement mode as the current one.
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
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(initialPosition.x(), initialPosition.y() + 1)) :
                movementOfSameMode(new Position(initialPosition.x(), initialPosition.y() - 1));
    }

    /**
     * Representation of a movement down by one cell.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement moveDown() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(initialPosition.x(), initialPosition.y() - 1)) :
                movementOfSameMode(new Position(initialPosition.x(), initialPosition.y() + 1));
    }

    /**
     * Representation of a movement left by one cell.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement moveLeft() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(initialPosition.x() - 1, initialPosition.y())) :
                movementOfSameMode(new Position(initialPosition.x() + 1, initialPosition.y()));
    }

    /**
     * Representation of a movement right by one cell.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement moveRight() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(initialPosition.x() + 1, initialPosition.y())) :
                movementOfSameMode(new Position(initialPosition.x() - 1, initialPosition.y()));
    }

    /**
     * Representation of a movement up left by one cell.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement moveUpLeft() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(initialPosition.x() - 1, initialPosition.y() + 1)) :
                movementOfSameMode(new Position(initialPosition.x() + 1, initialPosition.y() - 1));
    }

    /**
     * Representation of a movement up right by one cell.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement moveUpRight() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(initialPosition.x() + 1, initialPosition.y() + 1)) :
                movementOfSameMode(new Position(initialPosition.x() - 1, initialPosition.y() - 1));
    }

    /**
     * Representation of a movement down left by one cell.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement moveDownLeft() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(initialPosition.x() - 1, initialPosition.y() - 1)) :
                movementOfSameMode(new Position(initialPosition.x() + 1, initialPosition.y() + 1));
    }

    /**
     * Representation of a movement down right by one cell.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement moveDownRight() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(initialPosition.x() + 1, initialPosition.y() - 1)) :
                movementOfSameMode(new Position(initialPosition.x() - 1, initialPosition.y() + 1));
    }

    /**
     * Representation of a special move of a Knight, first up then left.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement jumpUpLeft() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(initialPosition.x() - 1, initialPosition.y() + 2)) :
                movementOfSameMode(new Position(initialPosition.x() + 1, initialPosition.y() - 2));
    }

    /**
     * Representation of a special move of a Knight, first up then right.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement jumpUpRight() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(initialPosition.x() + 1, initialPosition.y() + 2)) :
                movementOfSameMode(new Position(initialPosition.x() - 1, initialPosition.y() - 2));
    }

    /**
     * Representation of a special move of a Knight, first down then left.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement jumpDownLeft() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(initialPosition.x() - 1, initialPosition.y() - 2)) :
                movementOfSameMode(new Position(initialPosition.x() + 1, initialPosition.y() + 2));
    }

    /**
     * Representation of a special move of a Knight, first down then right.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement jumpDownRight() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(initialPosition.x() + 1, initialPosition.y() - 2)) :
                movementOfSameMode(new Position(initialPosition.x() - 1, initialPosition.y() + 2));
    }

    /**
     * Representation of a special move of a Knight, first left then up.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement jumpLeftUp() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(initialPosition.x() - 2, initialPosition.y() + 1)) :
                movementOfSameMode(new Position(initialPosition.x() + 2, initialPosition.y() - 1));
    }

    /**
     * Representation of a special move of a Knight, first right then up.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement jumpRightUp() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(initialPosition.x() + 2, initialPosition.y() + 1)) :
                movementOfSameMode(new Position(initialPosition.x() - 2, initialPosition.y() - 1));
    }

    /**
     * Representation of a special move of a Knight, first left then down.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement jumpLeftDown() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(initialPosition.x() - 2, initialPosition.y() - 1)) :
                movementOfSameMode(new Position(initialPosition.x() + 2, initialPosition.y() + 1));
    }

    /**
     * Representation of a special move of a Knight, first right then down.
     *
     * @return new movement after the movement.
     */
    @NotNull
    public Movement jumpRightDown() {
        return this.movementMode == MovementMode.NORMAL ? movementOfSameMode(new Position(initialPosition.x() + 2, initialPosition.y() - 1)) :
                movementOfSameMode(new Position(initialPosition.x() - 2, initialPosition.y() + 1));
    }
}

enum MovementMode {
    NORMAL, REVERSED
}

final class Position {
    private final int x;
    private final int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    /**
     * Checks if the movement is on the board.
     *
     * @return true if the movement is on the board, false otherwise.
     */
    public boolean isOnBoard() {
        return this.x() >= 0 && this.x() < 8 && this.y() >= 0 && this.y() < 8;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    /**
     * Overrides equals method for the Movement class.
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

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Position[" +
                "x=" + x + ", " +
                "y=" + y + ']';
    }

} 
