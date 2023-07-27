package to.grindelf.circuitclash.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PieceTest {

    @Test
    void givenPiece_whenEquals_thenEquals() {
        Piece piece1 = new Pawn(PieceColor.WHITE);
        Piece piece2 = new Pawn(PieceColor.WHITE);
        Piece piece3 = new Pawn(PieceColor.BLACK);

        assertThat(piece1).isEqualTo(piece2);
        assertThat(piece1).isNotEqualTo(piece3);
    }
}