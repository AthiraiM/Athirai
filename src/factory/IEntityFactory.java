package factory;

import model.Assignment;
import model.Student;

public interface IEntityFactory {
    Student createStudent(String studentId);
    Assignment createAssignment(String details);
}
