package by.training.nc.sd3.backend.Controller;
import by.training.nc.sd3.backend.Entities.Lesson;
import by.training.nc.sd3.backend.Service.LessonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/lessons")
public class LessonController {
    private LessonService service;
    @Autowired
    public LessonController(LessonService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Lesson> getLessonsByGroupId(@PathVariable(name = "id") int id) {
        Optional<Lesson> lessons = service.getLessonsByGroup(id);
        if (lessons.isPresent()) {
            return ResponseEntity.ok(lessons.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @RequestMapping(value = "/group/{groupId}", method = RequestMethod.GET)
    public ResponseEntity<Lesson> getLessonById(@PathVariable(name = "groupId") int id) {
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

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Lesson saveLesson(@RequestBody Lesson account) {
        return service.saveLesson(account);
    }



    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteLesson(@PathVariable(name = "id") int id) {
        service.deleteLesson(id);
        return ResponseEntity.noContent().build();
    }
}
