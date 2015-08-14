package com.cabtest.service;

import com.cabtest.ConfigurationBuilder;
import com.cabtest.bean.ModemConfiguration;
import com.cabtest.bean.SMSMessage;
import com.harshadura.gsm.smsdura.GsmModem;
import org.apache.log4j.Logger;

public class SendSMSServiceImpl implements SendSMSService {

    private static final Logger LOG = Logger.getLogger(SendSMSServiceImpl.class);

    @Override
    public void send(SMSMessage smsMessage) {
        try {
            GsmModem gsmModem = new GsmModem();
            ModemConfiguration modemConfiguration = ConfigurationBuilder.getModemConfiguration();
            GsmModem.configModem(modemConfiguration.getPort(), modemConfiguration.getBitRate(), modemConfiguration.getModemName(),
                    modemConfiguration.getModemPin(), modemConfiguration.getSmsc());
            gsmModem.Sender(smsMessage.getMessage(), smsMessage.getMobileNumber());
        } catch (Exception e) {
            LOG.warn("Error while sending SMS to : " + smsMessage.getMobileNumber());
        }
    }
}
