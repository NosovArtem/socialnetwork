package ru.nosov.javaschool.userinfo.messaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import ru.nosov.javaschool.userinfo.model.UserInformationResponse;


@Component
public class MessageSender {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendMessage(final UserInformationResponse userInformationResponse) {

		jmsTemplate.send(new MessageCreator(){
			@Override
			public Message createMessage(Session session) throws JMSException{
				ObjectMessage objectMessage = session.createObjectMessage(userInformationResponse);
				return objectMessage;
			}
		});
	}

}