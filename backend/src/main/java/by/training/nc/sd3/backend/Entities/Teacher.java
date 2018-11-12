package by.training.nc.sd3.backend.Entities;


import java.util.Objects;

public class Teacher {
    private String id;
    private String speciality ;
    private String name;
    private String surname;
    private String password;

    public Teacher() {
    }

    public Teacher(String id, String name, String surname, String speciality) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.speciality = speciality;
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

    public void setSpeciality (String speciality) {
        this.speciality = speciality;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher that = (Teacher) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(id, that.id) &&
                Objects.equals(speciality, that.speciality);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, surname, speciality);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "   id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", groupId='" + speciality + '\'' +
                '}';
    }
}
