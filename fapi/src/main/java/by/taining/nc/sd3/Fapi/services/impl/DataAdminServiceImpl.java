package by.taining.nc.sd3.Fapi.services.impl;

import by.taining.nc.sd3.Fapi.models.AdminModel;
import by.taining.nc.sd3.Fapi.models.LessonModel;
import by.taining.nc.sd3.Fapi.services.DataAdminService;
import by.taining.nc.sd3.Fapi.services.DataLessonService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class DataAdminServiceImpl implements DataAdminService {
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public AdminModel getAdmin() {
        RestTemplate restTemplate = new RestTemplate();
        AdminModel AdminModelResponse = restTemplate.getForObject(backendServerUrl + "/admin/", AdminModel.class);
        return AdminModelResponse == null ? null : AdminModelResponse;
    }
}