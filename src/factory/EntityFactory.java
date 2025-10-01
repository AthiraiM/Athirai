package factory;

import model.Assignment;
import model.Student;

public class EntityFactory implements IEntityFactory {

    @Override
    public Student createStudent(String studentId) {
        return new Student(studentId);
    }

    @Override
    public Assignment createAssignment(String details) {
        return new Assignment(details);
    }
}
