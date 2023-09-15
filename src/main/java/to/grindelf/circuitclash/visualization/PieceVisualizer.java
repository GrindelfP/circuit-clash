package to.grindelf.circuitclash.visualization;

import org.jetbrains.annotations.NotNull;
import to.grindelf.circuitclash.domain.PieceColor;
import to.grindelf.circuitclash.domain.PieceType;

import java.io.File;

/**
 * Class for visualizing chess pieces.
 */
public class PieceVisualizer {

    /**
     * Visualizes a chess piece.
     *
     * @param pieceType  type of the piece to be visualized
     * @param pieceColor color of the piece to be visualized
     * @return a string representation of a chess piece.
     */
    @NotNull
    public static String visualizeAsString(@NotNull PieceType pieceType, @NotNull PieceColor pieceColor) {
        return switch (pieceType) {
            case KING -> pieceColor == PieceColor.WHITE ? WHITE_KING : BLACK_KING;
            case QUEEN -> pieceColor == PieceColor.WHITE ? WHITE_QUEEN : BLACK_QUEEN;
            case ROOK -> pieceColor == PieceColor.WHITE ? WHITE_ROOK : BLACK_ROOK;
            case BISHOP -> pieceColor == PieceColor.WHITE ? WHITE_BISHOP : BLACK_BISHOP;
            case KNIGHT -> pieceColor == PieceColor.WHITE ? WHITE_KNIGHT : BLACK_KNIGHT;
            case PAWN -> pieceColor == PieceColor.WHITE ? WHITE_PAWN : BLACK_PAWN;
        };
    }

    /**
     * Visualizes a chess piece as an image.
     *
     * @param pieceType  type of the piece to be visualized
     * @param pieceColor color of the piece to be visualized
     * @return an image that represents the chess piece.
     */
    @NotNull
    public static File visualizeAsImage(@NotNull PieceType pieceType, @NotNull PieceColor pieceColor) {
        return switch (pieceType) {
            case KING -> pieceColor == PieceColor.WHITE ? WHITE_KING_IMAGE : BLACK_KING_IMAGE;
            case QUEEN -> pieceColor == PieceColor.WHITE ? WHITE_QUEEN_IMAGE : BLACK_QUEEN_IMAGE;
            case ROOK -> pieceColor == PieceColor.WHITE ? WHITE_ROOK_IMAGE : BLACK_ROOK_IMAGE;
            case BISHOP -> pieceColor == PieceColor.WHITE ? WHITE_BISHOP_IMAGE : BLACK_BISHOP_IMAGE;
            case KNIGHT -> pieceColor == PieceColor.WHITE ? WHITE_KNIGHT_IMAGE : BLACK_KNIGHT_IMAGE;
            case PAWN -> pieceColor == PieceColor.WHITE ? WHITE_PAWN_IMAGE : BLACK_PAWN_IMAGE;
        };
    }

    private static final String WHITE_KING = "♔";
    private static final String WHITE_QUEEN = "♕";
    private static final String WHITE_ROOK = "♖";
    private static final String WHITE_BISHOP = "♗";
    private static final String WHITE_KNIGHT = "♘";
    private static final String WHITE_PAWN = "♙";
    private static final String BLACK_KING = "♚";
    private static final String BLACK_QUEEN = "♛";
    private static final String BLACK_ROOK = "♜";
    private static final String BLACK_BISHOP = "♝";
    private static final String BLACK_KNIGHT = "♞";
    private static final String BLACK_PAWN = "♟";

    private static final File WHITE_KING_IMAGE = new File("src/main/resources/white_king.png");
    private static final File WHITE_QUEEN_IMAGE = new File("src/main/resources/white_queen.png");
    private static final File WHITE_ROOK_IMAGE = new File("src/main/resources/white_rook.png");
    private static final File WHITE_BISHOP_IMAGE = new File("src/main/resources/white_bishop.png");
    private static final File WHITE_KNIGHT_IMAGE = new File("src/main/resources/white_knight.png");
    private static final File WHITE_PAWN_IMAGE = new File("src/main/resources/white_pawn.png");
    private static final File BLACK_KING_IMAGE = new File("src/main/resources/black_king.png");
    private static final File BLACK_QUEEN_IMAGE = new File("src/main/resources/black_queen.png");
    private static final File BLACK_ROOK_IMAGE = new File("src/main/resources/black_rook.png");
    private static final File BLACK_BISHOP_IMAGE = new File("src/main/resources/black_bishop.png");
    private static final File BLACK_KNIGHT_IMAGE = new File("src/main/resources/black_knight.png");
    private static final File BLACK_PAWN_IMAGE = new File("src/main/resources/black_pawn.png");
}
