package to.grindelf.circuitclash.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    void givenPosition_whenGetNumerical_thenReturnNumerical() {
        Position position = new Position(1, 2);

        assertThat(position.getNumerical().x()).isEqualTo(1);
        assertThat(position.getNumerical().y()).isEqualTo(2);
    }

    @Test
    void givenPosition_whenGetAlphaNumerical_thenReturnAlphaNumerical() {
        Position position1 = new Position(0, 0);
        Position position2 = new Position(1, 2);
        Position position3 = new Position(7, 7);

        assertThat(position1.getAlphanumerical()).isEqualTo("a1");
        assertThat(position2.getAlphanumerical()).isEqualTo("b3");
        assertThat(position3.getAlphanumerical()).isEqualTo("h8");
    }

}