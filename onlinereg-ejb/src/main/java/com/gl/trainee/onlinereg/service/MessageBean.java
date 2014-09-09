package com.gl.trainee.onlinereg.service;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.gl.trainee.onlinereg.mail.TLSEmail;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destinationJndiName", propertyValue = "onlinereg/jms/email") })
public class MessageBean implements MessageListener {

	private TLSEmail sender;

	@Override
	public void onMessage(Message msg){

		try {

			final TextMessage textMessage = (TextMessage) msg;
			String email = textMessage.getText();
			System.out.println(email);

		
				sender.sendEmail(email);
	

		} catch (Exception e) {
			//throw new IllegalStateException(e);
		}

	}

}
