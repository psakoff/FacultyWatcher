package by.training.nc.sd3.backend.Service;

import by.training.nc.sd3.backend.Entities.Lesson;

import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public interface LessonService {
    Iterable<Lesson> getAllLessons();
    Optional<Lesson>getLessonById(int Id);
    Optional<Lesson>getLessonsByGroup(int groupId);
    Lesson saveLesson(Lesson account);
    void deleteLesson(int id);
}