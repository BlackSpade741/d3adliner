import java.util.ArrayList;

public class Timeline{

    private ArrayList<Timev> events;

    public Timeline(){
        events = new ArrayList<Timev>();
    }
    public void addEvent(Timev event){
        events.add(event);
    }
}
