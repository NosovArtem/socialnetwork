package ru.nosov.javaschool.userinfo.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;
import ru.nosov.javaschool.userinfo.model.UserInformationResponse;
import ru.nosov.javaschool.userinfo.service.UserInformationService;

import javax.jms.JMSException;

@Component
public class MessageReceiver {
	static final Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);

	private static final String ORDER_QUEUE = "order-queue";
	
	@Autowired
	UserInformationService userInformationService;
	
	
	@JmsListener(destination = ORDER_QUEUE)
	public void receiveMessage(final Message<UserInformationResponse> message) throws JMSException {
		LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		MessageHeaders headers =  message.getHeaders();
		LOG.info("Application : headers received : {}", headers);

		UserInformationResponse userInformationResponse = message.getPayload();
		LOG.info("Application : response received : {}",userInformationResponse);

		userInformationService.procedure(userInformationResponse);
		LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
}
