package to.grindelf.circuitclash.utils;

import org.jetbrains.annotations.NotNull;
import to.grindelf.circuitclash.domain.Move;
import to.grindelf.circuitclash.errors.WrongMoveException;

/**
 * Interface for validating moves relative to the chessboard.
 */
public interface BoardValidation {

    /**
     * Checks if a move is made within the chessboard.
     * @param move is a description of a move to be made.
     * @throws WrongMoveException if the move is not within the chessboard.
     */
    public abstract void isWithinTheBoard(@NotNull Move move) throws WrongMoveException;
}
