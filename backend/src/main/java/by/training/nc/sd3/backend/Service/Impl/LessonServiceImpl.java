package by.training.nc.sd3.backend.Service.Impl;

import by.training.nc.sd3.backend.Entities.Lesson;

import by.training.nc.sd3.backend.Service.LessonService;
import by.training.nc.sd3.backend.Repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class LessonServiceImpl implements LessonService {
    private LessonRepository lessonRepository;
    @Autowired
    public LessonServiceImpl(LessonRepository lessonRepository) {

        this.lessonRepository = lessonRepository;
    }
    @Override
    public Lesson saveLesson(Lesson account) {
        return lessonRepository.save(account);
    }

    @Override
    public Optional<Lesson> getLessonById(int id) {
        return lessonRepository.findById(id);
    }
    @Override
    public Optional<Lesson> getLessonsByGroup(int groupId) {
        return lessonRepository.findById(groupId);
    }

    @Override
    public Iterable<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    @Override
    public void deleteLesson(int id) {
        lessonRepository.deleteById(id);
    }
}
