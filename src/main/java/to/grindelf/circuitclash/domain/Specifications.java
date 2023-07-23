package to.grindelf.circuitclash.domain;

import org.jetbrains.annotations.NotNull;

enum PieceType {
    KING, QUEEN, BISHOP, KNIGHT, ROOK, PAWN, EMPTY
}

enum PieceColor {
    WHITE, BLACK, NONE
}

class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isOnBoard() {
        return this.getX() >= 0 && this.getX() < 8 && this.getY() >= 0 && this.getY() < 8;
    }
}
