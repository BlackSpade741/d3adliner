package net.d3adliner.d3adliner.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Controller {
    private ArrayList<Reminder> reminders;
    private SmartPlanner Planner;
    private Timeline schedule;
    public Controller() {
        this.schedule = new Timeline();
        this.Planner = new SmartPlanner(this,schedule);
        Planner.Plan();
    }



    public void adjustSchedule(Timeline schedule) {
    }
    public void addEvent(Event event){
        ArrayList<Event> events = schedule.getEventInADay(event.getEventDate());
        for(Event ev:events){
            if(event.getStartTime().getHours()>=ev.getStartTime().getHours()&&event.getEndTime().getHours()<=ev.getEndTime().getHours()
                    &&ev.getType().equals("SPARE TIME")){
                schedule.addEvent(event);
                schedule.removeEvent(ev);
                NewSpareEvent(ev,event);
            }
        }
    }
    public void NewSpareEvent(Event OSpare,Event event){
        Event Nspare=null;
        GregorianCalendar date = event.getEventDate();
        if(event.getStartTime().getHours()==OSpare.getStartTime().getHours()) {
            Time start = event.getEndTime();
            Time end  = OSpare.getEndTime();
            Nspare = new Event(start,end,date,"SPARE TIME",false,"SPARE TIME");
        }
        else if(event.getEndTime().getHours()==OSpare.getEndTime().getHours()){
            Time start = OSpare.getStartTime();
            Time end  = event.getStartTime();
            Nspare = new Event(start,end,date,"SPARE TIME",false,"SPARE TIME");
        }
        else{
            Time start = OSpare.getStartTime();
            Time end  = event.getStartTime();
            Nspare = new Event(start,end,date,"SPARE TIME",false,"SPARE TIME");
            schedule.addEvent(Nspare);
            start = event.getEndTime();
            end  = OSpare.getEndTime();
            Nspare = new Event(start,end,date,"SPARE TIME",false,"SPARE TIME");
        }
        schedule.addEvent(Nspare);
    }
    public ArrayList<AssignmentStages> createStages() {
        return null;
    }
}
