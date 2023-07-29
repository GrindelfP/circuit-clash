package to.grindelf.circuitclash.domain;

import java.util.Objects;

/**
 * Representation of a position of a piece on the chessboard. Position is
 * depicted as a Coordinates object.
 */
public class Position {

    /**
     * Coordinates of a position.
     */
    private final Coordinates coordinates;

    /**
     * Initializes a position with given coordinates.
     * @param x is a number of column, starting from 0.
     * @param y is a number of row, starting from 0.
     */
    public Position(int x, int y) {
        coordinates = new Coordinates(x, y);
    }

    /**
     * Returns numerical coordinates of a position.
     * @return Coordinates object.
     */
    public Coordinates getNumerical() {
        return coordinates;
    }

    /**
     * Returns alphanumerical coordinates of a position.
     * @return a string representation of a position in traditional chess form
     * (a2, b5, h8, etc.).
     */
    public String getAlphanumerical() {
        return String.format("%c%d", 'a' + this.x(), this.y() + 1);
    }

    /**
     * Returns x coordinate of this position.
     * @return x coordinate.
     */
    private int x() {
        return this.coordinates.x();
    }

    /**
     * Returns y coordinate of this position.
     * @return y coordinate.
     */
    private int y() {
        return this.coordinates.y();
    }

    /**
     * Overrides equals method to compare two positions.
     * @param object is an object to compare with.
     * @return true if positions are equal, false otherwise.
     */
    @Override
    public boolean equals(Object object) {
        boolean isEqual = false;

        if (object instanceof Position other) {
            isEqual = this.x() == other.x() && this.y() == other.y();
        }
        return isEqual;
    }

    /**
     * Overrides hashCode method to compare two positions.
     * @return hash code of a position.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.x(), this.y());
    }
}
