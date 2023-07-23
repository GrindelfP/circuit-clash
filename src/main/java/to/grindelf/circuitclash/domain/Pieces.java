package to.grindelf.circuitclash.domain;

import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

abstract class Piece {

    protected PieceType type;
    protected final PieceColor color;
    protected Position position;
    private final List<Position> possiblePositions;

    private Board board;

    public PieceType getType() {
        return type;
    }

    public PieceColor getColor() {
        return color;
    }

    public List<Position> getPossiblePositions() {
        return possiblePositions;
    }

    public Position getPosition() {
        return position;
    }

    public Piece(PieceType type, PieceColor color, List<Position> possiblePositions, Position position) {
        this.type = type;
        this.color = color;
        this.possiblePositions = possiblePositions;
        this.position = position;
    }

    public void makeMove(@NotNull Move move) {
        position = move.getTo();

        calculatePossibleMoves();
    }

    private void calculatePossibleMoves() {
        possiblePositions.clear();
        possiblePositions.addAll(possiblePositionsByType(board));
    }

    protected abstract Collection<Position> possiblePositionsByType(Board board);


    protected boolean isEnemy(@NotNull Piece piece) {
        return piece.getColor() != color;
    }

    protected boolean positionIsEmpty(@NotNull Board board, Position position) {
        return board.getPiece(position).getType() == PieceType.EMPTY;
    }
}

class King extends Piece {

    public King(PieceType type, PieceColor color, List<Position> possibleMoves, Position position) {
        super(type, color, possibleMoves, position);
    }

    @NotNull
    @Override
    protected Collection<Position> possiblePositionsByType(Board board) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

class Queen extends Piece {

    public Queen(PieceType type, PieceColor color, List<Position> possibleMoves, Position position) {
        super(type, color, possibleMoves, position);
    }

    @NotNull
    @Override
    protected Collection<Position> possiblePositionsByType(Board board) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

class Bishop extends Piece {

    public Bishop(PieceType type, PieceColor color, List<Position> possibleMoves, Position position) {
        super(type, color, possibleMoves, position);
    }

    @NotNull
    @Override
    protected Collection<Position> possiblePositionsByType(Board board) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

class Knight extends Piece {

    public Knight(PieceType type, PieceColor color, List<Position> possibleMoves, Position position) {
        super(type, color, possibleMoves, position);
    }

    @NotNull
    @Override
    protected Collection<Position> possiblePositionsByType(Board board) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

class Rook extends Piece {

    public Rook(PieceType type, PieceColor color, List<Position> possibleMoves, Position position) {
        super(type, color, possibleMoves, position);
    }

    @NotNull
    @Override
    protected Collection<Position> possiblePositionsByType(Board board) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

class Pawn extends Piece {

    public Pawn(PieceType type, PieceColor color, List<Position> possibleMoves, Position position) {
        super(type, color, possibleMoves, position);
    }

    @NotNull
    @Override
    protected Collection<Position> possiblePositionsByType(@NotNull Board board) {
        int incrementalFactor = this.color == PieceColor.WHITE ? 1 : -1;
        // white pawns are going incrementing their
        // y coordinate, black pawns are decrementing it
        List<Position> possiblePositions = new ArrayList<>();

        possiblePositions.add(this.position);
        // always adds current position because pawn can stay in place util it is replaced
        // by an enemy piece (eaten) or promoted (turned into queen, rook, bishop or knight
        // when reaching the other side of the board)

        Position nearestMovePosition = new Position(this.position.getX(), this.position.getY() + incrementalFactor);

        if (nearestMovePosition.isOnBoard() && positionIsEmpty(board, nearestMovePosition))
            possiblePositions.add(nearestMovePosition); // adds the next position if possible

        Position twoStepPosition = new Position(this.position.getX(), this.position.getY() + 2 * incrementalFactor);
        if (twoStepPosition.isOnBoard() && positionIsEmpty(board, twoStepPosition))
            possiblePositions.add(twoStepPosition); // adds the next 2-step position if possible

        Position leftAttackPosition = new Position(this.position.getX() - 1, this.position.getY() + incrementalFactor);
        if (leftAttackPosition.isOnBoard() && !positionIsEmpty(board, leftAttackPosition) && isEnemy(board.getPiece(leftAttackPosition)))
            possiblePositions.add(leftAttackPosition); // adds the left attack position if possible

        Position rightAttackPosition = new Position(this.position.getX() + 1, this.position.getY() + incrementalFactor);
        if (rightAttackPosition.isOnBoard() && !positionIsEmpty(board, rightAttackPosition) && isEnemy(board.getPiece(rightAttackPosition)))
            possiblePositions.add(rightAttackPosition); // adds the right attack position if possible

        return possiblePositions;
    }

    void promote(PieceType type) {
        this.type = type;
    }
}

/**
 * Represents an instance of an empty piece, which simply means
 * that occupied by this piece position is empty.
 */
class Empty extends Piece {

    public Empty(PieceType type, PieceColor color, List<Position> possibleMoves, Position position) {
        super(type, color, possibleMoves, position);
    }

    /**
     * Empty piece has no possible moves.
     *
     * @return empty collection
     */
    @NotNull
    @Override
    protected Collection<Position> possiblePositionsByType(Board board) {
        return List.of();
    }
}
