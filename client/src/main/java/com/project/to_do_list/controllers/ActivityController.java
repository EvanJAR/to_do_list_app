package com.project.to_do_list.controllers;

import com.project.to_do_list.models.Activity;
import com.project.to_do_list.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ActivityController {

    @Autowired
    ActivityRepository activityRepository;

    @GetMapping(value = "/activities")
    public ResponseEntity<List<Activity>> getAllActivities(){
        List<Activity> allActivities = activityRepository.findAll();
        return new ResponseEntity<>(allActivities, HttpStatus.OK);
    }

    @GetMapping(value = "/activities/{id}")
    public ResponseEntity<Optional<Activity>> getActivityById(@PathVariable Long id){
        Optional<Activity> activityById = activityRepository.findById(id);
        return new ResponseEntity<>(activityById, HttpStatus.OK);
    }

    @PostMapping(value = "/activities")
    public ResponseEntity<Activity> createActivity (@RequestBody Activity activity){
        activityRepository.save(activity);
        return new ResponseEntity<>(activity, HttpStatus.CREATED);
    }

    @PutMapping(value = "/activities/{id}")
    public ResponseEntity<Activity> updateActivity (@RequestBody Activity activity){
        activityRepository.save(activity);
        return new ResponseEntity<>(activity, HttpStatus.OK);
    }

    @DeleteMapping(value = "/activities/{id}")
    public ResponseEntity<HttpStatus> deleteActivity(@PathVariable Long id){
        activityRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
