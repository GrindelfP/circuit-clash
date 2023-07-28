package to.grindelf.circuitclash.domain;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LogEntryTest {

    @Test
    void testToString() {
        Date timestamp = new Date();
        LogEntry logEntry = new LogEntry(
                new Move(new Position(1, 1),
                        new Position(2, 2)
                ),
                new Pawn(PieceColor.WHITE),
                timestamp);

        assertThat(logEntry.toString()).isEqualTo("Moved white pawn from b2 to c3 at " + timestamp + ".");
        System.out.println(logEntry);
    }
}