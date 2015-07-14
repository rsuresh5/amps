package com.ams.test;

import com.crankuptheamps.client.Message;
import com.crankuptheamps.client.MessageHandler;

public class MessagePrinter implements MessageHandler{

	@Override
	public void invoke(Message m) {
		 System.out.println(m.getData());
		
	}

}
