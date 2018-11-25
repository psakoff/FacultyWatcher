package by.taining.nc.sd3.Fapi.services;

import by.taining.nc.sd3.Fapi.models.TeacherModel;

import java.util.List;

public interface DataTeacherService {
    List<TeacherModel> getAllTeachers();
    TeacherModel getTeacherbyId(int id);
    TeacherModel saveTeacher(TeacherModel account);
    void deleteTeacher(int id);
}
