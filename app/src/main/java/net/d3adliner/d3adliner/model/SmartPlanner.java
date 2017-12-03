package net.d3adliner.d3adliner.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
}
