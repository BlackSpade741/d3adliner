import java.util.ArrayList;

public class Timeline{

    private ArrayList<Timev> events;
    public Timeline(){
        events = new ArrayList<Timev>();
    }
    public void addEvent(Timev event){
        events.add(event);
    }
    public void removeEvent(Timev event){
        events.remove(event);
    }
    public ArrayList<Timev> getEvents(){
        return new ArrayList<>(events);
    }

}
