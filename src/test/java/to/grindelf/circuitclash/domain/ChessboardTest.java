package to.grindelf.circuitclash.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static to.grindelf.circuitclash.domain.PieceColor.BLACK;
import static to.grindelf.circuitclash.domain.PieceColor.WHITE;

class ChessboardTest {

    private final Chessboard chessboard = new Chessboard();

    @Test
    void givenChessboard_whenInitialized_thenInitializedCorrectly() {
        checkFigures(WHITE);
        checkPawns(WHITE);
        checkEmptyCells();
        checkPawns(BLACK);
        checkFigures(BLACK);

        System.out.println(chessboard);
    }

    private void checkFigures(PieceColor color) {
        int rowNumber = color == WHITE ? 0 : 7;
        assertThat(chessboard.getPieceAt(new Position(0, rowNumber))).isEqualTo(new Rook(color));
        assertThat(chessboard.getPieceAt(new Position(1, rowNumber))).isEqualTo(new Knight(color));
        assertThat(chessboard.getPieceAt(new Position(2, rowNumber))).isEqualTo(new Bishop(color));
        assertThat(chessboard.getPieceAt(new Position(3, rowNumber))).isEqualTo(new Queen(color));
        assertThat(chessboard.getPieceAt(new Position(4, rowNumber))).isEqualTo(new King(color));
        assertThat(chessboard.getPieceAt(new Position(5, rowNumber))).isEqualTo(new Bishop(color));
        assertThat(chessboard.getPieceAt(new Position(6, rowNumber))).isEqualTo(new Knight(color));
        assertThat(chessboard.getPieceAt(new Position(7, rowNumber))).isEqualTo(new Rook(color));
    }

    private void checkPawns(PieceColor color) {
        int rowNumber = color == WHITE ? 1 : 6;
        for (int i = 0; i < 8; i++) {
            assertThat(chessboard.getPieceAt(new Position(i, rowNumber))).isEqualTo(new Pawn(color));
        }
    }

    private void checkEmptyCells() {
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                assertThat(chessboard.getPieceAt(new Position(j, i))).isNull();
            }
        }
    }
}