package to.grindelf.circuitclash.utils;

/**
 * Exception for wrong chess moves.
 */
public class WrongMoveException extends Exception {

    /**
     * Initializes a wrong chess move exception.
     * @param exceptionMessage is a message to be displayed.
     */
    public WrongMoveException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
