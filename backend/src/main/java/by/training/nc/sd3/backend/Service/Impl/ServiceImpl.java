package by.training.nc.sd3.backend.Service.Impl;


import by.training.nc.sd3.backend.Entities.Student;
import by.training.nc.sd3.backend.Repository.AccountRepository;
import by.training.nc.sd3.backend.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ServiceImpl implements Service {

    private AccountRepository repository;

    @Autowired
    public ServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student saveStudent(Student account) {
        return repository.save(account);
    }

    @Override
    public Optional<Student> getStudentById(String id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public void deleteStudent(String id) {
        repository.deleteById(id);
    }
}