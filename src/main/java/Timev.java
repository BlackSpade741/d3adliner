package main.java;

public class Timev{
    private static String[] EventTypes={"LECTURE","SPARE TIME","FOOD"};
    private Time startTime;
    private Time endTime;
    private String title;
    private Time duration;
    // priorityLevel runs from 0 - 9 : low - high
    private  int priorityLevel;
    private String type;
    public Timev(){}

    public Timev(Time startTime, Time endTime,String title, int priorityLevel, String type){
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
        this.priorityLevel = priorityLevel;
        this.type = type;
        this.duration = new Time(Double.toString(Double.parseDouble(endTime.toString())-Double.parseDouble(startTime.toString())));
    }
    public Time getDuration(){
        return duration;
    }
}