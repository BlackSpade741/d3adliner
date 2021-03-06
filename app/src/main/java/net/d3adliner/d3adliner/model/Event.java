package net.d3adliner.d3adliner.model;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;

public class Event {
    private static String[] EventTypes = {"LECTURE", "SPARE TIME", "FOOD","REST","COMMUTE","ASSIGNMENT"};
    private Time startTime;
    private Time endTime;
    private GregorianCalendar eventDate;
    private String title;
    private int duration;
    private boolean isFixed;
    private String type;
    private int year,month,day;
    public Event() {
    }
    public Event(Time startTime, Time endTime, int year, int month, int day, String title, boolean isFixed, String type) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
        this.isFixed = isFixed;
        this.type = type;
        this.year=year;
        this.month=month;
        this.day=day;
        this.eventDate = new GregorianCalendar(year, month, day);
        this.duration = endTime.delta(startTime);
        getReminder(10);
    }

    public Event(Time startTime, Time endTime, GregorianCalendar date, String title, boolean isFixed, String type) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
        this.isFixed = isFixed;
        this.type = type;
        this.eventDate = (GregorianCalendar) (date.clone());
        this.duration = endTime.delta(startTime);
        getReminder(10);
    }
    public void getReminder(int minutes){
        long min = eventDate.getTimeInMillis()+((long)startTime.getHours()*60*1000*60)+((long)startTime.getMinutes()*60*1000)-minutes;
        Date date = new Date(min);
        Timer t = new Timer();
        t.schedule(new Reminder(),date);
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
    public boolean getFixed(){return isFixed;}
    public Time getEndTime(){return endTime;}
    public int[] getNumDate(){
        return new int[]{year,month,day};
    }
    public String getType(){return type;}
    public void setStartTime(Time newTime){
        startTime = newTime;
    }
    public void setEndTime(Time newTime){
        endTime = newTime;
    }
}