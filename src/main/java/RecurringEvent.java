package main.java;

import main.java.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class RecurringEvent {
    private Time startTime;
    private Time endTime;
    private GregorianCalendar startDate;
    private GregorianCalendar endDate;
    private String title, type;
    private int repeatInterval;
    private String repeatType;
    private boolean fixed;
    private static final List<String> REPEAT_TYPES = Arrays.asList("DAYS", "MONTHS", "WEEKS");

    private List<Timev> listOfEvents;

    public RecurringEvent(){}

    public RecurringEvent(Time startTime, Time endTime, GregorianCalendar startDate,
                          GregorianCalendar endDate, String title, boolean fixed, String type, int repeatInterval, String repeatType){
        assert REPEAT_TYPES.contains(repeatType);
        assert startTime.delta(endTime) >= 0;
        assert startDate.compareTo(endDate) <= 0;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.repeatInterval = repeatInterval;
        this.repeatType = repeatType;
        this.title = title;
        this.fixed = fixed;
        this.type = type;
        generateEvents();
    }

    private void generateEvents(){
        switch(repeatType){
            case "DAYS":

                break;
            case "WEEKS":
                break;
            case "MONTHS":
                break;
            default:
                throw new IllegalArgumentException("Illegal repeat type");
        }
        GregorianCalendar curDate = (GregorianCalendar)startDate.clone();
        while (curDate.compareTo(endDate) <= 0){
            Timev event = new Timev(startTime, endTime, curDate, title, fixed, type);
            listOfEvents.add(event);
        }
    }
}
