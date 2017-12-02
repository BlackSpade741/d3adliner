package main.java;
public class Time {

    private double minutes;
    private double hours;

    public Time(String time){
        minutes = Double.parseDouble(time.substring(2));
        hours = Double.parseDouble(time.substring(0, 2));
    }

    public Time delta(Time t){
        double deltaMinutes = this.minutes - t.minutes;
        double deltaHours = this.hours - t.hours;
        String deltaTime = Double.toString(deltaHours) + Double.toString(deltaMinutes);
        return new Time(deltaTime);
    }

    public double getMinutes() {
        return minutes;
    }

    public double getHours() {
        return hours;
    }
}
