package manager;

import model.Task;
import util.LoggerUtil;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ScheduleManager {
    private static ScheduleManager instance = null;
    private final List<Task> tasks;

    private ScheduleManager() {
        tasks = new ArrayList<>();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addTask(Task task) {
        // Validate no overlap
        for (Task t : tasks) {
            if ((task.getStartTime().isBefore(t.getEndTime()) && task.getStartTime().isAfter(t.getStartTime()))
                    || (task.getEndTime().isAfter(t.getStartTime()) && task.getEndTime().isBefore(t.getEndTime()))) {
                LoggerUtil.log("Error: Task overlaps with existing task: " + t);
                return;
            }
        }
        tasks.add(task);
        LoggerUtil.log("Task added: " + task);
    }

    public void removeTask(String description) {
        tasks.removeIf(t -> t.getDescription().equalsIgnoreCase(description));
        LoggerUtil.log("Task removed: " + description);
    }

    public void viewTasks() {
        tasks.stream()
                .sorted(Comparator.comparing(Task::getStartTime))
                .forEach(System.out::println);
    }
}
