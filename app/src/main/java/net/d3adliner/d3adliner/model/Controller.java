package net.d3adliner.d3adliner.model;

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
        for(Event ev:events){
            if(event.getStartTime().getHours()>=ev.getStartTime().getHours()&&event.getEndTime().getHours()<=ev.getEndTime().getHours()){
                schedule.addEvent(event);
                schedule.removeEvent(ev);
                NewSpareEvent(ev,event);
            }
        }
    }
    public void NewSpareEvent(Event OSpare,Event event){
        if(!(event.getStartTime().getHours()==OSpare.getStartTime().getHours()){
            if(event.getStartTime().getHours()==OSpare.getStartTime().getHours()) {
                Time start = event.getEndTime();
                Time end  = OSpare.getEndTime();
                int[] date = event.getNumDate();
                Event Nspare = new Event(start,end,date[0],date[1],date[2],"SPARE TIME",false,"SPARE TIME")
            }
            else {
                Time start = OSpare.getStartTime();
                Time end  = event.getStartTime();
                int[] date = event.getNumDate();
                Event Nspare = new Event(start,end,date[0],date[1],date[2],"SPARE TIME",false,"SPARE TIME")
            }
        }
    }
}

    public ArrayList<AssignmentStages> createStages() {
        return null;
    }
}
