package to.grindelf.circuitclash.domain;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

abstract class Piece {

    protected PieceType type;
    protected final PieceColor color;
    protected Position position;
    protected final List<Position> possiblePositions;
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
        this.possiblePositions = initialPossiblePositions(type, position);
        this.position = position;
    }

    public void makeMove(@NotNull Move move) {
        position = move.getTo();

        calculatePossiblePositions();
    }

    @NotNull
    protected abstract Collection<Position> possiblePositionsByType();

    protected boolean isEnemyToPieceAt(@NotNull Position position) {
        return this.field.getPieceBy(position).getColor() != this.color;
    }

    private void calculatePossiblePositions() {
        possiblePositions.clear();
        possiblePositions.addAll(possiblePositionsByType());
    }

    @NotNull
    private List<Position> initialPossiblePositions(PieceType type, Position position) {
        List<Position> positions = new ArrayList<>();
        positions.add(position);
        if (type != PieceType.EMPTY) {
            if (type == PieceType.PAWN) {
                positions.add(position.moveUp());
                positions.add(position.moveUp().moveUp());
            } else if (type == PieceType.KNIGHT) {
                positions.add(position.jumpUpLeft());
                positions.add(position.jumpUpRight());
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
        List<Position> possiblePositions = new ArrayList<>();

        possiblePositions.add(this.position);
        // always adds current position because pawn can stay in place util it is replaced
        // by an enemy piece (eaten)

        Position oneStepPosition = this.position.moveUp();

        if (oneStepPosition.isOnBoard() && field.isEmptyAt(oneStepPosition))
            possiblePositions.add(oneStepPosition);
        // adds the 1-step position if possible

        if (this.standsOnInitialPosition()) {
            Position twoStepPosition = this.position.moveUp().moveUp();
            if (field.isEmptyAt(twoStepPosition)) possiblePositions.add(twoStepPosition);
        }
        // adds the next 2-step position if pawn stands on its initial position (2nd row for white, 7th row for black)

        Position leftAttackPosition = this.position.moveUpLeft();
        if (leftAttackPosition.isOnBoard() &&
                !field.isEmptyAt(leftAttackPosition) &&
                this.isEnemyToPieceAt(leftAttackPosition)) possiblePositions.add(leftAttackPosition);
        // adds the left attack position if possible

        Position rightAttackPosition = this.position.moveUpRight();
        if (rightAttackPosition.isOnBoard() &&
                !field.isEmptyAt(rightAttackPosition) &&
                this.isEnemyToPieceAt(rightAttackPosition)) possiblePositions.add(rightAttackPosition);
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
