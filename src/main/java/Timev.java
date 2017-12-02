package main.java;

import java.util.GregorianCalendar;

public class Timev {
    private static String[] EventTypes = {"LECTURE", "SPARE TIME", "FOOD"};
    private Time startTime;
    private Time endTime;
    private GregorianCalendar eventDate;
    private String title;
    private int duration;
    // priorityLevel runs from 0 - 9 : low - high
    private int priorityLevel;
    private String type;

    public Timev() {
    }

    public Timev(Time startTime, Time endTime, int year, int month, int day, String title, int priorityLevel, String type) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
        this.priorityLevel = priorityLevel;
        this.type = type;
        this.eventDate = new GregorianCalendar(year, month, day);
        this.duration = endTime.delta(startTime);
    }

    public int getDuration() {
        return duration;
    }
}