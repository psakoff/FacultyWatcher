package by.training.nc.sd3.backend.Controller;

import by.training.nc.sd3.backend.Entities.Admin;
import by.training.nc.sd3.backend.Entities.Student;
import by.training.nc.sd3.backend.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private AccountService service;
    @Autowired
    public AdminController(AccountService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Admin> getAdmin() {
        Admin admin = service.getAdmin();
            return ResponseEntity.ok(admin);

        }
}

