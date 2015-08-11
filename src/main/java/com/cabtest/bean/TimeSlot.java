package com.cabtest.bean;

public class TimeSlot {

    private int value;

    public TimeSlot(int value) {
        this.value = value;
    }

    public TimeSlot(double value) {
        this.value = (int) value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TimeSlot add(TimeSlot timeSlot) {
        return new TimeSlot(value + timeSlot.getValue());
    }
}
