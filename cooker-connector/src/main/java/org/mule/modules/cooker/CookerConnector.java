/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.cooker;

import org.mule.api.annotations.ConnectionStrategy;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.Source;
import org.mule.api.annotations.SourceStrategy;
import org.mule.api.annotations.lifecycle.Start;
import org.mule.api.callback.SourceCallback;
import org.mule.modules.cooker.strategy.ConnectorConnectionStrategy;

import com.crankuptheamps.client.Client;
import com.crankuptheamps.client.Command;
import com.crankuptheamps.client.Message;
import com.crankuptheamps.client.MessageStream;
import com.crankuptheamps.client.exception.AMPSException;
import com.crankuptheamps.client.exception.ConnectionException;

/**
 * Anypoint Connector
 *
 * @author MuleSoft, Inc.
 */
@Connector(name = "cooker", friendlyName = "Cooker")
public class CookerConnector {

	@ConnectionStrategy
	ConnectorConnectionStrategy connectionStrategy;

	private Client client;

	@Start
	public void initialize() {
		/*client = new Client("subscribe");

		try {
			client.connect("tcp://10.24.14.16:9007/amps");
			client.logon();
		} catch (ConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}

	/**
	 * Dummy operation to avoid compilation issues since @Connector need at
	 * least on @Processor, @Transformer or @Source
	 */
	/*@Processor
	public void foo() {
		Command command = new Command("subscribe").setTopic("messages");
		client = new Client("subscribe");

		
			try {
				client.connect("tcp://10.24.14.16:9007/amps");
				client.logon();
			} catch (ConnectionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
		try (MessageStream ms = client.execute(command)) {
			for (Message m : ms) {
				System.out.println(m.getData());
			}
		} catch (AMPSException e) {
			;
		} finally {
			//client.close();
		}

	}
*/
	@Source(sourceStrategy = SourceStrategy.NONE)
	public void getRecentlyAddedSource(final SourceCallback callback)
			throws Exception {
		/*
		 * if (this.getConnectionStrategy().getReply() != null) { // Every 10
		 * seconds our callback will be executed
		 * this.getConfig().getClient().getRecentlyAdded(new ICookbookCallback()
		 * {
		 * 
		 * @Override public void execute(List<Recipe> recipes) throws Exception
		 * { callback.process(recipes); } });
		 * 
		 * if (Thread.interrupted()) { throw new InterruptedException(); }
		 */
		Command command = new Command("subscribe").setTopic("messages");
		client = new Client("subscribe");
		try {
			client.connect("tcp://10.24.14.16:9007/amps");
			client.logon();
		} catch (ConnectionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (MessageStream ms = client.execute(command)) {
			for (Message m : ms) {
				System.out.println(m.getData());
				callback.process(m);
			}
		} catch (AMPSException e) {
			;
		} finally {
			//client.close();
		}

	}

	public ConnectorConnectionStrategy getConnectionStrategy() {
		return connectionStrategy;
	}

	public void setConnectionStrategy(
			ConnectorConnectionStrategy connectionStrategy) {
		this.connectionStrategy = connectionStrategy;
	}

}