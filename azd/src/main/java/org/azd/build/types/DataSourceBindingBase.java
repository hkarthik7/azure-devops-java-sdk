package org.azd.build.types;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/**
 * A value that indicates whether builds can be queued against this definition. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataSourceBindingBase extends BaseAbstractMethod {
    /**
     * Pagination format supported by this data source(ContinuationToken/SkipTop).
     **/
    @JsonProperty("callbackContextTemplate")
    private String callbackContextTemplate;
    /**
     * Subsequent calls needed?
     **/
    @JsonProperty("callbackRequiredTemplate")
    private String callbackRequiredTemplate;
    /**
     * Gets or sets the name of the data source.
     **/
    @JsonProperty("dataSourceName")
    private String dataSourceName;
    /**
     * Gets or sets the endpoint Id.
     **/
    @JsonProperty("endpointId")
    private String endpointId;
    /**
     * Gets or sets the url of the service endpoint.
     **/
    @JsonProperty("endpointUrl")
    private String endpointUrl;
    /**
     * Gets or sets the authorization headers.
     **/
    @JsonProperty("headers")
    private List<AuthorizationHeader> headers;
    /**
     * Defines the initial value of the query params
     **/
    @JsonProperty("initialContextTemplate")
    private String initialContextTemplate;
    /**
     * Gets or sets the parameters for the data source.
     **/
    @JsonProperty("parameters")
    private Object parameters;
    /**
     * Gets or sets http request body
     **/
    @JsonProperty("requestContent")
    private String requestContent;
    /**
     * Gets or sets http request verb
     **/
    @JsonProperty("requestVerb")
    private String requestVerb;
    /**
     * Gets or sets the result selector.
     **/
    @JsonProperty("resultSelector")
    private String resultSelector;
    /**
     * Gets or sets the result template.
     **/
    @JsonProperty("resultTemplate")
    private String resultTemplate;
    /**
     * Gets or sets the target of the data source.
     **/
    @JsonProperty("target")
    private String target;

    public String getCallbackContextTemplate() {
        return callbackContextTemplate;
    }

    public void setCallbackContextTemplate(String callbackContextTemplate) {
        this.callbackContextTemplate = callbackContextTemplate;
    }

    public String getCallbackRequiredTemplate() {
        return callbackRequiredTemplate;
    }

    public void setCallbackRequiredTemplate(String callbackRequiredTemplate) {
        this.callbackRequiredTemplate = callbackRequiredTemplate;
    }

    public String getDataSourceName() {
        return dataSourceName;
    }

    public void setDataSourceName(String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }

    public String getEndpointId() {
        return endpointId;
    }

    public void setEndpointId(String endpointId) {
        this.endpointId = endpointId;
    }

    public String getEndpointUrl() {
        return endpointUrl;
    }

    public void setEndpointUrl(String endpointUrl) {
        this.endpointUrl = endpointUrl;
    }

    public List<AuthorizationHeader> getHeaders() {
        return headers;
    }

    public void setHeaders(List<AuthorizationHeader> headers) {
        this.headers = headers;
    }

    public String getInitialContextTemplate() {
        return initialContextTemplate;
    }

    public void setInitialContextTemplate(String initialContextTemplate) {
        this.initialContextTemplate = initialContextTemplate;
    }

    public Object getParameters() {
        return parameters;
    }

    public void setParameters(Object parameters) {
        this.parameters = parameters;
    }

    public String getRequestContent() {
        return requestContent;
    }

    public void setRequestContent(String requestContent) {
        this.requestContent = requestContent;
    }

    public String getRequestVerb() {
        return requestVerb;
    }

    public void setRequestVerb(String requestVerb) {
        this.requestVerb = requestVerb;
    }

    public String getResultSelector() {
        return resultSelector;
    }

    public void setResultSelector(String resultSelector) {
        this.resultSelector = resultSelector;
    }

    public String getResultTemplate() {
        return resultTemplate;
    }

    public void setResultTemplate(String resultTemplate) {
        this.resultTemplate = resultTemplate;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

}
