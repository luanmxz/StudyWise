package com.dev.luan.studywise.application.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class SmsService {

    @Value("${twilio.account-sid}")
    private static String twilioAccountSid;

    @Value("${twilio.auth-token}")
    private static String twilioAuthToken;

    @Value("${twilio.phone-number}")
    private static String twilioPhoneNumber;

    /** Account SID em variável de ambiente */
    private static final String ACCOUNT_SID = twilioAccountSid;
    /** Auth Token em variável de ambiente */
    private static final String AUTH_TOKEN = twilioAuthToken;
    static {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    /**
     * Busca a última mensagem SMS recebida no número Twilio configurado.
     * 
     * @param fromNumber número do remetente (opcional, pode filtrar)
     * @return corpo da última mensagem ou null se não houver
     */
    public String getLastSms(String fromNumber) {
        // 1) Leitura retorna ResourceSet<Message>
        ResourceSet<Message> messages = Message.reader()
                .setTo(new com.twilio.type.PhoneNumber(twilioPhoneNumber))
                .limit(1)
                .read(); // ← ResourceSet<Message> :contentReference[oaicite:1]{index=1}

        // 2) Itera (ou usa iterator().next()) para acessar o body
        if (!messages.iterator().hasNext()) {
            return null;
        }
        return messages.iterator().next().getBody();
    }
}
