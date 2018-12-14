package by.taining.nc.sd3.Fapi.services.impl;

import by.taining.nc.sd3.Fapi.models.AttendancyModel;
import by.taining.nc.sd3.Fapi.models.TeacherModel;
import by.taining.nc.sd3.Fapi.services.DataTeacherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@Service
public class DataTeacherServiceImpl implements DataTeacherService {
    @Value("${backend.server.url}")
    private String backendServerUrl;
    @Override
    public List<TeacherModel> getAllTeachers() {
        RestTemplate restTemplate = new RestTemplate();
        TeacherModel[] TeacherModelResponse = restTemplate.getForObject(backendServerUrl + "/teachers/", TeacherModel[].class);
        return TeacherModelResponse == null ? Collections.emptyList() : Arrays.asList(TeacherModelResponse);
    }
    @Override
    public TeacherModel getTeacherbyId(int id) {
        RestTemplate restTemplate = new RestTemplate();
        TeacherModel TeacherModelResponse = restTemplate.getForObject(backendServerUrl + "/teachers/"+id, TeacherModel.class);
        return TeacherModelResponse == null ? null : TeacherModelResponse;
    }

    @Override
    public TeacherModel saveTeacher(TeacherModel account) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/teachers/save", account, TeacherModel.class).getBody();
    }
    @Override
    public AttendancyModel setAttendancy(AttendancyModel account) {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(account);
        return restTemplate.postForEntity(backendServerUrl + "/teachers/attendances", account, AttendancyModel.class).getBody();
    }

    @Override
    public void deleteTeacher(int id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/teachers/delete/" + id);
    }
    @Override
    public List<AttendancyModel> getAttendancyById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        AttendancyModel[] LessonModelResponse = restTemplate.getForObject(backendServerUrl + "/teachers/attendances/"+id, AttendancyModel[].class);
        return LessonModelResponse == null ? Collections.emptyList() : Arrays.asList(LessonModelResponse);
    }

}
