package main.java;

import java.sql.Time;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class RecurringEvent {
    private Time startTime;
    private Time endTime;
    private GregorianCalendar startDate;
    private GregorianCalendar endDate;
    private int repeatInterval;
    private String repeatType;
    private static final String[] REPEAT_TYPES = new String[]{"DAYS", "MONTHS", "WEEKS"};

    private List<Timev> listOfEvents;

    public RecurringEvent(){}

    public RecurringEvent(Time startTime, Time endTime, GregorianCalendar startDate,
                          GregorianCalendar endDate, int repeatInterval, String repeatType){
        
    }
}
