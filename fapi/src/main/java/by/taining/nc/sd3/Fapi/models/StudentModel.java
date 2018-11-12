package by.taining.nc.sd3.Fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentModel {

    private String id;
    private int groupId;
    private String name;
    private String surname;

    public StudentModel() {
    }

    public StudentModel(String id, String name, String surname, int groupId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.groupId = groupId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String address) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String username) {
        this.surname = surname;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId (String email) {
        this.groupId = groupId;
    }
}