package main.java;

public class SmartPlanner {
    private Timeline schedule;
    private  Controller controller;
    public SmartPlanner(Controller controller, Timeline schedule) {
        this.controller = controller;
        this.schedule = schedule;
    }
}
