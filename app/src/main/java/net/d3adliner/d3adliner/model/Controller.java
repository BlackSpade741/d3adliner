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
        Event Nspare=null;
        Event Nspare2 = null;
            if(event.getStartTime().getHours()==OSpare.getStartTime().getHours()) {
                Time start = event.getEndTime();
                Time end  = OSpare.getEndTime();
                int[] date = event.getNumDate();
                Nspare = new Event(start,end,date[0],date[1],date[2],"SPARE TIME",false,"SPARE TIME");
            }
            else if(event.getEndTime().getHours()==OSpare.getEndTime().getHours()){
                Time start = OSpare.getStartTime();
                Time end  = event.getStartTime();
                int[] date = event.getNumDate();
                Nspare = new Event(start,end,date[0],date[1],date[2],"SPARE TIME",false,"SPARE TIME");
            }
            else{
                Time start = OSpare.getStartTime();
                Time end  = event.getStartTime();
                int[] date = event.getNumDate();
                Nspare = new Event(start,end,date[0],date[1],date[2],"SPARE TIME",false,"SPARE TIME");
                schedule.addEvent(Nspare);
                start = event.getEndTime();
                end  = OSpare.getEndTime();
                Nspare = new Event(start,end,date[0],date[1],date[2],"SPARE TIME",false,"SPARE TIME");
            }
        schedule.addEvent(Nspare);
        }
    public ArrayList<AssignmentStages> createStages() {
        return null;
    }
}
