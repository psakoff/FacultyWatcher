package by.training.nc.sd3.backend.Controller;
import by.training.nc.sd3.backend.Entities.Lesson;
import by.training.nc.sd3.backend.ForbiddenException;
import by.training.nc.sd3.backend.Service.LessonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lessons")
public class LessonController {
    private LessonService service;
    @Autowired
    public LessonController(LessonService service) {
        this.service = service;
    }

    @RequestMapping(value = "/group/{groupId}", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Lesson>> getLessonsByGroupId(@PathVariable(name = "groupId") int id) {
        Iterable<Lesson> lessons = service.getLessonsByGroup(id);
        if (lessons != null) {
            return ResponseEntity.ok(lessons);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @RequestMapping(value = "/name/{speciality}", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Lesson>> getLessonsByName(@PathVariable(name = "speciality") String id) {
        Iterable<Lesson> lessons = service.getLessonsByName(id);
        if (lessons != null) {
            return ResponseEntity.ok(lessons);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Lesson> getLessonById(@PathVariable(name = "id") int id) {
        Optional<Lesson> lesson = service.getLessonById(id);
        if (lesson.isPresent()) {
            return ResponseEntity.ok(lesson.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Lesson> getAllLessons() {
        return service.getAllLessons();
    }

    @RequestMapping(value = "/save",method = {RequestMethod.POST})
    public Lesson saveLesson(@RequestBody Lesson account) {
        Iterable<Lesson> lessons = service.getAllLessons();
        List<Lesson> CurrGroup= new ArrayList<>();
        boolean mistake = false;
        for(Lesson lesson: lessons) {
            if (lesson.getGroupId() == account.getGroupId()){
                if (lesson.getTime() == account.getTime())
                   mistake = true;}
            if (lesson.getTime()==account.getTime())
            {   if (lesson.getPlace() == account.getPlace())
                    mistake = true;}
            if (lesson.getTime() == account.getTime()){
                if (lesson.getName().equals(account.getName()))
                    mistake = true;
            }
        }if (mistake == false) return service.saveLesson(account);
        else throw new ForbiddenException();
    }



    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteLesson(@PathVariable(name = "id") int id) {
        service.deleteLesson(id);
        return ResponseEntity.noContent().build();
    }
}
