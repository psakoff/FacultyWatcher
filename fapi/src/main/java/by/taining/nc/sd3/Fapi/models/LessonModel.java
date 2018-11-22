package by.taining.nc.sd3.Fapi.models;

public class LessonModel {
    private int time;
    private int groupId;
    private String name;
    private int place;


    public LessonModel() {
    }

    public LessonModel(String name, int place, int groupId, int time) {
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
}
