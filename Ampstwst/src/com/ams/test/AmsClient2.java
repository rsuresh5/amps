package com.ams.test;

import com.crankuptheamps.client.Client;
import com.crankuptheamps.client.Command;
import com.crankuptheamps.client.CommandId;
import com.crankuptheamps.client.Message;
import com.crankuptheamps.client.MessageStream;
import com.crankuptheamps.client.exception.AMPSException;
import com.crankuptheamps.client.exception.ConnectionException;

public class AmsClient2 {

	public static void main(String[] args) {
		Client client = new Client("subscribe"); 
	    try {
	        client.connect("tcp://10.24.14.16:9007/amps");
	MessagePrinter mp = new MessagePrinter();
	       Command command = new Command("subscribe")
	                             .setTopic("messages");
	CommandId subscriptionId = client.executeAsync(command, mp); 
	client.wait();
	    }            
	    catch(AMPSException e){;} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    finally{ client.close(); }
	  }
	

	

}
