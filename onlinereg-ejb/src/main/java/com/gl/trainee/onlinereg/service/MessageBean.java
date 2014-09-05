package com.gl.trainee.onlinereg.service;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

//@MessageDriven(activationConfig =
//{@ActivationConfigProperty(propertyName="destinationType",
//    propertyValue="javax.jms.Queue"),
// @ActivationConfigProperty(propertyName="destinationName",
//    propertyValue="jms/Queue")
//})
public class MessageBean implements MessageListener{

	@Override
	public void onMessage(Message msg) {
		
		ObjectMessage om = null;
		
		
	}

}
