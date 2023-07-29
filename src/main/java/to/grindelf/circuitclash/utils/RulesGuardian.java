package to.grindelf.circuitclash.utils;

import kotlin.NotImplementedError;
import to.grindelf.circuitclash.domain.PieceType;
import to.grindelf.circuitclash.domain.Position;

class RulesGuardian {

    private final PieceType pieceType;
    private final Position pieceMovedFrom;
    private final Position pieceMovedTo;

    public RulesGuardian(PieceType pieceType, Position pieceMovedFrom, Position pieceMovedTo) {
        this.pieceType = pieceType;
        this.pieceMovedFrom = pieceMovedFrom;
        this.pieceMovedTo = pieceMovedTo;
    }

    public boolean moveIsCorrect() {
        boolean moveIsCorrect = false;

        if (pieceType == PieceType.PAWN) {
            moveIsCorrect = checkPawnMove();
        } else if (pieceType == PieceType.ROOK) {
            moveIsCorrect = checkRookMove();
        } else if (pieceType == PieceType.KNIGHT) {
            moveIsCorrect = checkKnightMove();
        } else if (pieceType == PieceType.BISHOP) {
            moveIsCorrect = checkBishopMove();
        } else if (pieceType == PieceType.QUEEN) {
            moveIsCorrect = checkQueenMove();
        } else if (pieceType == PieceType.KING) {
            moveIsCorrect = checkKingMove();
        }

        return moveIsCorrect;
    }

    private boolean checkPawnMove() {
        return false;
    }

    private boolean checkRookMove() {
        return false;
    }

    private boolean checkKnightMove() {
        return false;
    }

    private boolean checkBishopMove() {
        return false;
    }

    private boolean checkQueenMove() {
        return false;
    }

    private boolean checkKingMove() {
        return false;
    }

}
