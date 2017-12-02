package main.java;

import java.util.GregorianCalendar;

public class Event {
    private static String[] EventTypes = {"LECTURE", "SPARE TIME", "FOOD"};
    private Time startTime;
    private Time endTime;
    private GregorianCalendar eventDate;
    private String title;
    private int duration;
    private boolean isFixed;
    private String type;

    public Event() {
    }

    public Event(Time startTime, Time endTime, int year, int month, int day, String title, boolean isFixed, String type) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
        this.isFixed = isFixed;
        this.type = type;
        this.eventDate = new GregorianCalendar(year, month, day);
        this.duration = endTime.delta(startTime);
    }

    public Event(Time startTime, Time endTime, GregorianCalendar date, String title, boolean isFixed, String type) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
        this.isFixed = isFixed;
        this.type = type;
        this.eventDate = (GregorianCalendar) (date.clone());
        this.duration = endTime.delta(startTime);
    }

    public GregorianCalendar getEventDate() {
        return eventDate;
    }
    public int getDuration() {
        return duration;
    }
    public Time getStartTime(){
        return startTime;
    }
    public Time getEndTime(){return endTime;}
}