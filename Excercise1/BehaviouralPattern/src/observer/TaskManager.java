package observer;

import java.util.ArrayList;
import java.util.List;

public class TaskManager implements Subject {
    private final List<Task> tasks = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }

    public void addTask(Task task) {
        for (Task existing : tasks) {
            if (task.conflictsWith(existing)) {
                notifyObservers("⚠️ Conflict: New task '" + task.getTitle()
                        + "' overlaps with '" + existing.getTitle() + "'");
                break; // notify once
            }
        }
        tasks.add(task);
    }
}
