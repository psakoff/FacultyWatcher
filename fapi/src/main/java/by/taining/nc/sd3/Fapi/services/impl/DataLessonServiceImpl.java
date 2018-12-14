package by.taining.nc.sd3.Fapi.services.impl;

import by.taining.nc.sd3.Fapi.models.LessonModel;
import by.taining.nc.sd3.Fapi.services.DataLessonService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class DataLessonServiceImpl implements DataLessonService {
    @Value("${backend.server.url}")
    private String backendServerUrl;
    @Override
    public List<LessonModel> getAllLessons() {
        RestTemplate restTemplate = new RestTemplate();
        LessonModel[] LessonModelResponse = restTemplate.getForObject(backendServerUrl + "/lessons/", LessonModel[].class);
        return LessonModelResponse == null ? Collections.emptyList() : Arrays.asList(LessonModelResponse);
    }
    @Override
    public LessonModel saveLesson(LessonModel account) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/lessons/save", account, LessonModel.class).getBody();
    }
    @Override
    public List<LessonModel> getLessonsByGroup(int groupId) {
        RestTemplate restTemplate = new RestTemplate();
        LessonModel[] LessonModelResponse = restTemplate.getForObject(backendServerUrl + "/lessons/group/"+groupId, LessonModel[].class);
        return LessonModelResponse == null ? Collections.emptyList() : Arrays.asList(LessonModelResponse);
    }
    @Override
    public List<LessonModel> getLessonsByName(String Name) {
        RestTemplate restTemplate = new RestTemplate();
        LessonModel[] LessonModelResponse = restTemplate.getForObject(backendServerUrl + "/lessons/name/"+Name, LessonModel[].class);
        return LessonModelResponse == null ? Collections.emptyList() : Arrays.asList(LessonModelResponse);
    }
    @Override
    public void deleteLesson(int id){

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/lessons/delete/" + id);
    }
    @Override
    public LessonModel getLessonbyId(int id) {
        RestTemplate restTemplate = new RestTemplate();
        LessonModel LessonModelResponse = restTemplate.getForObject(backendServerUrl + "/lessons/"+id, LessonModel.class);
        return LessonModelResponse == null ? null : LessonModelResponse;
    }
}
