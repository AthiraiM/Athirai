package observer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static void main(String[] args) {

        TaskManager manager = new TaskManager();

        // ---- Add Observers (users who will get notifications) ----
        manager.addObserver(new User("Alice"));
        manager.addObserver(new User("Bob"));

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("=== Task Scheduler ===");
            System.out.println("Enter tasks to schedule. Type 'exit' to finish.\n");
            while (true) {
                System.out.print("Task title (or 'exit'): ");
                String title = sc.nextLine().trim();
                if (title.equalsIgnoreCase("exit")) break;

                try {
                    System.out.print("Start time (yyyy-MM-dd HH:mm): ");
                    String startStr = sc.nextLine().trim();
                    System.out.print("End time   (yyyy-MM-dd HH:mm): ");
                    String endStr   = sc.nextLine().trim();

                    LocalDateTime start = LocalDateTime.parse(startStr, FORMATTER);
                    LocalDateTime end   = LocalDateTime.parse(endStr,   FORMATTER);

                    if (end.isBefore(start) || end.equals(start)) {
                        System.out.println("❗ End time must be after start time.\n");
                        continue;
                    }

                    Task task = new Task(title, start, end);
                    manager.addTask(task);
                    System.out.println("✔ Task '" + title + "' added.\n");

                } catch (Exception e) {
                    System.out.println("❗ Invalid date format. Try again.\n");
                }
            }
        }

        System.out.println("\nGoodbye!");
    }
}
