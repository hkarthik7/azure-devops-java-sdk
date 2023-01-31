package org.azd.test.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * This is a temporary class to provide the details for the test run environment. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class DtlEnvironmentDetails extends BaseAbstractMethod {

	@JsonProperty("csmContent")
	private String csmContent;

	@JsonProperty("csmParameters")
	private String csmParameters;

	@JsonProperty("subscriptionName")
	private String subscriptionName;

	public String getCsmContent() { return csmContent; }

	public void setCsmContent(String csmContent) { this.csmContent = csmContent; }

	public String getCsmParameters() { return csmParameters; }

	public void setCsmParameters(String csmParameters) { this.csmParameters = csmParameters; }

	public String getSubscriptionName() { return subscriptionName; }

	public void setSubscriptionName(String subscriptionName) { this.subscriptionName = subscriptionName; }

}