package by.taining.nc.sd3.Fapi.services;
import by.taining.nc.sd3.Fapi.models.LessonModel;
import by.taining.nc.sd3.Fapi.models.StudentModel;
import by.taining.nc.sd3.Fapi.models.TeacherModel;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
public interface DataStudentService {
    List<StudentModel> getAllStudents();
    StudentModel getStudentbyId(int id);
    StudentModel saveStudent(StudentModel account);
    void deleteStudent(int id);
    List<StudentModel> getStudentsByGroupId(int groupId);
    }
