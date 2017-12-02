package main.java;

import java.util.ArrayList;

public class Assignment {
    private ArrayList<AssignmentStages> Stages;
    private AssignmentStages curStage;
    private Time dueDate;
    private String name;
    private boolean Complete = false;

    public Assignment(ArrayList<AssignmentStages> Stages, Time dueDate, String name) {
        this.Stages = Stages;
        this.curStage = this.Stages.get(0);
        this.dueDate = dueDate;
        this.name = name;
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
