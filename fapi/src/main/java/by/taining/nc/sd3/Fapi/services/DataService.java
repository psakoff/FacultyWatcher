package by.taining.nc.sd3.Fapi.services;
import by.taining.nc.sd3.Fapi.models.Student;
import by.taining.nc.sd3.Fapi.models.StudentModel;
import org.springframework.http.ResponseEntity;
import java.util.List;
public interface DataService {
    List<StudentModel> getAll();
    StudentModel getStudentbyId(int id);
    void saveStudent(Student account);
    void deleteStudent(int id);
}
