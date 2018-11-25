package by.training.nc.sd3.backend.Service.Impl;


import by.training.nc.sd3.backend.Entities.Lesson;
import by.training.nc.sd3.backend.Entities.Student;
import by.training.nc.sd3.backend.Entities.Teacher;

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

    @Autowired
    public AccountServiceImpl(StudentRepository repository) {
        this.repository = repository;

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













}