package to.grindelf.circuitclash.domain;

/**
 * Interface for playing with pieces.
 */
public interface Player {

    /**
     * Moves a piece on the chessboard.
     * @param move is a description of a move to be made.
     */
    public abstract void move(Move move);
}
