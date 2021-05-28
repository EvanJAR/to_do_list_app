package com.project.to_do_list.models;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class DayTest {

    Day day;
    Activity activity;

    @Before
    public void before(){
        day = new Day("Tuesday");
        activity = new Activity("Make app", true, day);
    }

    @Test
    public void getName(){
        assertEquals("Tuesday", day.getName());
    }

    @Test
    public void listStartsEmpty(){
        assertEquals(0, day.getList().size());
    }

    @Test
    public void canAddActivityToList(){
        day.addNewActivity(activity);
        assertEquals(1, day.getList().size());
    }
}
