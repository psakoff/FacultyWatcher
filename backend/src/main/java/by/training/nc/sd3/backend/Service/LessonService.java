package by.training.nc.sd3.backend.Service;

import by.training.nc.sd3.backend.Entities.Lesson;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface LessonService {
    Iterable<Lesson> getAllLessons();
    Optional<Lesson>getLessonById(int Id);
    Iterable<Lesson> getLessonsByGroup(int groupId);
    Iterable<Lesson> getLessonsByName(String Name);
    Lesson saveLesson(Lesson account);
    void deleteLesson(int id);
}