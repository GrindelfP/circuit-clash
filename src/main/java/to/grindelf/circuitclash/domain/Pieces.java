package to.grindelf.circuitclash.domain;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

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
        this.possiblePositions = initialPossiblePositions(type, position, color);
        this.position = position;
    }

    /**
     * Moves the piece according to the given program.
     *
     * @param program list of functions, which represent the movement program.
     * @throws IllegalArgumentException if the movement is impossible (by the game rules).
     */
    public void move(@NotNull List<Function<Movement, Movement>> program) throws IllegalArgumentException {
        MovementMode movementMode = this.color == PieceColor.WHITE ? MovementMode.NORMAL : MovementMode.REVERSED;
        Movement initialMovement = new Movement(position, movementMode);
        if (program.size() == 0) throw new IllegalArgumentException("Program is empty"); // case if the program is empty
        if (program.size() == 1) performMovementProgram(program, initialMovement);
            // case if the program contains only one movement
        else performMovementProgram(program, initialMovement); // case if the program contains multiple movements

        calculatePossiblePositions(); // after completed movements the possible positions are recalculated
    }

    /**
     * Performs the movement program on the piece.
     *
     * @param program         list of functions, which represent the movement program.
     * @param initialMovement initial movement instance of the piece.
     * @throws IllegalArgumentException if the movement is impossible (by the game rules).
     */
    private void performMovementProgram(
            @NotNull List<Function<Movement, Movement>> program,
            Movement initialMovement
    ) throws IllegalArgumentException {
        Movement finalMovement = initialMovement;

        for (Function<Movement, Movement> command : program) {
            finalMovement = command.apply(finalMovement);
            if (movementIsImpossible(finalMovement)) throw new IllegalArgumentException("Movement is not possible");
        }

        this.position = finalMovement.position();
    }

    @NotNull
    protected abstract Collection<Position> possiblePositionsByType();

    protected boolean isEnemyToPieceAt(@NotNull Position position) {
        return this.field.getPieceBy(position).getColor() != this.color;
    }

    /**
     * Checks if the given movement is impossible (by the game rules).
     *
     * @param movement movement to check.
     * @return true if the movement is impossible, false otherwise.
     */
    private boolean movementIsImpossible(@NotNull Movement movement) {
        return !this.possiblePositions.contains(movement.position());
    }

    private void calculatePossiblePositions() {
        possiblePositions.clear();
        possiblePositions.addAll(possiblePositionsByType());
    }

    @NotNull
    private List<Position> initialPossiblePositions(PieceType type, Position initialPosition, PieceColor pieceColor) {
        List<Position> positions = new ArrayList<>();
        positions.add(initialPosition);
        MovementMode movementMode = getMovementModeBy(pieceColor);
        Movement initialPositionMovement = new Movement(initialPosition, movementMode);

        if (type != PieceType.EMPTY) {
            if (type == PieceType.PAWN) {
                positions.add(initialPositionMovement.moveUp().position());
                positions.add(initialPositionMovement.moveUp().moveUp().position());
            } else if (type == PieceType.KNIGHT) {
                positions.add(initialPositionMovement.jumpUpLeft().position());
                positions.add(initialPositionMovement.jumpUpRight().position());
            }
        }

        return positions;
    }

    /**
     * Returns the movement mode by the given piece color.
     * @param pieceColor is the color of the piece (if the color is white, the movement mode is normal,
     *                   if the color is black, the movement mode is reversed).
     * @return the movement mode defined by the piece color.
     */
    @NotNull
    protected MovementMode getMovementModeBy(@NotNull PieceColor pieceColor) {
        return pieceColor == PieceColor.WHITE ? MovementMode.NORMAL : MovementMode.REVERSED;
    }
}

final class King extends Piece {

    public King(PieceColor color, Position position) {
        super(PieceType.KING, color, position);
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

final class Queen extends Piece {

    public Queen(PieceColor color, Position position) {
        super(PieceType.QUEEN, color, position);
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

final class Bishop extends Piece {

    public Bishop(PieceColor color, Position position) {
        super(PieceType.BISHOP, color, position);
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

final class Knight extends Piece {

    public Knight(PieceColor color, Position position) {
        super(PieceType.KNIGHT, color, position);
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

final class Rook extends Piece {

    public Rook(PieceColor color, Position position) {
        super(PieceType.ROOK, color, position);
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

final class Pawn extends Piece {

    public Pawn(PieceColor color, Position position) {
        super(PieceType.PAWN, color, position);
    }

    /**
     * Implements the toString method for the pawn.
     * @return the string representation (♙ or ♟) of the pawn.
     */
    @NotNull
    @Override
    public String toString() {
        return this.color == PieceColor.WHITE ? "♙" : "♟";
    }

    /**
     * Calculates the possible positions of the pawn. Overrides the method of the abstract class Piece.
     * @return the collection of possible positions of the pawn.
     */
    @NotNull
    @Override
    protected Collection<Position> possiblePositionsByType() {
        List<Position> possiblePositions = new ArrayList<>();

        possiblePositions.add(this.position);
        // always adds current movement because pawn can stay in place util it is replaced
        // by an enemy piece (eaten)

        MovementMode movementMode = getMovementModeBy(this.color);
        Movement pawnMovement = new Movement(this.position, movementMode).moveUp();

        Position oneStepPosition = pawnMovement.moveUp().position();

        if (field.isEmptyAt(oneStepPosition)) possiblePositions.add(oneStepPosition);
        // adds the 1-step movement if possible

        if (this.standsOnInitialPosition()) {
            Position twoStepPosition = pawnMovement.moveUp().moveUp().position();
            if (field.isEmptyAt(twoStepPosition)) possiblePositions.add(twoStepPosition);
        }
        // adds the next 2-step movement if pawn stands on its initial movement (2nd row for white, 7th row for black)

        Position leftAttackPosition = pawnMovement.moveUpLeft().position();
        if (field.isOccupiedAt(leftAttackPosition) &&
                this.isEnemyToPieceAt(leftAttackPosition)) possiblePositions.add(leftAttackPosition);
        // adds the left attack movement if possible

        Position rightAttackPosition = pawnMovement.moveUpRight().position();
        if (field.isOccupiedAt(rightAttackPosition) &&
                this.isEnemyToPieceAt(rightAttackPosition)) possiblePositions.add(rightAttackPosition);
        // adds the right attack movement if possible

        return possiblePositions;
    }

    /**
     * Checks if the pawn stands on its initial position (2nd row for white, 7th row for black).
     * @return true if the pawn stands on its initial position, false otherwise.
     */
    private boolean standsOnInitialPosition() {
        return this.position.y() == 1 && this.color == PieceColor.WHITE ||
                this.position.y() == 6 && this.color == PieceColor.BLACK;
    }
}

/**
 * Represents an instance of an empty piece, which simply means
 * that occupied by this piece movement is empty.
 */
final class Empty extends Piece {

    /**
     * Empty piece constructor
     */
    public Empty(Position position) {
        super(PieceType.EMPTY, PieceColor.NONE, position);
    }

    /**
     * Implements the toString method for the empty piece.
     * @return the string representation (□) of the empty piece.
     */
    @NotNull
    @Override
    public String toString() {
        return "□";
    }

    /**
     * Empty piece has no possible moves, except the current position.
     *
     * @return the collection of possible positions of the empty piece containing
     * only the current position.
     */
    @NotNull
    @Override
    protected Collection<Position> possiblePositionsByType() {
        List<Position> positions = new ArrayList<>();
        positions.add(this.position);

        return positions;
    }
}
