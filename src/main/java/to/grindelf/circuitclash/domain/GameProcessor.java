package to.grindelf.circuitclash.domain;

import to.grindelf.circuitclash.domain.Move;
import to.grindelf.circuitclash.domain.Player;

class GameProcessor implements Player {

    /**
     * The chessboard on which the game is played.
     */
    private Chessboard chessboard;
    /**
     * The log of the game.
     */
    private GameLog gameLog;

    /**
     * Moves a piece on the chessboard.
     *
     * @param move is a description of a move to be made.
     */
    @Override
    public void move(Move move) {

    }
}
