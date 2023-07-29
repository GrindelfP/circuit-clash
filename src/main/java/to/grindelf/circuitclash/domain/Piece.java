package to.grindelf.circuitclash.domain;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.File;

import static to.grindelf.circuitclash.domain.PieceColor.WHITE;
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
     * Function returns a graphical representation of a piece.
     *
     * @return a file - graphical representation of a piece.
     */
    public abstract File getImage();

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

    public PieceType type() {
        return type;
    }
}

/**
 * Representation of a pawn.
 */
final class Pawn extends Piece {

    /**
     * File with image of white pawn.
     */
    private final File whitePawnImage = new File("path/to/white/pawn/image");
    /**
     * File with image of black pawn.
     */
    private final File blackPawnImage = new File("path/to/black/pawn/image");

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
        String whitePawnSymbol = "♙";
        String blackPawnSymbol = "♟";
        return this.color == WHITE ? whitePawnSymbol : blackPawnSymbol;
    }

    /**
     * Function returns a graphical representation of a pawn.
     *
     * @return a file - graphical representation of a pawn.
     */
    @Override
    @NotNull
    @Contract(pure = true)
    public File getImage() {
        throw new UnsupportedOperationException("Not implemented yet because of the lack of resource.");
        // return this.color == WHITE ? whitePawnImage : blackPawnImage;
    }
}

/**
 * Representation of a rook.
 */
final class Rook extends Piece {

    /**
     * File with image of white rook.
     */
    private final File whiteRookImage = new File("path/to/white/rook/image");
    /**
     * File with image of black rook.
     */
    private final File blackRookImage = new File("path/to/black/rook/image");

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
        String whiteRookSymbol = "♖";
        String blackRookSymbol = "♜";
        return this.color == WHITE ? whiteRookSymbol : blackRookSymbol;
    }

    /**
     * Function returns a graphical representation of a rook.
     *
     * @return a file - graphical representation of a rook.
     */
    @Override
    @NotNull
    @Contract(pure = true)
    public File getImage() {
        throw new UnsupportedOperationException("Not implemented yet because of the lack of resource.");
        // return this.color == PieceColor.WHITE ? whiteRookImage : blackRookImage;
    }
}

/**
 * Representation of a knight.
 */
final class Knight extends Piece {

    /**
     * File with image of white knight.
     */
    private final File whiteKnightImage = new File("path/to/white/knight/image");
    /**
     * File with image of black knight.
     */
    private final File blackKnightImage = new File("path/to/black/knight/image");

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
        String whiteKnightSymbol = "♘";
        String blackKnightSymbol = "♞";
        return this.color == WHITE ? whiteKnightSymbol : blackKnightSymbol;
    }

    /**
     * Function returns a graphical representation of a knight.
     *
     * @return a file - graphical representation of a knight.
     */
    @Override
    @NotNull
    @Contract(pure = true)
    public File getImage() {
        throw new UnsupportedOperationException("Not implemented yet because of the lack of resource.");
        // return this.color == WHITE ? whiteKnightImage : blackKnightImage;
    }
}

/**
 * Representation of a bishop.
 */
final class Bishop extends Piece {

    /**
     * File with image of white bishop.
     */
    private final File whiteBishopImage = new File("path/to/white/bishop/image");
    /**
     * File with image of black bishop.
     */
    private final File blackBishopImage = new File("path/to/black/bishop/image");

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
        String whiteBishopSymbol = "♗";
        String blackBishopSymbol = "♝";
        return this.color == WHITE ? whiteBishopSymbol : blackBishopSymbol;
    }

    /**
     * Function returns a graphical representation of a bishop.
     *
     * @return a file - graphical representation of a bishop.
     */
    @Override
    @NotNull
    @Contract(pure = true)
    public File getImage() {
        throw new UnsupportedOperationException("Not implemented yet because of the lack of resource.");
        // return this.color == WHITE ? whiteBishopImage : blackBishopImage;
    }
}

/**
 * Representation of a queen.
 */
final class Queen extends Piece {

    /**
     * File with image of white queen.
     */
    private final File whiteQueenImage = new File("path/to/white/queen/image");
    /**
     * File with image of black queen.
     */
    private final File blackQueenImage = new File("path/to/black/queen/image");

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
        String whiteQueenSymbol = "♕";
        String blackQueenSymbol = "♛";
        return this.color == WHITE ? whiteQueenSymbol : blackQueenSymbol;
    }

    /**
     * Function returns a graphical representation of a queen.
     *
     * @return a file - graphical representation of a queen.
     */
    @Override
    @NotNull
    @Contract(pure = true)
    public File getImage() {
        throw new UnsupportedOperationException("Not implemented yet because of the lack of resource.");
        // return this.color == WHITE ? whiteQueenImage : blackQueenImage;
    }
}

/**
 * Representation of a king.
 */
final class King extends Piece {

    /**
     * File with image of white king.
     */
    private final File whiteKingImage = new File("path/to/white/king/image");
    /**
     * File with image of black king.
     */
    private final File blackKingImage = new File("path/to/black/king/image");

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
        String whiteKingSymbol = "♔";
        String blackKingSymbol = "♚";
        return this.color == WHITE ? whiteKingSymbol : blackKingSymbol;
    }

    /**
     * Function returns a graphical representation of a king.
     *
     * @return a file - graphical representation of a king.
     */
    @Override
    @NotNull
    @Contract(pure = true)
    public File getImage() {
        throw new UnsupportedOperationException("Not implemented yet because of the lack of resource.");
        // return this.color == WHITE ? whiteKingImage : blackKingImage;
    }
}
