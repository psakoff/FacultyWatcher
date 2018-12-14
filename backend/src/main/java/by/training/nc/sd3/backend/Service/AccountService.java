package by.training.nc.sd3.backend.Service;

import by.training.nc.sd3.backend.Entities.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface AccountService {

    Student saveStudent(Student account);
    Optional<Student> getStudentById(int id);
    Iterable<Student> getAllStudents();
    void deleteStudent(int id);
    Admin getAdmin();
    List<Student> getStudentsbyGroupId(int groupId);
}