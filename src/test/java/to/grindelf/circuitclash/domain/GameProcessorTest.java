package to.grindelf.circuitclash.domain;

import org.junit.jupiter.api.Test;
import to.grindelf.circuitclash.utils.WrongMoveException;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class GameProcessorTest {
    private final GameProcessor gameProcessor = new GameProcessor();
    private final Move moveOne = new Move(new Position(1, 1), new Position(1, 3));
    private final Move moveTwo = new Move(new Position(6, 6), new Position(6, 5));
    private final Move moveThree = new Move(new Position(2, 0), new Position(0, 2));
    private final Move wrongMove = new Move(new Position(3, 0), new Position(3, 1));

    @Test
    void givenGameProcessor_andMoves_whenMovesPerformed_thenMovesPerformedCorrectly() throws WrongMoveException, IOException {

        System.out.println(gameProcessor.getChessboard());

        gameProcessor.makeMove(moveOne);
        assertThat(gameProcessor.getChessboard().getPieceAt(new Position(1, 3))).isEqualTo(new Pawn(PieceColor.WHITE));
        System.out.println(gameProcessor.getChessboard());

        gameProcessor.makeMove(moveTwo);
        assertThat(gameProcessor.getChessboard().getPieceAt(new Position(6, 5))).isEqualTo(new Pawn(PieceColor.BLACK));
        System.out.println(gameProcessor.getChessboard());

        gameProcessor.makeMove(moveThree);
        assertThat(gameProcessor.getChessboard().getPieceAt(new Position(0, 2))).isEqualTo(new Bishop(PieceColor.WHITE));
        System.out.println(gameProcessor.getChessboard());
    }

    @Test
    void givenGameProcessor_andWrongMove_whenWrongMovePerformed_thenExceptionIsThrown() {
        assertThatExceptionOfType(WrongMoveException.class)
                .isThrownBy(() -> gameProcessor.makeMove(wrongMove))
                .withMessage("You can't move your piece on your piece.");
    }
}