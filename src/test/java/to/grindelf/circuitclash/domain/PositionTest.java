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
        assertThat(initialPosition.moveUp()).isEqualTo(new Position(3, 4));
        assertThat(initialPosition.moveUp()).isEqualTo(new Position(3, 2));
    }

    @Test
    void moveDown() {
        assertThat(initialPosition.moveDown()).isEqualTo(new Position(3, 2));
        assertThat(initialPosition.moveDown()).isEqualTo(new Position(3, 4));
    }

    @Test
    void moveLeft() {
        assertThat(initialPosition.moveLeft()).isEqualTo(new Position(2, 3));
        assertThat(initialPosition.moveLeft()).isEqualTo(new Position(4, 3));
    }

    @Test
    void moveRight() {
        assertThat(initialPosition.moveRight()).isEqualTo(new Position(4, 3));
        assertThat(initialPosition.moveRight()).isEqualTo(new Position(2, 3));
    }

    @Test
    void moveUpLeft() {
        assertThat(initialPosition.moveUpLeft()).isEqualTo(new Position(2, 4));
        assertThat(initialPosition.moveUpLeft()).isEqualTo(new Position(4, 2));
    }

    @Test
    void moveUpRight() {
        assertThat(initialPosition.moveUpRight()).isEqualTo(new Position(4, 4));
        assertThat(initialPosition.moveUpRight()).isEqualTo(new Position(2, 2));
    }

    @Test
    void moveDownLeft() {
        assertThat(initialPosition.moveDownLeft()).isEqualTo(new Position(2, 2));
        assertThat(initialPosition.moveDownLeft()).isEqualTo(new Position(4, 4));
    }

    @Test
    void moveDownRight() {
        assertThat(initialPosition.moveDownRight()).isEqualTo(new Position(4, 2));
        assertThat(initialPosition.moveDownRight()).isEqualTo(new Position(2, 4));
    }

    @Test
    void jumpUpLeft() {
        assertThat(initialPosition.jumpUpLeft()).isEqualTo(new Position(2, 5));
        assertThat(initialPosition.jumpUpLeft()).isEqualTo(new Position(4, 1));
    }

    @Test
    void jumpUpRight() {
        assertThat(initialPosition.jumpUpRight()).isEqualTo(new Position(4, 5));
        assertThat(initialPosition.jumpUpRight()).isEqualTo(new Position(2, 1));
    }

    @Test
    void jumpDownLeft() {
        assertThat(initialPosition.jumpDownLeft()).isEqualTo(new Position(2, 1));
        assertThat(initialPosition.jumpDownLeft()).isEqualTo(new Position(4, 5));
    }

    @Test
    void jumpDownRight() {
        assertThat(initialPosition.jumpDownRight()).isEqualTo(new Position(4, 1));
        assertThat(initialPosition.jumpDownRight()).isEqualTo(new Position(2, 5));
    }

    @Test
    void jumpLeftUp() {
        assertThat(initialPosition.jumpLeftUp()).isEqualTo(new Position(1, 4));
        assertThat(initialPosition.jumpLeftUp()).isEqualTo(new Position(5, 2));
    }

    @Test
    void jumpRightUp() {
        assertThat(initialPosition.jumpRightUp()).isEqualTo(new Position(5, 4));
        assertThat(initialPosition.jumpRightUp()).isEqualTo(new Position(1, 2));
    }

    @Test
    void jumpLeftDown() {
        assertThat(initialPosition.jumpLeftDown()).isEqualTo(new Position(1, 2));
        assertThat(initialPosition.jumpLeftDown()).isEqualTo(new Position(5, 4, MovementMode.REVERSED));
    }

    @Test
    void jumpRightDown() {
        assertThat(initialPosition.jumpRightDown()).isEqualTo(new Position(5, 2));
        assertThat(initialPosition.jumpRightDown()).isEqualTo(new Position(1, 4));
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