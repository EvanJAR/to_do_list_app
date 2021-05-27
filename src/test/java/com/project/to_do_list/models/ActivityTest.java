package com.project.to_do_list.models;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class ActivityTest {

    Activity activity;


    @Before
    public void before() {
        activity = new Activity("Clean room", true);
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