package by.training.nc.sd3.backend.Entities;


import java.util.Objects;

public class Student {
    private String id;
    private int groupId;
    private String name;
    private String surname;
    private String password;

    public Student() {
    }

    public Student(String id, String name, String surname, int groupId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.groupId = groupId;
        this.password = id;
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student that = (Student) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(id, that.id) &&
                Objects.equals(groupId, that.groupId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, surname, groupId);
    }

    @Override
    public String toString() {
        return "student{" +
                "   id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", groupId='" + groupId + '\'' +
                '}';
    }
}
