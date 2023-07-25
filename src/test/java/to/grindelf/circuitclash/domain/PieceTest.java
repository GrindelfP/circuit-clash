package to.grindelf.circuitclash.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PieceTest {

    @Test
    void givenPawn_whenInitialized_thenPieceIsInitializedCorrectly() {
        Piece piece = new Pawn(PieceType.PAWN, PieceColor.WHITE, new Position(0, 1));

        assertThat(piece.getType()).isEqualTo(PieceType.PAWN);
        assertThat(piece.getColor()).isEqualTo(PieceColor.WHITE);
        assertThat(piece.getPosition()).isEqualTo(new Position(0, 1));
        assertThat(piece.getPossiblePositions()).isEqualTo(
                List.of(
                        new Position(0, 1),
                        new Position(0, 2),
                        new Position(0, 3)
                )
        );
    }

    @Test
    void givenRook_whenInitialized_thenPieceIsInitializedCorrectly() {
        Piece piece = new Rook(PieceType.ROOK, PieceColor.WHITE, new Position(0, 0));

        assertThat(piece.getType()).isEqualTo(PieceType.ROOK);
        assertThat(piece.getColor()).isEqualTo(PieceColor.WHITE);
        assertThat(piece.getPosition()).isEqualTo(new Position(0, 0));
        assertThat(piece.getPossiblePositions()).isEqualTo(List.of(new Position(0, 0)));
    }

    @Test
    void givenKnight_whenInitialized_thenPieceIsInitializedCorrectly() {
        Piece piece = new Knight(PieceType.KNIGHT, PieceColor.WHITE, new Position(1, 0));

        assertThat(piece.getType()).isEqualTo(PieceType.KNIGHT);
        assertThat(piece.getColor()).isEqualTo(PieceColor.WHITE);
        assertThat(piece.getPosition()).isEqualTo(new Position(1, 0));
        assertThat(piece.getPossiblePositions()).isEqualTo(
                List.of(
                        new Position(1, 0),
                        new Position(0, 2),
                        new Position(2, 2)
                )
        );
    }

    @Test
    void givenBishop_whenInitialized_thenPieceIsInitializedCorrectly() {
        Piece piece = new Bishop(PieceType.BISHOP, PieceColor.WHITE, new Position(2, 0));

        assertThat(piece.getType()).isEqualTo(PieceType.BISHOP);
        assertThat(piece.getColor()).isEqualTo(PieceColor.WHITE);
        assertThat(piece.getPosition()).isEqualTo(new Position(2, 0));
        assertThat(piece.getPossiblePositions()).isEqualTo(List.of(new Position(2, 0)));
    }

    @Test
    void givenQueen_whenInitialized_thenPieceIsInitializedCorrectly() {
        Piece piece = new Queen(PieceType.QUEEN, PieceColor.WHITE, new Position(3, 0));

        assertThat(piece.getType()).isEqualTo(PieceType.QUEEN);
        assertThat(piece.getColor()).isEqualTo(PieceColor.WHITE);
        assertThat(piece.getPosition()).isEqualTo(new Position(3, 0));
        assertThat(piece.getPossiblePositions()).isEqualTo(List.of(new Position(3, 0)));
    }

    @Test
    void givenKing_whenInitialized_thenPieceIsInitializedCorrectly() {
        Piece piece = new King(PieceType.KING, PieceColor.WHITE, new Position(4, 0));

        assertThat(piece.getType()).isEqualTo(PieceType.KING);
        assertThat(piece.getColor()).isEqualTo(PieceColor.WHITE);
        assertThat(piece.getPosition()).isEqualTo(new Position(4, 0));
        assertThat(piece.getPossiblePositions()).isEqualTo(List.of(new Position(4, 0)));
    }

    @Test
    void givenEmpty_whenInitialized_thenPieceIsInitializedCorrectly() {
        Piece piece = new Empty(PieceType.EMPTY, PieceColor.NONE, new Position(5, 0));

        assertThat(piece.getType()).isEqualTo(PieceType.EMPTY);
        assertThat(piece.getColor()).isEqualTo(PieceColor.NONE);
        assertThat(piece.getPosition()).isEqualTo(new Position(5, 0));
        assertThat(piece.getPossiblePositions()).isEqualTo(List.of(new Position(5, 0)));
    }

    @Test
    void givenRook_whenMadeMove_thenPieceIsMovedCorrectly() {
        Piece piece = new Rook(PieceType.ROOK, PieceColor.WHITE, new Position(0, 0));

        assertThat(piece.getPosition()).isEqualTo(new Position(0, 0));
        piece.makeMove(new Move(new Position(0, 0), new Position(0, 6)));
        assertThat(piece.getPosition()).isEqualTo(new Position(0, 6));
    }
}