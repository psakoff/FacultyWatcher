package by.training.nc.sd3.backend.Controller;

import by.training.nc.sd3.backend.Entities.Student;
import by.training.nc.sd3.backend.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/BEstudents")
public class Controller {

    private Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudentById(@PathVariable(name = "id") String id) {
        Optional<Student> student = service.getStudentById(id);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public Iterable<Student> getAllStudents() {
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("213", "ada", "wqds", 12));
        list.add(new Student("213", "adaddd", "sdeqwas", 12));
        list.add(new Student("213", "aasdda", "eqw", 12));
        return list;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Student saveStudent(@RequestBody Student account) {
        return service.saveStudent(account);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteStudent(@PathVariable(name = "id") String id) {
        service.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

}