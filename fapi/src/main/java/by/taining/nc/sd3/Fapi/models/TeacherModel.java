package by.taining.nc.sd3.Fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeacherModel {
    @JsonProperty("id")
    private int id;
    @JsonProperty("speciality")
    private String speciality ;
    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("password")
    private String password;

        public TeacherModel() {
        }

        public TeacherModel(int id, String speciality, String name, String surname, String password) {
            this.id = id;
            this.name = name;
            this.surname = surname;
            this.speciality = speciality;
            this.password = password;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getSpeciality() {
            return speciality;
        }

        public void setGroupId (String speciality) {
            this.speciality = speciality;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

