package by.training.nc.sd3.backend.Entities;


import javax.persistence.*;

import java.util.Objects;
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String password;
    @Column(name = "groupId") private int groupId;

    public Student() {
    }

    public Student(int id, String name, String surname,  String password, int groupId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.groupId = groupId;
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

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId (int groupId) {
        this.groupId = groupId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
