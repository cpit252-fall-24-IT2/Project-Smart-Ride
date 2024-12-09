package org.example.SMS;

import com.twilio.*;

public class TwilioAdapter implements SMSHander{

    public static final String ACCOUNT_SID = "";
    public static final String AUTH_TOKEN = "";

    public TwilioAdapter() {
    }

    @Override
    public boolean sendMessage(String phone, String message) {
        return false;
    }
}
