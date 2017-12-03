package net.d3adliner.d3adliner.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;

public class Assignment {
    private ArrayList<AssignmentStages> Stages;
    private AssignmentStages curStage;
    private Time dueTime;
    private String name;
    private boolean Complete = false;
    private GregorianCalendar dueDate;

    public Assignment(ArrayList<AssignmentStages> Stages, GregorianCalendar dueDate, Time dueTime, String name) {
        this.Stages = Stages;
        this.curStage = this.Stages.get(0);
        this.dueDate = dueDate;
        this.name = name;
        this.dueTime=dueTime;
    }
    public void getReminder(int minutes){
        long min = dueDate.getTimeInMillis()+((long)dueTime.getHours()*60*1000*60)+
                ((long)dueTime.getMinutes()*60*1000)-minutes;
        Date date = new Date(min);
        Timer t = new Timer();
        t.schedule(new Reminder(),date);
    }
    public void CheckStage() {
        if (curStage.CheckComplete()) {
            if (!(Stages.indexOf(curStage) == Stages.size() - 1)) {
                curStage = Stages.get(Stages.indexOf(curStage) + 1);
            } else {
                Complete = true;
            }
        }
    }

    public boolean CheckComplete() {
        return Complete;
    }
}
