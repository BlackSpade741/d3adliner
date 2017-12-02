package main.java;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Timeline {

    private ArrayList<Timev> events;
    private Timev curevent;

    public Timeline() {
        events = new ArrayList<Timev>();
    }

    public void addEvent(Timev event) {
        if (events.size() == 0) {
            curevent = event;
        }
        events.add(event);
    }

    public void removeEvent(Timev event) {
        events.remove(event);
    }

    public ArrayList<Timev> getEvents() {
        return new ArrayList<>(events);
    }

    public ArrayList<Timev> getEventInADay(GregorianCalendar date) {
        int duration=0;
        ArrayList<Timev> DailyEvent = new ArrayList<>();
        for (Timev event : events) {
           if(event.getEventDate().equals(date)){
               duration+=event.getDuration();
               DailyEvent.add(event);
           }
           if(duration==24*60){
               break;
           }
        }
        return DailyEvent;
    }

}
