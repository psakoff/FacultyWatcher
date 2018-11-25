package by.taining.nc.sd3.Fapi.services.impl;
import by.taining.nc.sd3.Fapi.services.DataStudentService;
import by.taining.nc.sd3.Fapi.models.StudentModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@Service
public class DataStudentServiceImpl implements DataStudentService {

    @Value("${backend.server.url}")
    private String backendServerUrl;
    @Override
    public List<StudentModel> getAllStudents() {
        RestTemplate restTemplate = new RestTemplate();
        StudentModel[] StudentModelResponse = restTemplate.getForObject(backendServerUrl + "/students/", StudentModel[].class);
        return StudentModelResponse == null ? Collections.emptyList() : Arrays.asList(StudentModelResponse);
    }

    @Override
    public StudentModel getStudentbyId(int id)
    {
        RestTemplate restTemplate = new RestTemplate();
        StudentModel StudentModelResponse = restTemplate.getForObject(backendServerUrl + "/students/"+id, StudentModel.class);
        return StudentModelResponse == null ? null : StudentModelResponse;
    }

    @Override
    public StudentModel saveStudent(StudentModel account) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/students/save", account, StudentModel.class).getBody();
    }

    @Override
    public void deleteStudent(int id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/students/delete/" + id);
    }



}

