package to.grindelf.circuitclash.domain;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class for storing a game log. A game log contains information about
 * all moves made in a game with the move times.
 */
class GameLog {

    private final List<LogEntry> entries;
    private final File logFile;

    public GameLog() {
        this.entries = new ArrayList<>();
        this.logFile = new File("game_log_" + new Date().toString().replace(' ', '_') + ".log");
    }

    /**
     * Overrides the toString method and generates a string representation of a game log.
     *
     * @return a string representation of a game log.
     */
    @NotNull
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LogEntry logEntry : this.entries) {
            stringBuilder.append(logEntry.toString()).append("\n");
        }

        return stringBuilder.toString();
    }

    /**
     * Updates a game log with a new move and writes the new log entry.
     *
     * @param move       is a description of a move to be made.
     * @param movedPiece is a piece that was moved.
     * @throws IOException if an error occurs while writing to a file.
     */
    public void update(Move move, Piece movedPiece) throws IOException {
        Date timestamp = new Date();

        this.entries.add(new LogEntry(move, movedPiece, timestamp));
        writeToTextFile();
    }

    /**
     * Writes the last log entry to a text file.
     *
     * @throws IOException if an error occurs while writing to a file.
     */
    private void writeToTextFile() throws IOException {
        LogEntry lastLogEntry = this.entries.get(entries.size() - 1);

        if (this.entries.size() == 1) writeLogHeaderToFile();

        lastLogEntry.writeToTextFile(this.logFile);
    }

    /**
     * Writes a header to a log file. A header contains information about
     * the date when the game was played.
     */
    private void writeLogHeaderToFile() {

        try {
            FileWriter fileWriter = new FileWriter(this.logFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("-- Game log for game played on " + LocalDate.now() + ". --\n");
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException exception) {
            System.out.println("Error writing to file.");
        }
    }
}
