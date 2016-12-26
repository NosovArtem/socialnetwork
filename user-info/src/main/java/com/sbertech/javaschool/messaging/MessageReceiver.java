package com.sbertech.javaschool.messaging;

import com.sbertech.javaschool.messaging.dto.UserInformationDTO;
import com.sbertech.javaschool.service.UserInformationService;
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

    private static final String ORDER_QUEUE = "queue";

    @Autowired
    UserInformationService userInformationService;

    @JmsListener(destination = ORDER_QUEUE)
    public void receiveMessage(final Message<UserInformationDTO> message) throws JMSException {
        MessageHeaders headers = message.getHeaders();
        LOGGER.info("Application : headers received : {}", headers);

        UserInformationDTO userInformationDTO = message.getPayload();
        LOGGER.info("Application : response received : {}", userInformationDTO);

        userInformationService.procedure(userInformationDTO);
    }
}
