package to.grindelf.circuitclash.domain;

import java.util.ArrayList;
import java.util.List;

class Board {
    private final List<ArrayList<Piece>> board;

    Board(List<ArrayList<Piece>> board) {
        this.board = board;
    }

    public Piece getPiece(Position position) {
        return board.get(position.getX()).get(position.getY());
    }
}
