package com.project.to_do_list.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="days")
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany
    @JoinColumn(name = "activity_id")
    @JsonIgnoreProperties({"days"})
    private List<Activity> list;

    public Day(String name){
        this.name = name;
        this.list = new ArrayList<>();
    }

    public Day(){};


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Activity> getList() {
        return list;
    }

    public void addNewActivity(Activity newActivity){
        this.list.add(newActivity);
    }

    public void deleteActivity(Activity activityToDelete){
        this.list.remove(activityToDelete);
    }

    public void emptyList(){
        this.list.clear();
    }
}
