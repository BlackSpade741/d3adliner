package main.java;

import java.util.ArrayList;

public class AssignmentStages {
    private ArrayList<Event> events;
    private ArrayList<Event> TodoEvents;
    private ArrayList<Event> CompletedEvents;
    private boolean StageComplete;

    public AssignmentStages(ArrayList<Event> events) {
        this.events = events;
        this.TodoEvents = new ArrayList<>(events);
    }

    public ArrayList<Event> getEvents() {
        return new ArrayList<>(events);
    }

    public void CheckOffEvent(Event event) {
        TodoEvents.remove(event);
        if (TodoEvents.size() == 0) {
            StageComplete = true;
        }
        CompletedEvents.add(event);
    }

    public boolean CheckComplete() {
        return StageComplete;
    }
}
