package to.grindelf.circuitclash.domain;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static to.grindelf.circuitclash.domain.PieceColor.WHITE;

/**
 * Representation of a log record. A log record contains information about
 * a move made in a game with the move time and about a piece that was moved.
 * @param move is a description of a move to be made.
 * @param movedPiece is a piece that was moved.
 * @param timestamp is a time when the move was made.
 */
record LogEntry(Move move, Piece movedPiece, Date timestamp) {

    /**
     * Overrides the toString method and generates a string representation of a log record.
     * @return a string representation of a log record.
     */
    @NotNull
    @Override
    public String toString() {
        String movedPieceColor = movedPiece.color == WHITE ? "white" : "black";
        return "Moved " + movedPieceColor + " " + movedPiece.type.toString().toLowerCase() + " " +
                move.toString() + " at " + LocalTime.now().truncatedTo(ChronoUnit.SECONDS) + ".\n";
    }

    /**
     * Writes a log record to a text file.
     * @param file is a file to write to.
     */
    public void writeToTextFile(File file) throws IOException {

        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(this.toString());
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException exception) {
            throw new IOException("Error writing to file.");
        }
    }
}
