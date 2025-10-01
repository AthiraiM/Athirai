import factory.TaskFactory;
import manager.ScheduleManager;
import model.Task;

import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ScheduleManager manager = ScheduleManager.getInstance();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. Add Task  2. Remove Task  3. View Tasks  4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Description: ");
                    String desc = sc.nextLine();
                    System.out.print("Start Time (HH:MM): ");
                    LocalTime start = LocalTime.parse(sc.nextLine());
                    System.out.print("End Time (HH:MM): ");
                    LocalTime end = LocalTime.parse(sc.nextLine());
                    System.out.print("Priority (1-High,2-Med,3-Low): ");
                    int priority = sc.nextInt();
                    sc.nextLine();

                    Task task = TaskFactory.createTask(desc, start, end, priority);
                    manager.addTask(task);
                }
                case 2 -> {
                    System.out.print("Task Description to Remove: ");
                    String desc = sc.nextLine();
                    manager.removeTask(desc);
                }
                case 3 -> manager.viewTasks();
                case 4 -> {
                    running = false;
                    System.out.println("Exiting...");
                }
                default -> System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}
