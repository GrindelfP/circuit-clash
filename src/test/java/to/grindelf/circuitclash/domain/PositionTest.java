package to.grindelf.circuitclash.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PositionTest {
    private final Position initialPosition = new Position(3, 3);

    @Test
    void isOnBoard() {
        Position position = new Position(0, 0);
        assertThat(position.isOnBoard()).isTrue();

        Position wrongPosition = new Position(-1, -2);
        assertThat(wrongPosition.isOnBoard()).isFalse();
    }

    @Test
    void moveUp() {
        assertThat(initialPosition.moveUp(PieceColor.WHITE)).isEqualTo(new Position(3, 4));
        assertThat(initialPosition.moveUp(PieceColor.BLACK)).isEqualTo(new Position(3, 2));
    }

    @Test
    void moveDown() {
        assertThat(initialPosition.moveDown(PieceColor.WHITE)).isEqualTo(new Position(3, 2));
        assertThat(initialPosition.moveDown(PieceColor.BLACK)).isEqualTo(new Position(3, 4));
    }

    @Test
    void moveLeft() {
        assertThat(initialPosition.moveLeft(PieceColor.WHITE)).isEqualTo(new Position(2, 3));
        assertThat(initialPosition.moveLeft(PieceColor.BLACK)).isEqualTo(new Position(4, 3));
    }

    @Test
    void moveRight() {
        assertThat(initialPosition.moveRight(PieceColor.WHITE)).isEqualTo(new Position(4, 3));
        assertThat(initialPosition.moveRight(PieceColor.BLACK)).isEqualTo(new Position(2, 3));
    }

    @Test
    void moveUpLeft() {
        assertThat(initialPosition.moveUpLeft(PieceColor.WHITE)).isEqualTo(new Position(2, 4));
        assertThat(initialPosition.moveUpLeft(PieceColor.BLACK)).isEqualTo(new Position(4, 2));
    }

    @Test
    void moveUpRight() {
        assertThat(initialPosition.moveUpRight(PieceColor.WHITE)).isEqualTo(new Position(4, 4));
        assertThat(initialPosition.moveUpRight(PieceColor.BLACK)).isEqualTo(new Position(2, 2));
    }

    @Test
    void moveDownLeft() {
        assertThat(initialPosition.moveDownLeft(PieceColor.WHITE)).isEqualTo(new Position(2, 2));
        assertThat(initialPosition.moveDownLeft(PieceColor.BLACK)).isEqualTo(new Position(4, 4));
    }

    @Test
    void moveDownRight() {
        assertThat(initialPosition.moveDownRight(PieceColor.WHITE)).isEqualTo(new Position(4, 2));
        assertThat(initialPosition.moveDownRight(PieceColor.BLACK)).isEqualTo(new Position(2, 4));
    }

    @Test
    void jumpUpLeft() {
        assertThat(initialPosition.jumpUpLeft(PieceColor.WHITE)).isEqualTo(new Position(2, 5));
        assertThat(initialPosition.jumpUpLeft(PieceColor.BLACK)).isEqualTo(new Position(4, 1));
    }

    @Test
    void jumpUpRight() {
        assertThat(initialPosition.jumpUpRight(PieceColor.WHITE)).isEqualTo(new Position(4, 5));
        assertThat(initialPosition.jumpUpRight(PieceColor.BLACK)).isEqualTo(new Position(2, 1));
    }

    @Test
    void jumpDownLeft() {
        assertThat(initialPosition.jumpDownLeft(PieceColor.WHITE)).isEqualTo(new Position(2, 1));
        assertThat(initialPosition.jumpDownLeft(PieceColor.BLACK)).isEqualTo(new Position(4, 5));
    }

    @Test
    void jumpDownRight() {
        assertThat(initialPosition.jumpDownRight(PieceColor.WHITE)).isEqualTo(new Position(4, 1));
        assertThat(initialPosition.jumpDownRight(PieceColor.BLACK)).isEqualTo(new Position(2, 5));
    }

    @Test
    void jumpLeftUp() {
        assertThat(initialPosition.jumpLeftUp(PieceColor.WHITE)).isEqualTo(new Position(1, 4));
        assertThat(initialPosition.jumpLeftUp(PieceColor.BLACK)).isEqualTo(new Position(5, 2));
    }

    @Test
    void jumpRightUp() {
        assertThat(initialPosition.jumpRightUp(PieceColor.WHITE)).isEqualTo(new Position(5, 4));
        assertThat(initialPosition.jumpRightUp(PieceColor.BLACK)).isEqualTo(new Position(1, 2));
    }

    @Test
    void jumpLeftDown() {
        assertThat(initialPosition.jumpLeftDown(PieceColor.WHITE)).isEqualTo(new Position(1, 2));
        assertThat(initialPosition.jumpLeftDown(PieceColor.BLACK)).isEqualTo(new Position(5, 4));
    }

    @Test
    void jumpRightDown() {
        assertThat(initialPosition.jumpRightDown(PieceColor.WHITE)).isEqualTo(new Position(5, 2));
        assertThat(initialPosition.jumpRightDown(PieceColor.BLACK)).isEqualTo(new Position(1, 4));
    }

    @Test
    void testEquals() {
        assertThat(initialPosition).isEqualTo(new Position(3, 3));
        assertThat(initialPosition).isNotEqualTo(new Position(3, 4));
    }

    @Test
    void x() {
        assertThat(initialPosition.x()).isEqualTo(3);
    }

    @Test
    void y() {
        assertThat(initialPosition.y()).isEqualTo(3);
    }
}