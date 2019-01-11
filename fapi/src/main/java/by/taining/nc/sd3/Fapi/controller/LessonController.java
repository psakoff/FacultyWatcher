package by.taining.nc.sd3.Fapi.controller;

import by.taining.nc.sd3.Fapi.models.LessonModel;
import by.taining.nc.sd3.Fapi.services.DataLessonService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lessons")
public class LessonController {
    @Autowired
    private DataLessonService dataService;

    @GetMapping("/")
    public ResponseEntity<List<LessonModel>> getLessons(){
        return ResponseEntity.ok(dataService.getAllLessons());
    }

    @RequestMapping(value = "/save",method = {RequestMethod.POST})
    public ResponseEntity<LessonModel> saveLesson(@RequestBody LessonModel lesson /*todo server validation*/) {
        if (lesson != null) {
            return ResponseEntity.ok(dataService.saveLesson(lesson));
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteLesson(@PathVariable int id) {
        dataService.deleteLesson((id));
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public ResponseEntity<LessonModel> findLessonById(@PathVariable int id) {
        return ResponseEntity.ok(dataService.getLessonbyId(id));
    }

    @RequestMapping(value = "/find/group/{groupId}", method = RequestMethod.GET)
    public ResponseEntity<List<LessonModel>> findLessonsByGroupId(@PathVariable int groupId) {
        return ResponseEntity.ok(dataService.getLessonsByGroup(groupId));
    }
    @RequestMapping(value = "/find/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<LessonModel>> findLessonsByName(@PathVariable String name) {
        return ResponseEntity.ok(dataService.getLessonsByName(name));
    }

}
