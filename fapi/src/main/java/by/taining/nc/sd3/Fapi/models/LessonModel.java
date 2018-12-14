package by.taining.nc.sd3.Fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class LessonModel {

    @JsonProperty("time")
    private int time;
    @JsonProperty("groupId")
    private int groupId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("place")
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

    public void setGroupId (int groupId) {
        this.groupId = groupId;
    }
}
