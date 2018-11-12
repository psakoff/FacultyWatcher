package by.training.nc.sd3.backend.Entities;


import java.util.Objects;

public class Lesson {
    private int time;
    private int groupId;
    private String name;
    private int place;


    public Lesson() {
    }

    public Lesson(String name, int place, int groupId, int time) {
        this.time = time;
        this.name = name;
        this.place = place;
        this.groupId = groupId;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setGroupId (String email) {
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
                Objects.equals(name, that.name);

    }

    @Override
    public int hashCode() {

        return Objects.hash(place, name, time, groupId);
    }

    @Override
    public String toString() {
        return "lesson{" +
                "   time=" + time +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", groupId='" + groupId + '\'' +
                '}';
    }
}
