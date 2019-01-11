package by.training.nc.sd3.backend.Controller;

import by.training.nc.sd3.backend.Entities.Attendancy;
import by.training.nc.sd3.backend.Entities.Lesson;
import by.training.nc.sd3.backend.Entities.Student;
import by.training.nc.sd3.backend.Entities.Teacher;
import by.training.nc.sd3.backend.Service.AccountService;
import by.training.nc.sd3.backend.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private TeacherService service;
    @Autowired
    public TeacherController(TeacherService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Teacher> getTeacherById(@PathVariable(name = "id") int id) {
        Optional<Teacher> teacher = service.getTeacherbyId(id);
        if (teacher.isPresent()) {
            return ResponseEntity.ok(teacher.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Teacher> getAllTeachers() {
        return service.getAllTeachers();
    }

    @RequestMapping(value = "/save",method = {RequestMethod.POST})
    public Teacher saveTeacher(@RequestBody Teacher account) {
        return service.saveTeacher(account);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTeacher(@PathVariable(name = "id") int id) {
        service.deleteTeacher(id);
        return ResponseEntity.noContent().build();
    }
    @RequestMapping(value = "/attendances",method = {RequestMethod.POST})
    public Attendancy setAttendancy(@RequestBody Attendancy account) {
        return service.setAttendancy(account);
    }

    @RequestMapping(value = "/attendances/{id}", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Attendancy>> getAttendances(@PathVariable(name = "id") int id) {
        Iterable<Attendancy> misses = service.getAttendancyById(id);
        if (misses != null) {
            return ResponseEntity.ok(misses);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}