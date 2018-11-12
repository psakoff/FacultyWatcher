package by.taining.nc.sd3.Fapi.services.impl;
import by.taining.nc.sd3.Fapi.services.DataService;
import by.taining.nc.sd3.Fapi.models.StudentModel;
import by.taining.nc.sd3.Fapi.models.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@Service
public class DataServiceImpl implements DataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;
    @Override
    public List<StudentModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        StudentModel[] StudentModelResponse = restTemplate.getForObject(backendServerUrl + "/api/students/", StudentModel[].class);
        return StudentModelResponse == null ? Collections.emptyList() : Arrays.asList(StudentModelResponse);
    }

    @Override
    public StudentModel getStudentbyId(int id) {
        return null;
    }

    @Override
    public void saveStudent(Student account) {
      getAll().add(new StudentModel("213", "aasddasdda", "12weq", 12));
    }

    @Override
    public void deleteStudent(int id) {

    }
}
