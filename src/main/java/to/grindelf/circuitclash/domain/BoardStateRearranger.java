package to.grindelf.circuitclash.domain;

import org.jetbrains.annotations.NotNull;
import to.grindelf.circuitclash.utils.WrongMoveException;

/**
 * Interface for playing with pieces.
 */
public interface BoardStateRearranger {

    /**
     * Moves a piece on the chessboard.
     *
     * @param move is a description of a move to be made.
     * @return
     */
    public abstract Piece movePiece(@NotNull Move move) throws WrongMoveException;
}
