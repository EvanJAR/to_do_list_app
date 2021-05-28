package com.project.to_do_list.models;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class ActivityTest {

    Activity activity;
    Day day;


    @Before
    public void before() {
        day = new Day("Monday");
        activity = new Activity("Clean room", true, day);
    }

    @Test
    public void getDescription() {
        assertEquals("Clean room", activity.getDescription());
    }

    @Test
    public void getStatus() {
        activity.setFinished(true);
        assertEquals(true, activity.getFinished());
    }

}