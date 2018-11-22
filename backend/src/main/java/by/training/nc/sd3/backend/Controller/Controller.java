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
@RequestMapping("/api")
public class Controller {

    private AccountService service;
    @Autowired
    public Controller(AccountService service) {
        this.service = service;
    }
 public Student account1 = new Student(103,"ololo","sdawf","103",13);


    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudentById(@PathVariable(name = "id") int id) {
        Optional<Student> student = service.getStudentById(id);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.GET)
    public ResponseEntity<Teacher> getTeacherById(@PathVariable(name = "id") int id) {
        Optional<Teacher> teacher = service.getTeacherbyId(id);
        if (teacher.isPresent()) {
            return ResponseEntity.ok(teacher.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @RequestMapping(value = "/lessons/{id}", method = RequestMethod.GET)
    public ResponseEntity<Lesson> getLessonsByGroupId(@PathVariable(name = "id") int id) {
        Optional<Lesson> lessons = service.getLessonsByGroup(id);
        if (lessons.isPresent()) {
            return ResponseEntity.ok(lessons.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @RequestMapping(value = "/lessons/group/{groupId}", method = RequestMethod.GET)
    public ResponseEntity<Lesson> getLessonById(@PathVariable(name = "groupId") int id) {
        Optional<Lesson> lesson = service.getLessonById(id);
        if (lesson.isPresent()) {
            return ResponseEntity.ok(lesson.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }




    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public Iterable<Student> getAllStudents() {
            return service.getAllStudents();
        }
    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
    public Iterable<Teacher> getAllTeachers() {
        return service.getAllTeachers();
    }
    @RequestMapping(value = "/lessons", method = RequestMethod.GET)
    public Iterable<Lesson> getAllLessons() {
        return service.getAllLessons();
    }


    @RequestMapping(value = "/savestudent",method = {RequestMethod.POST, RequestMethod.GET})
    public Student saveStudent(@RequestBody Student account) {
        return service.saveStudent(account);
    }
    @RequestMapping(value = "/saveteacer",method = RequestMethod.POST)
    public Teacher saveTeacher(@RequestBody Teacher account) {
        return service.saveTeacher(account);
    }
    @RequestMapping(value = "/savelesson",method = RequestMethod.POST)
    public Lesson saveLesson(@RequestBody Lesson account) {
        return service.saveLesson(account);
    }



    @RequestMapping(value = "/deleteteachers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTeacher(@PathVariable(name = "id") int id) {
        service.deleteTeacher(id);
        return ResponseEntity.noContent().build();
    }
    @RequestMapping(value = "/deletelessons/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteLesson(@PathVariable(name = "id") int id) {
        service.deleteLesson(id);
        return ResponseEntity.noContent().build();
    }
    @RequestMapping(value = "/deletestudents/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteStudent(@PathVariable(name = "id") int id) {
        service.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

}