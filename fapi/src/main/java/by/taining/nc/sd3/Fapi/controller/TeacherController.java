package by.taining.nc.sd3.Fapi.controller;

import by.taining.nc.sd3.Fapi.models.TeacherModel;
import by.taining.nc.sd3.Fapi.services.DataTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private DataTeacherService dataService;

    @GetMapping("/")
    public ResponseEntity<List<TeacherModel>> getTeachers(){
        return ResponseEntity.ok(dataService.getAllTeachers());
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResponseEntity<TeacherModel> saveTeacher(@RequestBody TeacherModel teacher /*todo server validation*/) {
        if (teacher != null) {
            return ResponseEntity.ok(dataService.saveTeacher(teacher));
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteTeacher(@PathVariable int id) {
        dataService.deleteTeacher((id));
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public ResponseEntity<TeacherModel> findTeacherById(@PathVariable int id) {
        return ResponseEntity.ok(dataService.getTeacherbyId(id));
    }
}
