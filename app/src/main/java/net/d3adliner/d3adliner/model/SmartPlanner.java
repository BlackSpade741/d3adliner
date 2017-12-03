package net.d3adliner.d3adliner.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;

public class SmartPlanner {
    private Timeline schedule;
    private  Controller controller;
    private ArrayList<Event> Initials;
    
    public SmartPlanner(Controller controller, Timeline schedule, ArrayList<Event> Initials) {
        this.controller = controller;
        this.schedule = schedule;
        this.Initials = Initials;
        AddInitialEvents();
    }
    public void AddInitialEvents(){
        for(Event ev:Initials){
            controller.addEvent(ev);
        }
    }
    public void Plan(){
        ArrayList events = schedule.getEvents();

        // events.sort((Comparator<? super T>) new CustomComparator());
    }
    public void addAssignment(GregorianCalendar dueDate,Time dueTime,String name){
        Assignment a = new Assignment(dueDate,dueTime,name);
        String t = Double.toString(dueTime.getHours()+1)+Double.toString(dueTime.getMinutes());
        int day=(int)(dueDate.getTimeInMillis()/(1000*60*60*24)-6);
        Event e1 = new Event(dueTime,new Time(t),new GregorianCalendar(1970,0,day),name, true,"ASSIGNMENT");
        controller.addEvent(e1);
    }
}
