package model;

import java.util.*;

public class Classroom {
    private final String name;
    private final Map<String, Student> students = new HashMap<>();
    private final List<Assignment> assignments = new ArrayList<>();

    public Classroom(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Classroom name cannot be empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student student) {
        students.put(student.getStudentId(), student);
    }

    public Collection<Student> getStudents() {
        return students.values();
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }
}
