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

    @Test
    public void canDeleteActivityFromList(){
        day.deleteActivity(activity);
        assertEquals(0, day.getList().size());
    }

    @Test
    public void canClearList(){
        Activity activity2 = new Activity("Brush teeth", false, day);
        day.addNewActivity(activity);
        day.addNewActivity(activity2);
        assertEquals(2, day.getList().size());
        day.emptyList();
        assertEquals(0, day.getList().size());
    }
}
