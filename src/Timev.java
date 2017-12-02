import java.sql.Time;

public class Timev{
    private Time startTime;
    private Time endTime;
    private String title;
    // priorityLevel runs from 0 - 9 : low - high
    private  int priorityLevel;
    public Timev(){}

    public Timev(Time startTime, Time endTime,String title, int priorityLevel){
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
        this.priorityLevel = priorityLevel;
    }


}