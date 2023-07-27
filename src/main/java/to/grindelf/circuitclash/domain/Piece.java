package to.grindelf.circuitclash.domain;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.File;

abstract class Piece {

    protected final PieceType type;
    protected final PieceColor color;

    public Piece(PieceType type, PieceColor color) {
        this.type = type;
        this.color = color;
    }

    public abstract File getImage();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Piece piece = (Piece) o;

        if (type != piece.type) return false;
        return color == piece.color;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (color != null ? color.hashCode() : 0);

        return result;
    }
}

final class Pawn extends Piece {

    private final File whitePawnImage = new File("path/to/white/pawn/image");
    private final File blackPawnImage = new File("path/to/black/pawn/image");

    public Pawn(PieceColor color) {
        super(PieceType.PAWN, color);
    }

    @Override
    @NotNull
    @Contract(pure = true)
    public String toString() {
        String whitePawnSymbol = "♙";
        String blackPawnSymbol = "♟";
        return this.color == PieceColor.WHITE ? whitePawnSymbol : blackPawnSymbol;
    }

    @Override
    @NotNull
    @Contract(pure = true)
    public File getImage() {
        throw new UnsupportedOperationException("Not implemented yet because of the lack of resource.");
        // return this.color == PieceColor.WHITE ? whitePawnImage : blackPawnImage;
    }
}

final class Rook extends Piece {

    private final File whiteRookImage = new File("path/to/white/rook/image");
    private final File blackRookImage = new File("path/to/black/rook/image");

    public Rook(PieceColor color) {
        super(PieceType.ROOK, color);
    }

    @Override
    @NotNull
    @Contract(pure = true)
    public String toString() {
        String whiteRookSymbol = "♖";
        String blackRookSymbol = "♜";
        return this.color == PieceColor.WHITE ? whiteRookSymbol : blackRookSymbol;
    }

    @Override
    @NotNull
    @Contract(pure = true)
    public File getImage() {
        throw new UnsupportedOperationException("Not implemented yet because of the lack of resource.");
        // return this.color == PieceColor.WHITE ? whiteRookImage : blackRookImage;
    }
}

final class Knight extends Piece {

    private final File whiteKnightImage = new File("path/to/white/knight/image");
    private final File blackKnightImage = new File("path/to/black/knight/image");

    public Knight(PieceColor color) {
        super(PieceType.KNIGHT, color);
    }

    @Override
    @NotNull
    @Contract(pure = true)
    public String toString() {
        String whiteKnightSymbol = "♘";
        String blackKnightSymbol = "♞";
        return this.color == PieceColor.WHITE ? whiteKnightSymbol : blackKnightSymbol;
    }

    @Override
    @NotNull
    @Contract(pure = true)
    public File getImage() {
        throw new UnsupportedOperationException("Not implemented yet because of the lack of resource.");
        // return this.color == PieceColor.WHITE ? whiteKnightImage : blackKnightImage;
    }
}

final class Bishop extends Piece {

    private final File whiteBishopImage = new File("path/to/white/bishop/image");
    private final File blackBishopImage = new File("path/to/black/bishop/image");

    public Bishop(PieceColor color) {
        super(PieceType.BISHOP, color);
    }

    @Override
    @NotNull
    @Contract(pure = true)
    public String toString() {
        String whiteBishopSymbol = "♗";
        String blackBishopSymbol = "♝";
        return this.color == PieceColor.WHITE ? whiteBishopSymbol : blackBishopSymbol;
    }

    @Override
    @NotNull
    @Contract(pure = true)
    public File getImage() {
        throw new UnsupportedOperationException("Not implemented yet because of the lack of resource.");
        // return this.color == PieceColor.WHITE ? whiteBishopImage : blackBishopImage;
    }
}

final class Queen extends Piece {

    private final File whiteQueenImage = new File("path/to/white/queen/image");
    private final File blackQueenImage = new File("path/to/black/queen/image");

    public Queen(PieceColor color) {
        super(PieceType.QUEEN, color);
    }

    @Override
    @NotNull
    @Contract(pure = true)
    public String toString() {
        String whiteQueenSymbol = "♕";
        String blackQueenSymbol = "♛";
        return this.color == PieceColor.WHITE ? whiteQueenSymbol : blackQueenSymbol;
    }

    @Override
    @NotNull
    @Contract(pure = true)
    public File getImage() {
        throw new UnsupportedOperationException("Not implemented yet because of the lack of resource.");
        // return this.color == PieceColor.WHITE ? whiteQueenImage : blackQueenImage;
    }
}

final class King extends Piece {

    private final File whiteKingImage = new File("path/to/white/king/image");
    private final File blackKingImage = new File("path/to/black/king/image");

    public King(PieceColor color) {
        super(PieceType.KING, color);
    }

    @Override
    @NotNull
    @Contract(pure = true)
    public String toString() {
        String whiteKingSymbol = "♔";
        String blackKingSymbol = "♚";
        return this.color == PieceColor.WHITE ? whiteKingSymbol : blackKingSymbol;
    }

    @Override
    @NotNull
    @Contract(pure = true)
    public File getImage() {
        throw new UnsupportedOperationException("Not implemented yet because of the lack of resource.");
        // return this.color == PieceColor.WHITE ? whiteKingImage : blackKingImage;
    }
}
