package to.grindelf.circuitclash.utils;

import org.jetbrains.annotations.NotNull;
import to.grindelf.circuitclash.domain.Move;
import to.grindelf.circuitclash.domain.PieceType;
import to.grindelf.circuitclash.errors.RulesViolationException;

/**
 * Interface for validating moves relative to the rules of a chess game.
 */
public interface PieceValidation {

    /**
     * Checks if a move is correct in accordance with the game rules.
     *
     * @param move is a description of a move to be made.
     * @throws RulesViolationException if the move is not correct.
     */
    public abstract void isCorrect(@NotNull Move move, @NotNull PieceType movedPieceType) throws RulesViolationException;
}
