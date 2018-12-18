package by.training.nc.sd3.backend.Service.Impl;

import by.training.nc.sd3.backend.Entities.Attendancy;
import by.training.nc.sd3.backend.Entities.Student;
import by.training.nc.sd3.backend.Entities.Teacher;
import by.training.nc.sd3.backend.Repository.AttendancyRepository;
import by.training.nc.sd3.backend.Repository.StudentRepository;
import by.training.nc.sd3.backend.Repository.TeacherRepository;
import by.training.nc.sd3.backend.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class TeacherServiceImpl implements TeacherService {
    private TeacherRepository teacherRepository;
    private AttendancyRepository arepository;
    private StudentRepository studentRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository,AttendancyRepository arepository,StudentRepository studentRepository) {

        this.teacherRepository = teacherRepository;
        this.arepository = arepository;
        this.studentRepository=studentRepository;
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
    public Attendancy setAttendancy(Attendancy account) {
        Optional<Student> student = studentRepository.findById(account.getStudent().getId());
        Student student1 = student.get();
        Set<Attendancy> currentmisses = student1.getMisses();

        boolean flag = false;
        Attendancy temp = account;
        Iterable<Attendancy> currentList = this.arepository.getAttendancyByStudent_id(student1.getId());
        for (Attendancy that : currentList) {
            if (that.getSubject_id().equals(account.getSubject_id())) {
                that.setHours(that.getHours() + 2);
                flag = true;
                temp = that;
            }}
        currentmisses.add(temp);
        student1.setMisses(currentmisses);
        temp.setStudent(student1);
        return arepository.save(temp);
    }


    @Override
    public Iterable<Attendancy> getAttendancyById(int studentId) {

        return this.arepository.getAttendancyByStudent_id(studentId);
    }
}
