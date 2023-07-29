package to.grindelf.circuitclash.domain;

import org.jetbrains.annotations.NotNull;

/**
 * Class for describing a move. A move contains information from where
 * a piece is moved and where it is moved to.
 */
public record Move(Position from, Position to) {

    /**
     * Overrides the toString method and generates a string representation of a move.
     *
     * @return a string representation of a move.
     */
    @NotNull
    @Override
    public String toString() {
        return "from " + from.getAlphanumerical() + " to " + to.getAlphanumerical();
    }
}
