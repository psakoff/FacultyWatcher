package by.taining.nc.sd3.Fapi.controller;

import by.taining.nc.sd3.Fapi.models.AdminModel;
import by.taining.nc.sd3.Fapi.models.StudentModel;
import by.taining.nc.sd3.Fapi.services.DataAdminService;
import by.taining.nc.sd3.Fapi.services.DataStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private DataAdminService dataAdminService;


    //----------------------------------------------------------------------------------------------------------------------------------------------
    @GetMapping("/")
    public ResponseEntity<AdminModel> getAdmin() {
        return ResponseEntity.ok(dataAdminService.getAdmin());
    }
}