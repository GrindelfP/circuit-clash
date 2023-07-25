
package to.grindelf.circuitclash.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MovementTest {
    private final Movement initialMovementNormal = new Movement(new Position(3, 3), MovementMode.NORMAL);
    private final Movement initialMovementReversed = new Movement(new Position(3, 3), MovementMode.REVERSED);

    @Test
    void moveUp() {
        assertThat(initialMovementNormal.moveUp().position()).isEqualTo(new Position(3, 4));
        assertThat(initialMovementReversed.moveUp().position()).isEqualTo(new Position(3, 2));
    }

    @Test
    void moveDown() {
        assertThat(initialMovementNormal.moveDown().position()).isEqualTo(new Position(3, 2));
        assertThat(initialMovementReversed.moveDown().position()).isEqualTo(new Position(3, 4));
    }

    @Test
    void moveLeft() {
        assertThat(initialMovementNormal.moveLeft().position()).isEqualTo(new Position(2, 3));
        assertThat(initialMovementReversed.moveLeft().position()).isEqualTo(new Position(4, 3));
    }

    @Test
    void moveRight() {
        assertThat(initialMovementNormal.moveRight().position()).isEqualTo(new Position(4, 3));
        assertThat(initialMovementReversed.moveRight().position()).isEqualTo(new Position(2, 3));
    }

    @Test
    void moveUpLeft() {
        assertThat(initialMovementNormal.moveUpLeft().position()).isEqualTo(new Position(2, 4));
        assertThat(initialMovementReversed.moveUpLeft().position()).isEqualTo(new Position(4, 2));
    }

    @Test
    void moveUpRight() {
        assertThat(initialMovementNormal.moveUpRight().position()).isEqualTo(new Position(4, 4));
        assertThat(initialMovementReversed.moveUpRight().position()).isEqualTo(new Position(2, 2));
    }

    @Test
    void moveDownLeft() {
        assertThat(initialMovementNormal.moveDownLeft().position()).isEqualTo(new Position(2, 2));
        assertThat(initialMovementReversed.moveDownLeft().position()).isEqualTo(new Position(4, 4));
    }

    @Test
    void moveDownRight() {
        assertThat(initialMovementNormal.moveDownRight().position()).isEqualTo(new Position(4, 2));
        assertThat(initialMovementReversed.moveDownRight().position()).isEqualTo(new Position(2, 4));
    }

    @Test
    void jumpUpLeft() {
        assertThat(initialMovementNormal.jumpUpLeft().position()).isEqualTo(new Position(2, 5));
        assertThat(initialMovementReversed.jumpUpLeft().position()).isEqualTo(new Position(4, 1));
    }

    @Test
    void jumpUpRight() {
        assertThat(initialMovementNormal.jumpUpRight().position()).isEqualTo(new Position(4, 5));
        assertThat(initialMovementReversed.jumpUpRight().position()).isEqualTo(new Position(2, 1));
    }

    @Test
    void jumpDownLeft() {
        assertThat(initialMovementNormal.jumpDownLeft().position()).isEqualTo(new Position(2, 1));
        assertThat(initialMovementReversed.jumpDownLeft().position()).isEqualTo(new Position(4, 5));
    }

    @Test
    void jumpDownRight() {
        assertThat(initialMovementNormal.jumpDownRight().position()).isEqualTo(new Position(4, 1));
        assertThat(initialMovementReversed.jumpDownRight().position()).isEqualTo(new Position(2, 5));
    }

    @Test
    void jumpLeftUp() {
        assertThat(initialMovementNormal.jumpLeftUp().position()).isEqualTo(new Position(1, 4));
        assertThat(initialMovementReversed.jumpLeftUp().position()).isEqualTo(new Position(5, 2));
    }

    @Test
    void jumpRightUp() {
        assertThat(initialMovementNormal.jumpRightUp().position()).isEqualTo(new Position(5, 4));
        assertThat(initialMovementReversed.jumpRightUp().position()).isEqualTo(new Position(1, 2));
    }

    @Test
    void jumpLeftDown() {
        assertThat(initialMovementNormal.jumpLeftDown().position()).isEqualTo(new Position(1, 2));
        assertThat(initialMovementReversed.jumpLeftDown().position()).isEqualTo(new Position(5, 4));
    }

    @Test
    void jumpRightDown() {
        assertThat(initialMovementNormal.jumpRightDown().position()).isEqualTo(new Position(5, 2));
        assertThat(initialMovementReversed.jumpRightDown().position()).isEqualTo(new Position(1, 4));
    }
}
