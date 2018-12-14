package by.training.nc.sd3.backend.Service;

import by.training.nc.sd3.backend.Entities.Attendancy;
import by.training.nc.sd3.backend.Entities.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface TeacherService {
    Iterable<Teacher> getAllTeachers();
    Optional<Teacher> getTeacherbyId(int id);
    Teacher saveTeacher(Teacher account);
    void deleteTeacher(int id);
    Attendancy setAttendancy(Attendancy attendancy);
    Iterable<Attendancy> getAttendancyById(int id);
}
