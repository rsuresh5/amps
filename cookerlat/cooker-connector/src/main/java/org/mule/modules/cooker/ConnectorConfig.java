/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.cooker;

import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.components.Configuration;
import org.mule.api.annotations.param.Default;

/**
 * Configuration type Config
 *
 * @author MuleSoft, Inc.
 */
@Configuration(configElementName = "config-type", friendlyName = "Configuration type config")
public class ConnectorConfig {

	/**
	 * Description for address
	 */
	@Configurable
	@Default("tcp://10.24.14.16:9007/amps")
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}