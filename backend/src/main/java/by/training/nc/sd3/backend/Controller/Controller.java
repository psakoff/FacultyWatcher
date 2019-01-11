package by.training.nc.sd3.backend.Controller;

import by.training.nc.sd3.backend.Entities.Lesson;
import by.training.nc.sd3.backend.Entities.Student;
import by.training.nc.sd3.backend.Entities.Teacher;
import by.training.nc.sd3.backend.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class Controller {

    private AccountService service;
    @Autowired
    public Controller(AccountService service) {
        this.service = service;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudentById(@PathVariable(name = "id") int id) {
        Optional<Student> student = service.getStudentById(id);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }





    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Student> getAllStudents() {
            return service.getAllStudents();
        }




    @RequestMapping(value = "/save",method = {RequestMethod.POST})
    public Student saveStudent(@RequestBody Student account) {
        return service.saveStudent(account);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteStudent(@PathVariable(name = "id") int id) {
        service.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
    @RequestMapping(value = "/group/{groupId}", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Student>> getStudentsByGroupId(@PathVariable(name = "groupId") int id) {
        Iterable<Student> students = service.getStudentsbyGroupId(id);
        if (students != null) {
            return ResponseEntity.ok(students);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}