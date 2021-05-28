package com.project.to_do_list.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="days")
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany
    @JoinColumn(name = "activity_id", nullable = false)
    @JsonIgnoreProperties({"days"})
    private ArrayList<Activity> list;

    public Day(String name){
        this.name = name;
        this.list = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Activity> getList() {
        return list;
    }

    public void addNewActivity(Activity newActivity){
        this.list.add(newActivity);
    }
}
