package to.grindelf.circuitclash.domain;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of the game field. Contains field gameBoard, which is a list of
 * lists of pieces in the game. The empty cells of the game board are represented
 * by the Empty piece class. Also, the class contains fixed lists of pieces for
 * the initial state of the game and single default constructor, which initializes
 * the game field always in the same way (because the game board is the same
 * always at the start of the game).
 */
final class Field {

    /**
     * The game board is a list of lists of pieces in the game. The empty cells of
     * the game board are represented by the Empty piece class.
     */
    private final List<List<Piece>> gameBoard;

    /**
     * Fixed lists of pieces ordered for the initial state of the game.
     */
    private final List<PieceType> piecesOrdered = new ArrayList<>() {{
        add(PieceType.ROOK);
        add(PieceType.KNIGHT);
        add(PieceType.BISHOP);
        add(PieceType.QUEEN);
        add(PieceType.KING);
        add(PieceType.BISHOP);
        add(PieceType.KNIGHT);
        add(PieceType.ROOK);
    }};

    /**
     * Default constructor, which initializes the game field always in the same way
     * (because the game board is the same always at the start of the game).
     */
    public Field() {
        gameBoard = new ArrayList<>();
        ArrayList<Piece> firstRow = initializeRowOfFigures(PieceColor.WHITE);
        gameBoard.add(firstRow); // add first (white figures) row of the game field

        ArrayList<Piece> secondRow = initializeRowOfPawns(PieceColor.WHITE);
        gameBoard.add(secondRow); // add second (white pawns) row of the game field

        for (int i = 2; i < 6; i++) {
            ArrayList<Piece> emptyRow = initializeEmptyRow();
            gameBoard.add(emptyRow); // add empty rows of the game field
        }

        ArrayList<Piece> seventhRow = initializeRowOfPawns(PieceColor.BLACK);
        gameBoard.add(seventhRow); // add seventh (black pawns) row of the game field

        ArrayList<Piece> eighthRow = initializeRowOfFigures(PieceColor.BLACK);
        gameBoard.add(eighthRow); // add eighth (black figures) row of the game field
    }

    public List<PieceType> getPiecesOrdered() {
        return piecesOrdered;
    }

    /**
     * Returns a specific piece from the board by provided position.
     * @param position is the position of the piece to be returned.
     * @return the piece from the board by provided position.
     */
    @NotNull
    public Piece getPieceBy(@NotNull Position position) {
        return gameBoard.get(position.x()).get(position.y());
    }

    /**
     * Checks if the cell at the provided position is empty.
     * @param position is the position of the cell to be checked.
     * @return true if the cell at the provided position is empty, false otherwise.
     */
    public boolean isEmptyAt(@NotNull Position position) {
        return this.gameBoard.get(position.x()).get(position.y()).getType() == PieceType.EMPTY;
    }

    /**
     * Implements the toString method for the game board.
     * @return the string representation of the game board.
     */
    @NotNull
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (List<Piece> row : gameBoard) {
            for (Piece piece : row) {
                stringBuilder.append(piece.getType().toString().charAt(0));
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    /**
     * Initializes the row of different figures for the initial state of the game.
     * @param pieceColor is the color of the figures to be initialized. Depending on the value
     *                   of this parameter, the figures will be white or black and ordered in the correct way.
     * @return the row of different figures of right color and order for the initial state of the game.
     */
    @NotNull
    private ArrayList<Piece> initializeRowOfFigures(@NotNull PieceColor pieceColor) {
        ArrayList<Piece> rowOfFigures = new ArrayList<>();
        int row = pieceColor == PieceColor.WHITE ? 0 : 7;
        MovementMode movementMode = pieceColor == PieceColor.WHITE ? MovementMode.NORMAL : MovementMode.REVERSED;
        rowOfFigures.add(new Rook(piecesOrdered.get(0), pieceColor, new Position(row, 0, movementMode)));
        rowOfFigures.add(new Knight(piecesOrdered.get(1), pieceColor, new Position(row, 1, movementMode)));
        rowOfFigures.add(new Bishop(piecesOrdered.get(2), pieceColor, new Position(row, 2, movementMode)));
        rowOfFigures.add(new Queen(piecesOrdered.get(3), pieceColor, new Position(row, 3, movementMode)));
        rowOfFigures.add(new King(piecesOrdered.get(4), pieceColor, new Position(row, 4, movementMode)));
        rowOfFigures.add(new Bishop(piecesOrdered.get(5), pieceColor, new Position(row, 5, movementMode)));
        rowOfFigures.add(new Knight(piecesOrdered.get(6), pieceColor, new Position(row, 6, movementMode)));
        rowOfFigures.add(new Rook(piecesOrdered.get(7), pieceColor, new Position(row, 7, movementMode)));

        return rowOfFigures;
    }

    /**
     * Initializes the row of pawns for the initial state of the game.
     * @param pieceColor is the color of the pawns to be initialized.
     * @return the row of pawns for the initial state of the game.
     */
    @NotNull
    private ArrayList<Piece> initializeRowOfPawns(PieceColor pieceColor) {
        ArrayList<Piece> rowOfPawns = new ArrayList<>();
        MovementMode movementMode = pieceColor == PieceColor.WHITE ? MovementMode.NORMAL : MovementMode.REVERSED;
        for (int i = 0; i < 8; i++) {
            rowOfPawns.add(new Pawn(PieceType.PAWN, pieceColor, new Position(1, i, movementMode)));
        }

        return rowOfPawns;
    }

    /**
     * Initializes the empty row for the initial state of the game.
     * @return the empty row for the initial state of the game.
     */
    @NotNull
    private ArrayList<Piece> initializeEmptyRow() {
        ArrayList<Piece> emptyRow = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            emptyRow.add(new Empty(PieceType.EMPTY, PieceColor.NONE, new Position(2, i, MovementMode.NORMAL)));
        }

        return emptyRow;
    }
}
