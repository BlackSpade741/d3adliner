package main.java;

import java.util.ArrayList;

public class Controller {
    private ArrayList<Reminder> reminders;
    private SmartPlanner Planner;
    private Timeline schedule;
    public Controller() {
    }

    public void planSchedule(Timeline schedule) {
    }

    ;

    public void adjustSchedule(Timeline schedule) {
    }
    public void addEvent(Event event){
        ArrayList<Event> events = schedule.getEventInADay(event.getEventDate());
    }

    public ArrayList<AssignmentStages> createStages() {
        return null;
    }
}
