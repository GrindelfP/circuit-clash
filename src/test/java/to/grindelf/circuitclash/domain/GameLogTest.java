package to.grindelf.circuitclash.domain;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class GameLogTest {

    @Test
    void givenGameLog_whenInitialized_thenInitializedCorrectly() throws IOException {
        GameLog gameLog = new GameLog();

        gameLog.update(new Move(
                        new Position(1, 1),
                        new Position(2, 2)
                ),
                new Pawn(PieceColor.WHITE)
        );

        stop(1);

        gameLog.update(new Move(
                        new Position(3, 1),
                        new Position(3, 5)
                ),
                new Rook(PieceColor.BLACK)
        );

        stop(3);

        gameLog.update(new Move(
                        new Position(1, 1),
                        new Position(4, 4)
                ),
                new Bishop(PieceColor.WHITE)
        );

        System.out.println(gameLog);
    }

    private void stop(long time) {
        try {
            Thread.sleep(time * 100);
        } catch (InterruptedException exception) {
            System.out.println("Sleep was interrupted");
        }
    }
}