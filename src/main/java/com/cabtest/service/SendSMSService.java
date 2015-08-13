package com.cabtest.service;

import com.cabtest.bean.SMSMessage;

public interface SendSMSService {
    void send(SMSMessage smsMessage);
}
