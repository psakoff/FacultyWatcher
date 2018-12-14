package by.taining.nc.sd3.Fapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AttendancyModel {
    @JsonProperty("student")
    StudentModel student;
    @JsonProperty("subject_id")
    String subject_id;
    int hours;

    public AttendancyModel(){}

    public AttendancyModel(StudentModel studentModel,String subject_name, int hours) {
        this.hours = hours;
        this.subject_id = subject_name;
        this.student=studentModel;
    }
        public int getHours() {
            return hours;
        }

        public void setHours(int hours) {
            this.hours = hours;
        }

        public String getSubject_name() {
            return subject_id;
        }

        public void setSubject_name(String id_spec) {
            this.subject_id = id_spec;
        }
        public StudentModel getStudent(){return student;}
        public void setStudent(StudentModel student){this.student=student;}
    @Override
    public String toString() {
        return "attendancy{" +
                "Student=" + student.toString() +
                ", subject_id='" + subject_id + '\'' +
                ", hours='" + hours + '\'' +
                '}';
    }
}

