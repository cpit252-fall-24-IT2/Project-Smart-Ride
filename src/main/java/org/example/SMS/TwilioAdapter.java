package org.example.SMS;

import com.twilio.Twilio;

public class TwilioAdapter implements SMSHander{

    public static final String ACCOUNT_SID = "";
    public static final String AUTH_TOKEN = "";

    public TwilioAdapter() {
        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
    }

    @Override
    public boolean sendMessage(String phone, String message) {
        return false;
    }
}
