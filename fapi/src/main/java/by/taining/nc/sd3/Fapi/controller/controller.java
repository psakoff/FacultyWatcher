package by.taining.nc.sd3.Fapi.controller;
import by.taining.nc.sd3.Fapi.models.*;
import by.taining.nc.sd3.Fapi.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/")
public class controller {

    @Autowired
    private DataService dataService;



//----------------------------------------------------------------------------------------------------------------------------------------------
    @GetMapping("students")
        public ResponseEntity<List<StudentModel>> getAllStudents() {
            return ResponseEntity.ok(dataService.getAllStudents());
        }
    @GetMapping("teachers")
    public ResponseEntity<List<TeacherModel>> getTeachers(){
        return ResponseEntity.ok(dataService.getAllTeachers());
    }
    @GetMapping("lessons")
    public ResponseEntity<List<LessonModel>> getLessons(){
        return ResponseEntity.ok(dataService.getAllLessons());
    }



//----------------------------------------------------------------------------------------------------------------------------------------------

    @RequestMapping(value = "save/student",method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseEntity<StudentModel> saveStudent(@RequestBody StudentModel student /*todo server validation*/) {
        if (student != null) {
            return ResponseEntity.ok(dataService.saveStudent(student));
        }
        return null;
    }
    @RequestMapping(value = "save/teacher",method = RequestMethod.POST)
    public ResponseEntity<TeacherModel> saveTeacher(@RequestBody TeacherModel teacher /*todo server validation*/) {
        if (teacher != null) {
            return ResponseEntity.ok(dataService.saveTeacher(teacher));
        }
        return null;
    }
    @RequestMapping(value = "save/lesson",method = RequestMethod.POST)
    public ResponseEntity<LessonModel> saveLesson(@RequestBody LessonModel lesson /*todo server validation*/) {
        if (lesson != null) {
            return ResponseEntity.ok(dataService.saveLesson(lesson));
        }
        return null;
    }




    //----------------------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "/delete/student/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable int id) {
        dataService.deleteStudent((id));
    }
    @RequestMapping(value = "/delete/teacher/{id}", method = RequestMethod.DELETE)
    public void deleteTeacher(@PathVariable int id) {
        dataService.deleteTeacher((id));
    }
    @RequestMapping(value = "/delete/lesson/{id}", method = RequestMethod.DELETE)
    public void deleteLesson(@PathVariable int id) {
        dataService.deleteLesson((id));
    }




    //----------------------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "/find/lesson/{id}", method = RequestMethod.GET)
    public ResponseEntity<LessonModel> findLessonById(@PathVariable int id) {
        return ResponseEntity.ok(dataService.getLessonbyId(id));
    }
    @RequestMapping(value = "/find/teacher/{id}", method = RequestMethod.GET)
    public ResponseEntity<TeacherModel> findTeacherById(@PathVariable int id) {
        return ResponseEntity.ok(dataService.getTeacherbyId(id));
    }
    @RequestMapping(value = "/find/student/{id}", method = RequestMethod.GET)
    public ResponseEntity<StudentModel> findStudentById(@PathVariable int id) {
        return ResponseEntity.ok(dataService.getStudentbyId(id));
    }
    @RequestMapping(value = "/find/lesson/group/{groupId}", method = RequestMethod.GET)
    public ResponseEntity<List<LessonModel>> findLessonsByGroupId(@PathVariable int groupId) {
        return ResponseEntity.ok(dataService.getLessonsByGroup(groupId));
    }


}
