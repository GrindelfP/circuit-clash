package to.grindelf.circuitclash.domain;

import java.util.HashMap;
import java.util.Map;

import static to.grindelf.circuitclash.domain.PieceColor.BLACK;
import static to.grindelf.circuitclash.domain.PieceColor.WHITE;

class Chessboard {
    private final Map<Position, Piece> state;

    public Chessboard() {
        state = new HashMap<>();
        initializeFiguresRow(WHITE);
        initializePawnRow(WHITE);
        initializePawnRow(BLACK);
        initializeFiguresRow(BLACK);
    }

    public Piece getPieceAt(Position position) {
        return state.get(position);
    }

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

    private void initializePawnRow(PieceColor color) {
        Map<Position, Piece> pawns = new HashMap<>();

        for (int i = 0; i < 8; i++) {
            pawns.put(new Position(i, color == WHITE ? 1 : 6), new Pawn(color));
        }

        state.putAll(pawns);
    }

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
