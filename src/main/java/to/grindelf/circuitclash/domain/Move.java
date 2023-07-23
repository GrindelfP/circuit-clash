package to.grindelf.circuitclash.domain;

public class Move {
    private final Position from;
    private final Position to;

    public Move(Position from, Position to) {
        this.from = from;
        this.to = to;
    }

    public Position getTo() {
        return to;
    }
}
