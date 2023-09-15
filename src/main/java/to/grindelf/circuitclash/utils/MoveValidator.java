package to.grindelf.circuitclash.utils;

import org.jetbrains.annotations.NotNull;
import to.grindelf.circuitclash.domain.Move;
import to.grindelf.circuitclash.domain.PieceType;
import to.grindelf.circuitclash.errors.RulesViolationException;
import to.grindelf.circuitclash.errors.WrongMoveException;

public class MoveValidator implements PieceValidation, BoardValidation {

    /**
     * Checks if a move is made within the chessboard.
     *
     * @param move is a description of a move to be made.
     * @throws WrongMoveException if the move is not within the chessboard.
     */
    @Override
    public void isWithinTheBoard(@NotNull Move move) throws WrongMoveException {
        if (move.from().getNumerical().x() < 0 || move.from().getNumerical().x() > 7
                || move.from().getNumerical().y() < 0 || move.from().getNumerical().y() > 7) {
            throw new WrongMoveException("Move is started not within the chessboard.");
        } else if (move.to().getNumerical().x() < 0 || move.to().getNumerical().x() > 7
                || move.to().getNumerical().y() < 0 || move.to().getNumerical().y() > 7) {
            throw new WrongMoveException("Move is ended not within the chessboard.");
        }
    }

    /**
     * Checks if a move is correct in accordance with the game rules.
     *
     * @param move is a description of a move to be made.
     * @throws RulesViolationException if the move is not correct.
     */
    @Override
    public void isCorrect(@NotNull Move move, @NotNull PieceType movedPieceType) throws RulesViolationException {
        RulesGuardian rulesGuardian = new RulesGuardian(movedPieceType, move.from(), move.to());

        if (!rulesGuardian.moveIsCorrect()) {
            throw new RulesViolationException("Move is not correct in accordance with the game rules.");
        }
    }
}
