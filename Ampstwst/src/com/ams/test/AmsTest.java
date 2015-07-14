package com.ams.test;

import com.crankuptheamps.client.Client;
import com.crankuptheamps.client.exception.AMPSException;

public class AmsTest {

	public static void main(String[] args) {
        Client client = new Client("TestPublisher-Client");
        try {
            client.connect("tcp://10.24.14.16:9007/amps");
            client.logon();
            client.publish("messages", "{ \"message\" : \"Hello world1!\" } ");
        }
        catch (AMPSException aex) {
            System.err.println("TestListener caught exception.");
        } finally {
            client.close();
        }
    }

	}


