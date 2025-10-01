package manager;

import factory.IEntityFactory;
import model.Assignment;
import model.Classroom;
import model.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class VirtualClassroomManager implements IClassroomManager {

    private static final Logger LOGGER = Logger.getLogger(VirtualClassroomManager.class.getName());
    private final Map<String, Classroom> classrooms = new HashMap<>();
    private final IEntityFactory factory;

    public VirtualClassroomManager(IEntityFactory factory) {
        this.factory = factory;
    }

    @Override
    public void addClassroom(String name) {
        if (classrooms.containsKey(name)) {
            LOGGER.warning("Classroom already exists: " + name);
            return;
        }
        classrooms.put(name, new Classroom(name));
        System.out.println("Classroom " + name + " has been created.");
    }

    @Override
    public void addStudent(String studentId, String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            LOGGER.warning("Classroom not found: " + className);
            return;
        }
        Student student = factory.createStudent(studentId);
        classroom.addStudent(student);
        System.out.println("Student " + studentId + " has been enrolled in " + className + ".");
    }

    @Override
    public void scheduleAssignment(String className, String details) {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            LOGGER.warning("Classroom not found: " + className);
            return;
        }
        Assignment assignment = factory.createAssignment(details);
        classroom.addAssignment(assignment);
        System.out.println("Assignment for " + className + " has been scheduled.");
    }

    @Override
    public void submitAssignment(String studentId, String className, String details) {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            LOGGER.warning("Classroom not found: " + className);
            return;
        }
        for (Assignment assignment : classroom.getAssignments()) {
            if (assignment.getDetails().equals(details)) {
                assignment.submit(studentId);
                System.out.println("Assignment submitted by Student " + studentId + " in " + className + ".");
                return;
            }
        }
        LOGGER.warning("Assignment not found in classroom: " + className);
    }

    @Override
    public void viewSubmissions(String className, String assignmentDetails) {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            LOGGER.warning("Classroom not found: " + className);
            return;
        }
        for (Assignment assignment : classroom.getAssignments()) {
            if (assignment.getDetails().equals(assignmentDetails)) {
                if (assignment.getSubmissions().isEmpty()) {
                    System.out.println("No submissions found for " + assignmentDetails + " in " + className + ".");
                } else {
                    System.out.println("Students who submitted " + assignmentDetails + " in " + className + ":");
                    for (String studentId : assignment.getSubmissions()) {
                        System.out.println("- " + studentId);
                    }
                }
                return;
            }
        }
        LOGGER.warning("Assignment not found in classroom: " + className);
    }

    @Override
    public void listClassrooms() {
        if (classrooms.isEmpty()) {
            System.out.println("No classrooms available.");
            return;
        }
        System.out.println("Available Classrooms:");
        for (String name : classrooms.keySet()) {
            System.out.println("- " + name);
        }
    }

    @Override
    public void listStudents(String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            System.out.println("Classroom not found: " + className);
            return;
        }

        if (classroom.getStudents().isEmpty()) {
            System.out.println("No students enrolled in classroom: " + className);
            return;
        }

        System.out.println("Students in classroom '" + className + "':");
        for (Student student : classroom.getStudents()) {
            System.out.println("- " + student.getStudentId());
        }
    }
}
