package by.training.nc.sd3.backend.Service.Impl;

import by.training.nc.sd3.backend.Entities.Teacher;
import by.training.nc.sd3.backend.Repository.TeacherRepository;
import by.training.nc.sd3.backend.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class TeacherServiceImpl implements TeacherService {
    private TeacherRepository teacherRepository;
    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {

        this.teacherRepository = teacherRepository;

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
}
