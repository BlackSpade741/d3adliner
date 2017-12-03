package net.d3adliner.d3adliner.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Controller {
    private ArrayList<Reminder> reminders;
    private SmartPlanner Planner;
    private Timeline schedule;
    private  GregorianCalendar startDate;
    private GregorianCalendar endDate;
    public Controller(GregorianCalendar startDate, GregorianCalendar endDate, ArrayList<Event> Initials) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.schedule = new Timeline(this.startDate,this.endDate);
        this.Planner = new SmartPlanner(this,schedule,Initials);
        Planner.Plan();
    }



    public void adjustSchedule(Timeline schedule) {
    }
    public void addEvent(Event event){
        ArrayList<Event> events = schedule.getEventInADay(event.getEventDate());
        boolean contin= true;
        for(Event ev:events){
            if(event.getStartTime().getHours()>=ev.getStartTime().getHours()&&event.getEndTime().getHours()<=ev.getEndTime().getHours()
                    &&(ev.getType().equals("SPARE TIME")||!ev.getFixed())){
                schedule.addEvent(event);
                schedule.removeEvent(ev);
                NewSpareEvent(ev,event);
                contin = false;
            }
            }
        if (!contin) {
            for (Event ev : events) {
                if (ev.getType().equals("SPARE TIME")&&ev.getStartTime().getHours()>=12.0){
                    event.setStartTime(ev.getStartTime());
                    int dur = event.getDuration()/60;
                    int min = event.getDuration()%60;
                    String t = Double.toString(event.getStartTime().getHours()+dur)+
                            Double.toString(event.getStartTime().getMinutes()+min);
                    event.setEndTime(new Time(t));
                    schedule.addEvent(event);
                    schedule.removeEvent(ev);
                    NewSpareEvent(ev,event);
                }
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
