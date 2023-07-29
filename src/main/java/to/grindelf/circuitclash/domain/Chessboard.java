package to.grindelf.circuitclash.domain;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import to.grindelf.circuitclash.utils.WrongMoveException;

import java.util.HashMap;
import java.util.Map;

import static to.grindelf.circuitclash.domain.PieceColor.BLACK;
import static to.grindelf.circuitclash.domain.PieceColor.WHITE;

/**
 * Representation of a chessboard, on which the game is played.
 */
class Chessboard implements BoardStateRearranger {

    /**
     * State of the chessboard, represented as a map of positions (key) and pieces (values).
     */
    private final Map<Position, Piece> state;

    /**
     * Initializes a chessboard with all pieces on their initial positions.
     */
    public Chessboard() {
        state = new HashMap<>();
        initializeFiguresRow(WHITE);
        initializePawnRow(WHITE);
        initializePawnRow(BLACK);
        initializeFiguresRow(BLACK);
    }

    /**
     * Function returns a piece at given position.
     *
     * @param position is a position of a required piece.
     * @return a piece at given position.
     */
    public Piece getPieceAt(Position position) {
        return state.get(position);
    }

    /**
     * Moves a piece on the chessboard.
     *
     * @param move is a description of a move to be made.
     * @return
     */
    @Override
    public Piece movePiece(@NotNull Move move) throws WrongMoveException {
        if (this.state.get(move.from()) == null) throw new WrongMoveException("You can't move a non-existing piece.");
        validateBySituation(move);
        this.state.put(move.to(), this.state.get(move.from()));
        this.state.remove(move.from());

        return this.state.get(move.to());
    }

    @Contract(pure = true)
    private void validateBySituation(@NotNull Move move) throws WrongMoveException {
        if (this.state.get(move.to()) != null && this.state.get(move.to()).color == this.state.get(move.from()).color) {
            throw new WrongMoveException("You can't move your piece on your piece.");
        }
    }


    /**
     * Function initializes a sequence of figures on the chessboard's 1st (for white) and
     * 8th (for black) row.
     *
     * @param color is a color of figures to initialize.
     */
    private void initializeFiguresRow(PieceColor color) {
        Map<Position, Piece> figures = new HashMap<>();
        int rowIndex = color == WHITE ? 0 : 7;

        figures.put(new Position(0, rowIndex), new Rook(color));
        figures.put(new Position(1, rowIndex), new Knight(color));
        figures.put(new Position(2, rowIndex), new Bishop(color));
        figures.put(new Position(3, rowIndex), new Queen(color));
        figures.put(new Position(4, rowIndex), new King(color));
        figures.put(new Position(5, rowIndex), new Bishop(color));
        figures.put(new Position(6, rowIndex), new Knight(color));
        figures.put(new Position(7, rowIndex), new Rook(color));

        state.putAll(figures);
    }

    /**
     * Function initializes a sequence of pawns on the chessboard's 2nd (for white) and
     * 7th (for black) row.
     *
     * @param color is a color of pawns to initialize.
     */
    private void initializePawnRow(PieceColor color) {
        Map<Position, Piece> pawns = new HashMap<>();

        for (int i = 0; i < 8; i++) {
            pawns.put(new Position(i, color == WHITE ? 1 : 6), new Pawn(color));
        }

        state.putAll(pawns);
    }

    /**
     * Overrides toString method to print a chessboard.
     *
     * @return a string representation of a chessboard.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("  +---+---+---+---+---+---+---+---+\n");

        for (int i = 7; i >= 0; i--) {
            stringBuilder.append(i + 1).append(" |");
            for (int j = 0; j < 8; j++) {
                Position position = new Position(j, i);
                Piece piece = state.get(position);
                if (piece == null) {
                    stringBuilder.append("   |");
                } else {
                    stringBuilder.append(" ").append(piece).append(" |");
                }
            }
            stringBuilder.append("\n  +---+---+---+---+---+---+---+---+\n");
        }

        stringBuilder.append("    a   b   c   d   e   f   g   h  ");

        return stringBuilder.toString();
    }
}
