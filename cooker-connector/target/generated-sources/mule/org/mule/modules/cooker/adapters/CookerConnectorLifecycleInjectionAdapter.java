
package org.mule.modules.cooker.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleException;
import org.mule.api.lifecycle.Disposable;
import org.mule.api.lifecycle.Initialisable;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.lifecycle.Startable;
import org.mule.api.lifecycle.Stoppable;
import org.mule.common.MuleVersion;
import org.mule.config.MuleManifest;
import org.mule.config.i18n.CoreMessages;
import org.mule.modules.cooker.CookerConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * A <code>CookerConnectorLifecycleInjectionAdapter</code> is a wrapper around {@link CookerConnector } that adds lifecycle methods to the pojo.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-07-13T06:38:15+05:30", comments = "Build UNNAMED.2405.44720b7")
public class CookerConnectorLifecycleInjectionAdapter
    extends CookerConnectorMetadataAdapater
    implements Disposable, Initialisable, Startable, Stoppable
{


    @Override
    public void start()
        throws MuleException
    {
        super.initialize();
    }

    @Override
    public void stop()
        throws MuleException
    {
    }

    @Override
    public void initialise()
        throws InitialisationException
    {
        Logger log = LoggerFactory.getLogger(CookerConnectorLifecycleInjectionAdapter.class);
        MuleVersion connectorVersion = new MuleVersion("3.5.0");
        MuleVersion muleVersion = new MuleVersion(MuleManifest.getProductVersion());
        if (!muleVersion.atLeastBase(connectorVersion)) {
            throw new InitialisationException(CoreMessages.minMuleVersionNotMet(this.getMinMuleVersion()), this);
        }
    }

    @Override
    public void dispose() {
    }

}
