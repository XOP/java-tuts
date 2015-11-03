package util;

import java.time.LocalDateTime;

public class CustomDate {
    private int year;
    private int month;
    private int day;
    private int hours;
    private int minutes;

    public LocalDateTime getDate() {
        return date;
    }

    private LocalDateTime date;

    public CustomDate(int year, int month, int day, int hours, int minutes) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hours = hours;
        this.minutes = minutes;

        dateFrom();
    }

    public void dateFrom() {
        date = LocalDateTime.of( year, month, day, hours, minutes);
    }
}
