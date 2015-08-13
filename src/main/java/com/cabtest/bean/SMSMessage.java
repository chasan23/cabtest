package com.cabtest.bean;

public class SMSMessage {
    private String mobileNumber;
    private String message;

    public SMSMessage(String mobileNumber, String message) {
        this.mobileNumber = mobileNumber;
        this.message = message;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getMessage() {
        return message;
    }
}
