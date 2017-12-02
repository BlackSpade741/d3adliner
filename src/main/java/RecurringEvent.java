package main.java;

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
    private static final List<String> REPEAT_TYPES = Arrays.asList("DAYS", "MONTHS", "WEEKS", "YEARS");

    private List<Event> listOfEvents;

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
        GregorianCalendar curDate = (GregorianCalendar)startDate.clone();
        while (curDate.compareTo(endDate) <= 0){
            if (repeatType.equals("MONTHS")){
                switch(startDate.get(Calendar.DAY_OF_MONTH)){
                    case 29:
                    case 30:
                        if(curDate.get(Calendar.MONTH) == 2) continue;
                        break;
                    case 31:
                        if(Arrays.asList(2, 4, 6, 9, 11).contains(curDate.get(Calendar.MONTH)))continue;
                        break;
                }
            }
            Event event = new Event(startTime, endTime, curDate, title, fixed, type);
            listOfEvents.add(event);
            curDate.add(getIntRepeatType(), repeatInterval);
        }
    }

    private int getIntRepeatType(){
        switch(repeatType){
            case "DAYS":
                return Calendar.DAY_OF_YEAR;
            case "WEEKS":
                return Calendar.WEEK_OF_YEAR;
            case "MONTHS":
                return Calendar.MONTH;
            case "YEARS":
                return Calendar.YEAR;
            default:
                throw new IllegalArgumentException("Illegal repeat type");
        }
    }

}
