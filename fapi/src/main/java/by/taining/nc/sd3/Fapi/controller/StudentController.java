package by.taining.nc.sd3.Fapi.controller;
import by.taining.nc.sd3.Fapi.models.*;
import by.taining.nc.sd3.Fapi.services.DataStudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
//import security.JwtTokenUtil;

import java.util.List;
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private DataStudentService dataStudentService;



//----------------------------------------------------------------------------------------------------------------------------------------------
    @GetMapping("/")
        public ResponseEntity<List<StudentModel>> getAllStudents() {
            return ResponseEntity.ok(dataStudentService.getAllStudents());
        }





//----------------------------------------------------------------------------------------------------------------------------------------------

    @RequestMapping(value = "save/student",method = {RequestMethod.POST})
    public ResponseEntity<StudentModel> saveStudent(@RequestBody StudentModel student /*todo server validation*/) {
        if (student != null) {
            return ResponseEntity.ok(dataStudentService.saveStudent(student));
        }
        return null;
    }






    //----------------------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "/delete/student/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable int id) {
        dataStudentService.deleteStudent((id));
    }






    //----------------------------------------------------------------------------------------------------------------------------------------------


    @RequestMapping(value = "/find/student/{id}", method = RequestMethod.GET)
    public ResponseEntity<StudentModel> findStudentById(@PathVariable int id) {
        return ResponseEntity.ok(dataStudentService.getStudentbyId(id));
    }
    @RequestMapping(value = "/find/group/{groupId}", method = RequestMethod.GET)
    public ResponseEntity<List<StudentModel>> findStudentsByGroupId(@PathVariable int groupId) {
        return ResponseEntity.ok(dataStudentService.getStudentsByGroupId(groupId));
    }

//    @Value("${jwt.header}")
//    private String tokenHeader;
//
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
//
//    @Autowired
//    @Qualifier("jwtUserDetailsService")
//    private UserDetailsService userDetailsService;

}
