package main.java;
import java.util.ArrayList;

public class Assignment {
    ArrayList<AssignmentStages> Stages;
    AssignmentStages curStage;
    Time dueDate;
    String name;
    public Assignment(ArrayList<AssignmentStages> Stages,Time dueDate, String name){
        this.Stages = Stages;
        this.curStage = this.Stages.get(0);
        this.dueDate = dueDate;
        this.name = name;
    }
    public void CheckStage(){
        if(curStage.CheckComplete()){
            if(!(Stages.indexOf(curStage)==Stages.size()-1)){

        curStage = Stages.get(Stages.indexOf(curStage)+1);}
    }}
}
