package model;

import java.time.LocalTime;

public class Task {
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private int priority; // 1 = high, 2 = medium, 3 = low
    private boolean completed;

    public Task(String description, LocalTime startTime, LocalTime endTime, int priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
        this.completed = false;
    }

    // Getters and setters
    public String getDescription() { return description; }
    public LocalTime getStartTime() { return startTime; }
    public LocalTime getEndTime() { return endTime; }
    public int getPriority() { return priority; }
    public boolean isCompleted() { return completed; }
    public void markCompleted() { this.completed = true; }

    @Override
    public String toString() {
        return String.format("[%s - %s | Priority: %d | Completed: %b] %s",
                startTime, endTime, priority, completed, description);
    }
}
