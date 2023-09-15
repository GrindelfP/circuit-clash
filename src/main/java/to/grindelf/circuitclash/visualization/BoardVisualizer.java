package to.grindelf.circuitclash.visualization;

import org.jetbrains.annotations.NotNull;
import to.grindelf.circuitclash.domain.Piece;
import to.grindelf.circuitclash.domain.Position;

import java.util.Map;

/**
 * Class for visualizing chess board as text.
 */
public class BoardVisualizer {

    /**
     * Visualizes a board as a string.
     *
     * @param state is a current state of the board.
     * @return a string that represents the board.
     */
    @NotNull
    public static String visualizeAsString(@NotNull Map<Position, Piece> state) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("  +---+---+---+---+---+---+---+---+\n");

        for (int i = 7; i >= 0; i--) {
            stringBuilder.append(i + 1).append(" |");
            for (int j = 0; j < 8; j++) {
                Position position = new Position(j, i);
                Piece piece = state.get(position);
                if (piece == null) {
                    stringBuilder.append("   |");
                } else {
                    stringBuilder.append(" ").append(piece).append(" |");
                }
            }
            stringBuilder.append("\n  +---+---+---+---+---+---+---+---+\n");
        }

        stringBuilder.append("    a   b   c   d   e   f   g   h  ");

        return stringBuilder.toString();
    }
}
