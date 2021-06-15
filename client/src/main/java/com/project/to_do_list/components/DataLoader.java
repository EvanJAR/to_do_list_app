package com.project.to_do_list.components;

import com.project.to_do_list.models.*;
import com.project.to_do_list.repositories.ActivityRepository;
import com.project.to_do_list.repositories.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    DayRepository dayRepository;

    public DataLoader(){};

    public void run(ApplicationArguments args){

        Day day1 = new Day("Monday");
        dayRepository.save(day1);

        Day day2 = new Day("Tuesday");
        dayRepository.save(day2);

        Activity activity1 = new Activity("wash dishes", false, day1);
        activityRepository.save(activity1);
        day1.addNewActivity(activity1);
        dayRepository.save(day1);

//        Activity activity2 = new Activity("hoover floor", false, day1);
//        activityRepository.save(activity2);
//
//
//        Activity activity3 = new Activity("finish book", false, day2);
//        activityRepository.save(activity3);

    }

}
