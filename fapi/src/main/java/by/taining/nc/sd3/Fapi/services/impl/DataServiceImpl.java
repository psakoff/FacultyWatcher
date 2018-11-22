package by.taining.nc.sd3.Fapi.services.impl;
import by.taining.nc.sd3.Fapi.models.LessonModel;
import by.taining.nc.sd3.Fapi.models.TeacherModel;
import by.taining.nc.sd3.Fapi.services.DataService;
import by.taining.nc.sd3.Fapi.models.StudentModel;
import by.taining.nc.sd3.Fapi.models.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public List<StudentModel> getAllStudents() {
        RestTemplate restTemplate = new RestTemplate();
        StudentModel[] StudentModelResponse = restTemplate.getForObject(backendServerUrl + "/api/students", StudentModel[].class);
        return StudentModelResponse == null ? Collections.emptyList() : Arrays.asList(StudentModelResponse);
    }

    @Override
    public StudentModel getStudentbyId(int id)
    {
        RestTemplate restTemplate = new RestTemplate();
        StudentModel StudentModelResponse = restTemplate.getForObject(backendServerUrl + "/api/students/"+id, StudentModel.class);
        return StudentModelResponse == null ? null : StudentModelResponse;
    }

    @Override
    public StudentModel saveStudent(StudentModel account) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/savestudent", account, StudentModel.class).getBody();
    }

    @Override
    public void deleteStudent(int id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/deletestudents/" + id);
    }

    public List<TeacherModel> getAllTeachers() {
        RestTemplate restTemplate = new RestTemplate();
        TeacherModel[] TeacherModelResponse = restTemplate.getForObject(backendServerUrl + "/api/teachers", TeacherModel[].class);
        return TeacherModelResponse == null ? Collections.emptyList() : Arrays.asList(TeacherModelResponse);
    }
    @Override
    public TeacherModel getTeacherbyId(int id) {
        RestTemplate restTemplate = new RestTemplate();
        TeacherModel TeacherModelResponse = restTemplate.getForObject(backendServerUrl + "/api/teachers/"+id, TeacherModel.class);
        return TeacherModelResponse == null ? null : TeacherModelResponse;
    }

    @Override
    public TeacherModel saveTeacher(TeacherModel account) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/saveteacher", account, TeacherModel.class).getBody();
    }

    @Override
    public void deleteTeacher(int id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/deleteteachers/" + id);
    }

    @Override
    public List<LessonModel> getAllLessons() {
        RestTemplate restTemplate = new RestTemplate();
        LessonModel[] LessonModelResponse = restTemplate.getForObject(backendServerUrl + "/api/lessons", LessonModel[].class);
        return LessonModelResponse == null ? Collections.emptyList() : Arrays.asList(LessonModelResponse);
    }
    @Override
    public LessonModel saveLesson(LessonModel account) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/savelesson", account, LessonModel.class).getBody();
    }
    @Override
    public List<LessonModel> getLessonsByGroup(int groupId) {
        RestTemplate restTemplate = new RestTemplate();
        LessonModel[] LessonModelResponse = restTemplate.getForObject(backendServerUrl + "/lessons/group/"+groupId, LessonModel[].class);
        return LessonModelResponse == null ? Collections.emptyList() : Arrays.asList(LessonModelResponse);
    }
    @Override
    public void deleteLesson(int id){

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.delete(backendServerUrl + "/api/deletelessons/" + id);
        }
    @Override
    public LessonModel getLessonbyId(int id) {
        RestTemplate restTemplate = new RestTemplate();
        LessonModel LessonModelResponse = restTemplate.getForObject(backendServerUrl + "/api/teachers/"+id, LessonModel.class);
        return LessonModelResponse == null ? null : LessonModelResponse;
    }

}

