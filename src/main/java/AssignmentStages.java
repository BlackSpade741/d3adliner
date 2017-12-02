package main.java;
import java.util.ArrayList;

public class AssignmentStages {
    private ArrayList<Timev> events;
    private ArrayList<Timev> TodoEvents;
    private ArrayList<Timev> CompletedEvents;
    private boolean StageComplete;
    public AssignmentStages(ArrayList<Timev> events){
        this.events = events;
        this.TodoEvents = new ArrayList<>(events);
    }
    public ArrayList<Timev> getEvents(){return new ArrayList<>(events);}
    public void CheckOffEvent(Timev event){
        TodoEvents.remove(event);
        if(TodoEvents.size()==0){
            StageComplete=true;
        }
        CompletedEvents.add(event);
    }
    public boolean CheckComplete(){return StageComplete;}
}
