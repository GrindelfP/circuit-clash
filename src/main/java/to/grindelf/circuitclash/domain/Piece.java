package to.grindelf.circuitclash.domain;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import to.grindelf.circuitclash.utils.Playable;
import to.grindelf.circuitclash.visualization.PieceVisualizer;

import static to.grindelf.circuitclash.domain.PieceType.*;

/**
 * Representation of a chess piece.
 */
public abstract class Piece {

    /**
     * Piece type.
     */
    protected final PieceType type;
    /**
     * Piece color.
     */
    protected final PieceColor color;

    /**
     * Initializes a piece with given type and color.
     *
     * @param type  is a type of piece.
     * @param color is a color of piece.
     */
    public Piece(PieceType type, PieceColor color) {
        this.type = type;
        this.color = color;
    }

    /**
     * Overrides equals method to compare two pieces.
     *
     * @return true if pieces are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Piece piece = (Piece) o;

        if (type != piece.type) return false;
        return color == piece.color;
    }

    /**
     * Overrides hashCode method to compare two pieces.
     *
     * @return hash code of a piece.
     */
    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (color != null ? color.hashCode() : 0);

        return result;
    }

}

/**
 * Representation of a pawn.
 */
final class Pawn extends Piece implements Playable {

    /**
     * Initializes a pawn with given color.
     *
     * @param color is a color of pawn.
     */
    public Pawn(PieceColor color) {
        super(PAWN, color);
    }

    /**
     * Overrides toString method to return a graphical representation of a pawn.
     *
     * @return a string representation of a pawn.
     */
    @Override
    @NotNull
    @Contract(pure = true)
    public String toString() {
        return PieceVisualizer.visualizeAsString(PAWN, this.color);
    }

}

/**
 * Representation of a rook.
 */
final class Rook extends Piece implements Playable {

    /**
     * Initializes a rook with given color.
     *
     * @param color is a color of rook.
     */
    public Rook(PieceColor color) {
        super(ROOK, color);
    }

    /**
     * Overrides toString method to return a graphical representation of a rook.
     *
     * @return a string representation of a rook.
     */
    @Override
    @NotNull
    @Contract(pure = true)
    public String toString() {
        return PieceVisualizer.visualizeAsString(ROOK, this.color);
    }

}

/**
 * Representation of a knight.
 */
final class Knight extends Piece implements Playable {

    /**
     * Initializes a knight with given color.
     *
     * @param color is a color of knight.
     */
    public Knight(PieceColor color) {
        super(KNIGHT, color);
    }

    /**
     * Overrides toString method to return a graphical representation of a knight.
     *
     * @return a string representation of a knight.
     */
    @Override
    @NotNull
    @Contract(pure = true)
    public String toString() {
        return PieceVisualizer.visualizeAsString(KNIGHT, this.color);
    }

}

/**
 * Representation of a bishop.
 */
final class Bishop extends Piece implements Playable {

    /**
     * Initializes a bishop with given color.
     *
     * @param color is a color of bishop.
     */
    public Bishop(PieceColor color) {
        super(BISHOP, color);
    }

    /**
     * Overrides toString method to return a graphical representation of a bishop.
     *
     * @return a string representation of a bishop.
     */
    @Override
    @NotNull
    @Contract(pure = true)
    public String toString() {
        return PieceVisualizer.visualizeAsString(BISHOP, this.color);
    }

}

/**
 * Representation of a queen.
 */
final class Queen extends Piece implements Playable {

    /**
     * Initializes a queen with given color.
     *
     * @param color is a color of queen.
     */
    public Queen(PieceColor color) {
        super(QUEEN, color);
    }

    /**
     * Overrides toString method to return a graphical representation of a queen.
     *
     * @return a string representation of a queen.
     */
    @Override
    @NotNull
    @Contract(pure = true)
    public String toString() {
        return PieceVisualizer.visualizeAsString(QUEEN, this.color);
    }

}

/**
 * Representation of a king.
 */
final class King extends Piece implements Playable {

    /**
     * Initializes a king with given color.
     *
     * @param color is a color of king.
     */
    public King(PieceColor color) {
        super(KING, color);
    }

    /**
     * Overrides toString method to return a graphical representation of a king.
     *
     * @return a string representation of a king.
     */
    @Override
    @NotNull
    @Contract(pure = true)
    public String toString() {
        return PieceVisualizer.visualizeAsString(KING, this.color);
    }
}
