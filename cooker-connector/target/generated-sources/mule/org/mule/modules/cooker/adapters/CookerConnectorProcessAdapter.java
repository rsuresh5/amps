
package org.mule.modules.cooker.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.cooker.CookerConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>CookerConnectorProcessAdapter</code> is a wrapper around {@link CookerConnector } that enables custom processing strategies.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-07-13T06:38:15+05:30", comments = "Build UNNAMED.2405.44720b7")
public class CookerConnectorProcessAdapter
    extends CookerConnectorLifecycleInjectionAdapter
    implements ProcessAdapter<CookerConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, CookerConnectorCapabilitiesAdapter> getProcessTemplate() {
        final CookerConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,CookerConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, CookerConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, CookerConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
