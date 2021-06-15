package com.project.to_do_list.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="activities")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    @Column
    private Boolean finished;

    @ManyToOne
    @JoinColumn(name = "day_id", nullable = false)
    @JsonIgnoreProperties({"activities"})
    private Day day;

    public Activity(String description, Boolean finished, Day day) {
        this.description = description;
        this.finished = finished;
        this.day = day;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }


}
