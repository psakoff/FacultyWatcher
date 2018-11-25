package by.training.nc.sd3.backend.Service;

import by.training.nc.sd3.backend.Entities.Teacher;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface TeacherService {
    Iterable<Teacher> getAllTeachers();
    Optional<Teacher> getTeacherbyId(int id);
    Teacher saveTeacher(Teacher account);
    void deleteTeacher(int id);
}
