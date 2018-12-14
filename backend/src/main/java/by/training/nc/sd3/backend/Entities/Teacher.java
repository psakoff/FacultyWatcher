package by.training.nc.sd3.backend.Entities;


import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "teacher")
public class Teacher {



    @Id private int id;
    private String speciality ;
    private String name;
    private String surname;
    private String password;

    public Teacher() {
    }

    public Teacher(int id, String name, String surname, String speciality,String password) {
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

    public void setSpeciality (String speciality) {
        this.speciality = speciality;
    }
    public String getpassword() {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
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
