package by.taining.nc.sd3.Fapi.controller;
import by.taining.nc.sd3.Fapi.models.Lesson;
import by.taining.nc.sd3.Fapi.models.StudentModel;
import by.taining.nc.sd3.Fapi.models.Student;
import by.taining.nc.sd3.Fapi.models.Teacher;
import by.taining.nc.sd3.Fapi.services.DataService;
import by.taining.nc.sd3.Fapi.services.impl.DataServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/")
public class controller {

    @GetMapping("students")
    public List<Student> getIndex() {
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("213", "ada", "wqds", 12));
        list.add(new Student("213", "adaddd", "sdeqwas", 12));
        list.add(new Student("213", "aasdda", "eqw", 12));
        return list;
        }

    @GetMapping("teachers")
    public List<Teacher> getTeachers(){
        ArrayList<Teacher> list = new ArrayList<Teacher>();
        list.add(new Teacher("11","ada","wqds","ewqsda"));
        list.add(new Teacher("12","ada","wqds","ewqsda"));
        list.add(new Teacher("13","ada","wqds","ewqsda"));
        return list;
    }
    @GetMapping("lessons")
    public List<Lesson> getLessons(){
        ArrayList<Lesson> list = new ArrayList<Lesson>();
        list.add(new Lesson("sdaad",11,213,1));
        list.add(new Lesson("sdaad",11,213,2));
        list.add(new Lesson("sdaad",11,213,3));
        return list;
    }
}
