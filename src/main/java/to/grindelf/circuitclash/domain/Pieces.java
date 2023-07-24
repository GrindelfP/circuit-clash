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
    protected Field field;

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

    public Piece(PieceType type, PieceColor color, Position position) {
        this.type = type;
        this.color = color;
        this.possiblePositions = initialPossiblePositions(type, position, color);
        this.position = position;
    }

    public void makeMove(@NotNull Move move) {
        position = move.getTo();

        calculatePossiblePositions();
    }

    @NotNull
    protected abstract Collection<Position> possiblePositionsByType();

    protected boolean isEnemyTo(@NotNull Piece piece) {
        return piece.getColor() != color;
    }

    protected boolean positionIsEmpty(Position position) {
        return field.getPieceBy(position).getType() == PieceType.EMPTY;
    }

    private void calculatePossiblePositions() {
        possiblePositions.clear();
        possiblePositions.addAll(possiblePositionsByType());
    }

    @NotNull
    private List<Position> initialPossiblePositions(PieceType type, Position position, PieceColor color) {
        List<Position> positions = new ArrayList<>();
        positions.add(position);
        if (type != PieceType.EMPTY) {
            if (type == PieceType.PAWN) {
                positions.add(position.moveUp(color));
                positions.add(position.moveUp(color).moveUp(color));
            } else if (type == PieceType.KNIGHT) {
                positions.add(position.jumpUpLeft(color));
                positions.add(position.jumpUpRight(color));
            }
        }

        return positions;
    }
}

class King extends Piece {

    public King(PieceType type, PieceColor color, Position position) {
        super(type, color, position);
    }

    @NotNull
    @Override
    public String toString() {
        return this.color == PieceColor.WHITE ? "♔" : "♚";
    }

    @NotNull
    @Override
    protected Collection<Position> possiblePositionsByType() {
        return new ArrayList<>(); // TODO: implement
    }
}

class Queen extends Piece {

    public Queen(PieceType type, PieceColor color, Position position) {
        super(type, color, position);
    }

    @NotNull
    @Override
    public String toString() {
        return this.color == PieceColor.WHITE ? "♕" : "♛";
    }

    @NotNull
    @Override
    protected Collection<Position> possiblePositionsByType() {
        return new ArrayList<>(); // TODO: implement
    }
}

class Bishop extends Piece {

    public Bishop(PieceType type, PieceColor color, Position position) {
        super(type, color, position);
    }

    @NotNull
    @Override
    public String toString() {
        return this.color == PieceColor.WHITE ? "♗" : "♝";
    }

    @NotNull
    @Override
    protected Collection<Position> possiblePositionsByType() {
        return new ArrayList<>(); // TODO: implement
    }
}

class Knight extends Piece {

    public Knight(PieceType type, PieceColor color, Position position) {
        super(type, color, position);
    }

    @NotNull
    @Override
    public String toString() {
        return this.color == PieceColor.WHITE ? "♘" : "♞";
    }

    @NotNull
    @Override
    protected Collection<Position> possiblePositionsByType() {
        return new ArrayList<>(); // TODO: implement
    }
}

class Rook extends Piece {

    public Rook(PieceType type, PieceColor color, Position position) {
        super(type, color, position);
    }

    @NotNull
    @Override
    public String toString() {
        return this.color == PieceColor.WHITE ? "♖" : "♜";
    }

    @NotNull
    @Override
    protected Collection<Position> possiblePositionsByType() {
        return new ArrayList<>(); // TODO: implement
    }
}

class Pawn extends Piece {

    public Pawn(PieceType type, PieceColor color, Position position) {
        super(type, color, position);
    }

    @NotNull
    @Override
    public String toString() {
        return this.color == PieceColor.WHITE ? "♙" : "♟";
    }

    @NotNull
    @Override
    protected Collection<Position> possiblePositionsByType() {
        int incrementalFactor = this.color == PieceColor.WHITE ? 1 : -1;
        // white pawns are going incrementing their
        // y coordinate, black pawns are decrementing it
        List<Position> possiblePositions = new ArrayList<>();

        possiblePositions.add(this.position);
        // always adds current position because pawn can stay in place util it is replaced
        // by an enemy piece (eaten)

        Position nearestMovePosition = new Position(this.position.x(), this.position.y() + incrementalFactor);

        if (nearestMovePosition.isOnBoard() && positionIsEmpty(nearestMovePosition))
            possiblePositions.add(nearestMovePosition);
        // adds the next position if possible

        if (standsOnInitialPosition()) {
            Position twoStepPosition = new Position(this.position.x(), this.position.y() + 2 * incrementalFactor);
            if (positionIsEmpty(twoStepPosition)) possiblePositions.add(twoStepPosition);
        }
        // adds the next 2-step position if pawn stands on its initial position (1 for white, 6 for black)

        Position leftAttackPosition = new Position(this.position.x() - 1, this.position.y() + incrementalFactor);
        if (leftAttackPosition.isOnBoard() &&
                !positionIsEmpty(leftAttackPosition) &&
                isEnemyTo(field.getPieceBy(leftAttackPosition))) possiblePositions.add(leftAttackPosition);
        // adds the left attack position if possible

        Position rightAttackPosition = new Position(this.position.x() + 1, this.position.y() + incrementalFactor);
        if (rightAttackPosition.isOnBoard() &&
                !positionIsEmpty(rightAttackPosition) &&
                isEnemyTo(field.getPieceBy(rightAttackPosition)))
            possiblePositions.add(rightAttackPosition);
        // adds the right attack position if possible

        return possiblePositions;
    }

    private boolean standsOnInitialPosition() {
        return this.position.y() == 1 && this.color == PieceColor.WHITE ||
                this.position.y() == 6 && this.color == PieceColor.BLACK;
    }
}

/**
 * Represents an instance of an empty piece, which simply means
 * that occupied by this piece position is empty.
 */
class Empty extends Piece {

    /**
     * Empty piece constructor
     */
    public Empty(PieceType type, PieceColor color, Position position) {
        super(type, color, position);
    }

    @NotNull
    @Override
    public String toString() {
        return "□";
    }

    /**
     * Empty piece has no possible moves.
     *
     * @return empty collection
     */
    @NotNull
    @Override
    protected Collection<Position> possiblePositionsByType() {
        List<Position> positions = new ArrayList<>();
        positions.add(this.position);
        return positions;
    }
}
