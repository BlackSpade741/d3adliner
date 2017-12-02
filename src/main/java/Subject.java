package main.java;

import java.util.ArrayList;

public class Subject {
    ArrayList<Assignment> assignments;
    String name;

    public Subject(ArrayList<Assignment> assignments, String name) {
        if (assignments != null) {
            this.assignments = assignments;
        } else {
            this.assignments = new ArrayList<>();
        }
        this.name = name;
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }
}
