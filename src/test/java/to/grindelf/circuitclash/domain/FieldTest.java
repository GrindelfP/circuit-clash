package to.grindelf.circuitclash.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FieldTest {

    @Test
    void givenField_whenInitialized_thenFieldIsShownCorrectly() {

        Field field = new Field();
        System.out.println(field);
    }

    @Test
    void givenField_whenInitialized_thenFieldIsInitializedCorrectly() {

        Field field = new Field();

        for (int i = 0; i < 8; i++) {
            assertThat(field.getPieceBy(new Position(0, i)).getType()).isEqualTo(field.getPiecesOrdered().get(i));
            assertThat(field.getPieceBy(new Position(0, i)).getColor()).isEqualTo(PieceColor.WHITE);
        } // checking the first row

        for (int i = 0; i < 8; i++) {
            assertThat(field.getPieceBy(new Position(1, i)).getType()).isEqualTo(PieceType.PAWN);
            assertThat(field.getPieceBy(new Position(1, i)).getColor()).isEqualTo(PieceColor.WHITE);
        } // checking the second row

        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                assertThat(field.getPieceBy(new Position(i, j)).getType()).isEqualTo(PieceType.EMPTY);
                assertThat(field.getPieceBy(new Position(i, j)).getColor()).isEqualTo(PieceColor.NONE);
            }
        } // checking the empty rows

        for (int i = 0; i < 8; i++) {
            assertThat(field.getPieceBy(new Position(6, i)).getType()).isEqualTo(PieceType.PAWN);
            assertThat(field.getPieceBy(new Position(6, i)).getColor()).isEqualTo(PieceColor.BLACK);
        } // checking the seventh row

        for (int i = 0; i < 8; i++) {
            assertThat(field.getPieceBy(new Position(7, i)).getType()).isEqualTo(field.getPiecesOrdered().get(i));
            assertThat(field.getPieceBy(new Position(7, i)).getColor()).isEqualTo(PieceColor.BLACK);
        } // checking the eighth row
    }
}