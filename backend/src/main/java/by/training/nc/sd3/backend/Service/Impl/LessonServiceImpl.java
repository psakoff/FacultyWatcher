package by.training.nc.sd3.backend.Service.Impl;

import by.training.nc.sd3.backend.Entities.Lesson;

import by.training.nc.sd3.backend.Service.LessonService;
import by.training.nc.sd3.backend.Repository.LessonRepository;
import org.apache.logging.log4j.util.PropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

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
    public List<Lesson> getLessonsByGroup(int groupId) {
        Iterable<Lesson> lessons = lessonRepository.getAllByGroupId(groupId);
        List<Lesson> currGroup= new ArrayList<>();
        List<Lesson> sortedByTime;
        lessons.forEach(lesson ->{currGroup.add(lesson);});
        sortedByTime = currGroup;
        sortedByTime.sort(Comparator.comparingInt(Lesson::getTime));
        return sortedByTime;
    }
    @Override
    public List<Lesson> getLessonsByName(String name) {
        Iterable<Lesson> lessons = lessonRepository.getAllBySpeciality(name);
        List<Lesson> currName= new ArrayList<>();
        List<Lesson> sortedByTime;
        lessons.forEach(lesson ->{currName.add(lesson);});
        sortedByTime = currName;
        sortedByTime.sort(Comparator.comparingInt(Lesson::getTime));
        return sortedByTime;
    }

    @Override
    public Iterable<Lesson> getAllLessons() {
        Iterable<Lesson> lessons = lessonRepository.findAll();
        List<Lesson> sortedByTime= new ArrayList<>();
        lessons.forEach(lesson ->{sortedByTime.add(lesson);});
        sortedByTime.sort(Comparator.comparingInt(Lesson::getTime));
        return sortedByTime;
    }

    @Override
    public void deleteLesson(int id) {
        lessonRepository.deleteById(id);
    }
}
