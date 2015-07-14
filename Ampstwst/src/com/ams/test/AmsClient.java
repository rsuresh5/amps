package com.ams.test;

import com.crankuptheamps.client.Client;
import com.crankuptheamps.client.Command;
import com.crankuptheamps.client.Message;
import com.crankuptheamps.client.MessageStream;
import com.crankuptheamps.client.exception.AMPSException;
import com.crankuptheamps.client.exception.ConnectionException;

public class AmsClient {

	public static void main(String[] args) {
		Client client = new Client("subscribe");
	       try
	       {
	         client.connect("tcp://10.24.14.16:9007/amps");
	         client.logon();
	Command command = new Command("subscribe")
	                                            .setTopic("messages");
	try (MessageStream ms = client.execute(command)){
	         for (Message m : ms)
	         {
	System.out.println(m.getData());
	
	         }
	       }
	       catch(AMPSException e){;}
	      finally{ client.close(); } 
	    } catch (ConnectionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally{ } 
	}

	

}
