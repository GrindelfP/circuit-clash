package to.grindelf.circuitclash.domain;

import org.jetbrains.annotations.NotNull;
import to.grindelf.circuitclash.utils.MoveValidator;
import to.grindelf.circuitclash.errors.WrongMoveException;

import java.io.IOException;
import java.util.Random;

class GameProcessor {

    /**
     * The chessboard on which the game is played.
     */
    private final Chessboard chessboard;
    /**
     * The log of the game.
     */
    private final GameLog gameLog;

    /**
     * The players of the game.
     */
    private final PlayerInfo[] players;

    /**
     * Initializes a game processor object with default players' names.
     */
    public GameProcessor() {
        this.chessboard = new Chessboard();
        this.gameLog = new GameLog();
        PieceColor[] playerColors = this.initializePlayerColors();
        this.players = new PlayerInfo[]{
                new PlayerInfo(1, "BoardStateRearranger 1", playerColors[0]),
                new PlayerInfo(2, "BoardStateRearranger 2", playerColors[1])
        };
    }

    public Chessboard getChessboard() {
        return chessboard;
    }

    /**
     * Initializes a game processor object with custom players' names.
     */
    public GameProcessor(String firstPlayerName, String secondPlayerName) {
        this.chessboard = new Chessboard();
        this.gameLog = new GameLog();
        PieceColor[] playerColors = this.initializePlayerColors();
        this.players = new PlayerInfo[]{
                new PlayerInfo(1, firstPlayerName, playerColors[0]),
                new PlayerInfo(2, secondPlayerName, playerColors[1])
        };
    }

    /**
     * Initializes a game processor object with custom players' names and custom players' colors.
     */
    public GameProcessor(
            String firstPlayerName,
            String secondPlayerName,
            PieceColor firstPlayerColor,
            PieceColor secondPlayerColor
    ) {
        this.chessboard = new Chessboard();
        this.gameLog = new GameLog();
        this.players = new PlayerInfo[]{
                new PlayerInfo(1, firstPlayerName, firstPlayerColor),
                new PlayerInfo(2, secondPlayerName, secondPlayerColor)
        };
    }


    public void makeMove(@NotNull Move move) throws IOException, WrongMoveException {
        MoveValidator validator = new MoveValidator();

        try {
            validator.isWithinTheBoard(move);
        } catch (WrongMoveException exception) {
            throw new WrongMoveException(exception.getMessage());
        }

        /*try {
            validator.isCorrect(move);
        } catch (RulesViolationException e) {
            throw new RuntimeException(e);
        }*/ // TODO: uncomment this to enable rules validation (not implemented yet)

        Piece movedPiece = this.chessboard.movePiece(move);
        this.gameLog.update(move, movedPiece);
    }

    /**
     * Initializes player colors.
     *
     * @return an array of player colors, where the first element is the color of the first player.
     */
    @NotNull
    private PieceColor[] initializePlayerColors() {
        PieceColor firstPlayerColor = new Random().nextBoolean() ? PieceColor.WHITE : PieceColor.BLACK;
        PieceColor secondPlayerColor = firstPlayerColor == PieceColor.WHITE ? PieceColor.BLACK : PieceColor.WHITE;

        return new PieceColor[]{firstPlayerColor, secondPlayerColor};
    }
}
