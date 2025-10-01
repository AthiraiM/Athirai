package ui;

import manager.IClassroomManager;

import java.util.Scanner;

public class CommandProcessor {
    private final IClassroomManager manager;
    private final Scanner scanner;

    public CommandProcessor(IClassroomManager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }

    // Main loop
    public void start() {
        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1" -> handleAddClassroom();
                    case "2" -> handleAddStudent();
                    case "3" -> handleScheduleAssignment();
                    case "4" -> handleSubmitAssignment();
                    case "5" -> handleViewSubmissions();
                    case "6" -> manager.listClassrooms();
                    case "7" -> handleListStudents();
                    case "8" -> running = false;
                    default -> System.out.println("Invalid option! Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("Exiting Virtual Classroom Manager. Goodbye!");
    }

    // Menu display
    private void printMenu() {
        System.out.println("\n=== Virtual Classroom Manager ===");
        System.out.println("1. Add Classroom");
        System.out.println("2. Add Student");
        System.out.println("3. Schedule Assignment");
        System.out.println("4. Submit Assignment");
        System.out.println("5. View Submissions");
        System.out.println("6. List Classrooms");
        System.out.println("7. List Students in Classroom");
        System.out.println("8. Exit");
    }

    // Handle adding classroom
    private void handleAddClassroom() {
        System.out.print("Enter classroom name: ");
        String name = scanner.nextLine().trim();
        manager.addClassroom(name);
    }

    // Handle adding student
    private void handleAddStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine().trim();
        manager.listClassrooms(); // Show available classrooms
        System.out.print("Enter classroom name to enroll student: ");
        String className = scanner.nextLine().trim();
        manager.addStudent(id, className);
    }

    // Handle scheduling assignment
    private void handleScheduleAssignment() {
        manager.listClassrooms();
        System.out.print("Enter classroom name to schedule assignment: ");
        String className = scanner.nextLine().trim();
        System.out.print("Enter assignment details: ");
        String details = scanner.nextLine().trim();
        manager.scheduleAssignment(className, details);
    }

    // Handle submitting assignment
    private void handleSubmitAssignment() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine().trim();
        manager.listClassrooms();
        System.out.print("Enter classroom name: ");
        String className = scanner.nextLine().trim();
        System.out.print("Enter assignment details: ");
        String details = scanner.nextLine().trim();
        manager.submitAssignment(id, className, details);
    }

    // Handle viewing assignment submissions
    private void handleViewSubmissions() {
        manager.listClassrooms();
        System.out.print("Enter classroom name: ");
        String className = scanner.nextLine().trim();
        System.out.print("Enter assignment details to view submissions: ");
        String details = scanner.nextLine().trim();
        manager.viewSubmissions(className, details);
    }

    // Handle listing students by classroom
    private void handleListStudents() {
        manager.listClassrooms();
        System.out.print("Enter classroom name to view students: ");
        String className = scanner.nextLine().trim();
        manager.listStudents(className);
    }
}
