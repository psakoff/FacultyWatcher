package by.taining.nc.sd3.Fapi.services;
import by.taining.nc.sd3.Fapi.models.LessonModel;
import by.taining.nc.sd3.Fapi.models.StudentModel;
import by.taining.nc.sd3.Fapi.models.TeacherModel;
import org.springframework.http.ResponseEntity;
import java.util.List;
public interface DataLessonService {
    List<LessonModel> getAllLessons();
    LessonModel getLessonbyId(int id);
    List<LessonModel> getLessonsByGroup(int groupId);
    LessonModel saveLesson(LessonModel account);
    void deleteLesson(int id);
}