package by.training.nc.sd3.backend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "attendancy")
public class Attendancy implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @JsonIgnore
    int global_id;

    @Column(name = "subject_name")
    String subject_id;
    @ManyToOne(cascade = {CascadeType.ALL,CascadeType.MERGE,CascadeType.REMOVE})
    @JoinTable(name = "attendancy_student", joinColumns = @JoinColumn(name = "attendancy_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    Student student;


    int hours;
    public Attendancy(){}

    public Attendancy(String subject_name, Student student, int hours) {
        this.hours = hours;
        this.subject_id = subject_name ;
        this.student= student;

    }
        public int getHours() {
            return hours;
        }

        public void setHours(int hours) {
            this.hours = hours;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_name) {
            this.subject_id = subject_name;
        }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    public int getGlobal_id(){return global_id;}

    @Override
    public String toString() {
        return "attendancy{" +
                "   Student=" + student +
                ", subject_id='" + subject_id + '\'' +
                ", hours='" + hours + '\'' +
                '}';
    }

}

