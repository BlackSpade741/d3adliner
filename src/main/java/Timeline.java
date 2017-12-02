package main.java;
import java.util.ArrayList;

public class Timeline{

    private ArrayList<Timev> events;
    private Timev curevent;
    public Timeline(){
        events = new ArrayList<Timev>();
    }
    public void addEvent(Timev event){
        if(events.size()==0){
            curevent=event;
        }
        events.add(event);
    }
    public void removeEvent(Timev event){
        events.remove(event);
    }
    public ArrayList<Timev> getEvents(){
        return new ArrayList<>(events);
    }
    public ArrayList<Timev> getEventInADay () {
        Double hour = 0.0;
        ArrayList<Timev> DailyEvent = new ArrayList<>();
        for (Timev event : events) {
            hour+=event.getDuration();
            if(hour<=24.0){
                DailyEvent.add(event);
            }
        }
        return DailyEvent;
    }

}
