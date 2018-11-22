package by.training.nc.sd3.backend.Service.Impl;


import by.training.nc.sd3.backend.Entities.Lesson;
import by.training.nc.sd3.backend.Entities.Student;
import by.training.nc.sd3.backend.Entities.Teacher;
import by.training.nc.sd3.backend.Repository.LessonRepository;
import by.training.nc.sd3.backend.Repository.StudentRepository;
import by.training.nc.sd3.backend.Repository.TeacherRepository;
import by.training.nc.sd3.backend.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Optional;

@Component
public class AccountServiceImpl implements AccountService {

    private StudentRepository repository;
    private TeacherRepository teacherRepository;
    private LessonRepository lessonRepository;

    @Autowired
    public AccountServiceImpl(StudentRepository repository,TeacherRepository teacherRepository,LessonRepository lessonRepository) {
        this.repository = repository;
        this.teacherRepository = teacherRepository;
        this.lessonRepository = lessonRepository;
    }

    @Override
    public Student saveStudent(Student account) {
        return repository.save(account);
    }

    @Override
    public Optional<Student> getStudentById(int id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public void deleteStudent(int id) {
        repository.deleteById(id);
    }






    @Override
    public Teacher saveTeacher(Teacher account) {
        return teacherRepository.save(account);
    }

    @Override
    public Optional<Teacher> getTeacherbyId(int id) {
        return teacherRepository.findById(id);
    }

    @Override
    public Iterable<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public void deleteTeacher(int id) {
        teacherRepository.deleteById(id);
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