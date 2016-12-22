package com.sbertech.javaschool.messaging;

import com.sbertech.javaschool.model.UserInformationResponse;
import com.sbertech.javaschool.service.UserInformationResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

@Component
public class MessageReceiver {
    static final Logger LOGGER = LoggerFactory.getLogger(MessageReceiver.class);

    private static final String ORDER_RESPONSE_QUEUE = "order-response-queue";

    @Autowired
    UserInformationResponseService userInformationResponseService;


    @JmsListener(destination = ORDER_RESPONSE_QUEUE)
    public void receiveMessage(final Message<UserInformationResponse> message) throws JMSException {
        MessageHeaders headers = message.getHeaders();
        LOGGER.info("Application : headers received : {}", headers);

        UserInformationResponse response = message.getPayload();
        LOGGER.info("Application : response received : {}", response);

        userInformationResponseService.procedure(response);
    }
}
