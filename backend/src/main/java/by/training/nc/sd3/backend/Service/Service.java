package by.training.nc.sd3.backend.Service;

import by.training.nc.sd3.backend.Entities.Student;

import java.util.Optional;

public interface Service {

    Student saveStudent(Student account);
    Optional<Student> getStudentById(String id);
    Iterable<Student> getAllStudents();
    void deleteStudent(String id);
}