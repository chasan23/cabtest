package com.cabtest.bean;

public class ModemConfiguration {
    private String port;
    private int bitRate;
    private String modemName;
    private String modemPin;
    private String smsc;

    public ModemConfiguration(String port, int bitRate, String modemName, String smsc, String modemPin) {
        this.port = port;
        this.smsc = smsc;
        this.modemName = modemName;
        this.bitRate = bitRate;
        this.modemPin = modemPin;
    }

    public String getPort() {
        return port;
    }

    public int getBitRate() {
        return bitRate;
    }

    public String getModemName() {
        return modemName;
    }

    public String getModemPin() {
        return modemPin;
    }

    public String getSmsc() {
        return smsc;
    }
}

