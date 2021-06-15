package com.project.to_do_list.controllers;

import com.project.to_do_list.models.Day;
import com.project.to_do_list.repositories.ActivityRepository;
import com.project.to_do_list.repositories.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DayController {

    @Autowired
    DayRepository dayRepository;

    @Autowired
    ActivityRepository activityRepository;

    @GetMapping(value = "/days")
    public ResponseEntity<List<Day>> getAllDays(){
        List<Day> allDays = dayRepository.findAll();
        return new ResponseEntity<>(allDays, HttpStatus.OK);
    }

    @GetMapping(value = "/days/{id}")
    public ResponseEntity<Optional<Day>> getDayById(@PathVariable Long id){
        Optional<Day> dayById = dayRepository.findById(id);
        return new ResponseEntity<>(dayById, HttpStatus.OK);
    }

    @PostMapping(value = "/days")
    public ResponseEntity<Day> createDay (@RequestBody Day day){
        dayRepository.save(day);
        return new ResponseEntity<>(day, HttpStatus.CREATED);
    }

    @PutMapping(value = "/days/{id}")
    public Optional<Day> updateDay (@PathVariable Long id, @RequestBody Day newDay){
        return dayRepository.findById(id)
                .map(day -> {
                    day.setName(newDay.getName());
                    return dayRepository.save(day);
                });

    }

    @DeleteMapping(value = "/days/{id}")
    public ResponseEntity<HttpStatus> deleteDay(@PathVariable Long id){
        dayRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
