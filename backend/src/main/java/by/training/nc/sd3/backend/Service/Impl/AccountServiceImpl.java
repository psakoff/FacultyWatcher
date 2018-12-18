package by.training.nc.sd3.backend.Service.Impl;


import by.training.nc.sd3.backend.Entities.*;

import by.training.nc.sd3.backend.Repository.AttendancyRepository;
import by.training.nc.sd3.backend.Repository.StudentRepository;
import by.training.nc.sd3.backend.Repository.TeacherRepository;
import by.training.nc.sd3.backend.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AccountServiceImpl implements AccountService {

    private StudentRepository repository;
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

    @Override
    public Admin getAdmin(){
      return new Admin("root","root");
    }

    public List<Student> getStudentsbyGroupId(int groupId) {
        Iterable<Student> students = repository.getAllByGroupId(groupId);
        List<Student> currGroup= new ArrayList<>();

        students.forEach(student -> currGroup.add(student));
        return currGroup;
    }












}