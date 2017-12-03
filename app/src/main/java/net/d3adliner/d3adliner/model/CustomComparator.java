package net.d3adliner.d3adliner.model;

public class CustomComparator {

    public CustomComparator(){}

    public static boolean compare(Event e1, Event e2) {
        return e1.getEventDate().before(e2.getEventDate());
    }
}
