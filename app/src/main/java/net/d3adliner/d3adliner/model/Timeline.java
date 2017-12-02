package net.d3adliner.d3adliner.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Timeline {

    private ArrayList<Event> events;
    private Event curevent;
    private  GregorianCalendar startDate;
    private GregorianCalendar endDate;
    public Timeline(GregorianCalendar startDate, GregorianCalendar endDate) {
        events = new ArrayList<Event>();
        this.startDate = startDate;
        this.endDate = endDate;
        long DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
        int diffInDays = (int) ((endDate.getTimeInMillis() - startDate.getTimeInMillis())/ DAY_IN_MILLIS );
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        for(int i=1;i<=diffInDays;i++){
            events.add(new Event(new Time("0000"),new Time("2400"),new GregorianCalendar(year,month,i),
                    "SPARE TIME",false,"SPARE TIME"));
        }
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
