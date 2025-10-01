package observer;

import java.time.LocalDateTime;

public class Task {
    private final String title;
    private final LocalDateTime start;
    private final LocalDateTime end;

    public Task(String title, LocalDateTime start, LocalDateTime end) {
        this.title = title;
        this.start = start;
        this.end = end;
    }

    public boolean conflictsWith(Task other) {
        // Overlap if start is before other's end AND end is after other's start
        return start.isBefore(other.end) && end.isAfter(other.start);
    }

    public String getTitle() {
        return title;
    }
}
