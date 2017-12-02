package net.d3adliner.d3adliner.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Timeline {

    private ArrayList<Event> events;
    private Event curevent;

    public Timeline() {
        events = new ArrayList<Event>();
    }

    public void addEvent(Event event) {
        if (events.size() == 0) {
            curevent = event;
        }
        events.add(event);
    }

    public void removeEvent(Event event) {
        events.remove(event);
    }

    public ArrayList<Event> getEvents() {
        return new ArrayList<>(events);
    }

    public ArrayList<Event> getEventInADay(GregorianCalendar date) {
        int duration=0;
        ArrayList<Event> DailyEvent = new ArrayList<>();
        for (Event event : events) {
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
