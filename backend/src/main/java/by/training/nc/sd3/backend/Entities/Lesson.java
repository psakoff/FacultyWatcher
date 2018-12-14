package by.training.nc.sd3.backend.Entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
@Entity
@Table(name = "lesson")
public class Lesson {
    @Id
    private int id;
    private int groupId;
    private String speciality;
    private int time;

    private int place;


    public Lesson() {
    }

    public Lesson(String speciality, int place, int groupId, int time,int id) {
        this.id=id;
        this.time = time;
        this.speciality = speciality;
        this.place = place;
        this.groupId = groupId;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getName() {
        return speciality;
    }

    public void setName(String speciality) {
        this.speciality = speciality;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId (int groupId) {
        this.groupId = groupId;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson that = (Lesson) o;
        return groupId == that.groupId &&
                time == that.time &&
                place == that.place &&
                Objects.equals(speciality, that.speciality);

    }

    @Override
    public int hashCode() {

        return Objects.hash(place, speciality, time, groupId);
    }

    @Override
    public String toString() {
        return "lesson{" +
                "   time=" + time +
                ", name='" + speciality + '\'' +
                ", place='" + place + '\'' +
                ", groupId='" + groupId + '\'' +
                '}';
    }
}
