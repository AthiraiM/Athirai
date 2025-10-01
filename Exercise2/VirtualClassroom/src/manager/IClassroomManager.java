package manager;

public interface IClassroomManager {
    void addClassroom(String name);
    void addStudent(String studentId, String className);
    void scheduleAssignment(String className, String details);
    void submitAssignment(String studentId, String className, String details);
    void viewSubmissions(String className, String assignmentDetails);
    void listClassrooms();
    void listStudents(String className);
}
