package by.taining.nc.sd3.Fapi.services;

import by.taining.nc.sd3.Fapi.models.AttendancyModel;
import by.taining.nc.sd3.Fapi.models.TeacherModel;

import java.util.List;

public interface DataTeacherService {
    List<TeacherModel> getAllTeachers();
    TeacherModel getTeacherbyId(int id);
    TeacherModel saveTeacher(TeacherModel account);
    AttendancyModel setAttendancy(AttendancyModel account);
    void deleteTeacher(int id);
    List<AttendancyModel> getAttendancyById(int id);
}
