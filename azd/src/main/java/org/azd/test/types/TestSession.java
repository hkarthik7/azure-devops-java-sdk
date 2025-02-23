package org.azd.test.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.enums.TestSessionSource;
import org.azd.enums.TestSessionState;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TestSession extends SerializableEntity {
    /**
     * Area path of the test session
     */
    @JsonProperty("area")
    private ShallowReference area;

    /**
     * Comments in the test session
     */
    @JsonProperty("comment")
    private String comment;

    /**
     Duration of the session
     */
    @JsonProperty("endDate")
    private String endDate;

    /**
     * Id of the test session
     */
    @JsonProperty("id")
    private Integer id;

    /**
     * Last Updated By Reference
     */
    @JsonProperty("lastUpdatedBy")
    private IdentityRef lastUpdatedBy;

    /**
     * Last updated date
     */
    @JsonProperty("lastUpdatedDate")
    private String lastUpdatedDate;

    /**
     * Owner of the test session
     */
    @JsonProperty("owner")
    private IdentityRef owner;

    /**
     * Project to which the test session belongs
     */

    @JsonProperty("project")
    private ShallowReference project;

    /**
     * Generic store for test session data
     */
    @JsonProperty("propertyBag")
    private	PropertyBag propertyBag;

    /**
     * Revision of the test session
     */
    @JsonProperty("revision")
    private Integer revision;

    /**
     * Source of the test session
     */
    @JsonProperty("source")
    private TestSessionSource source;

    /**
     * Start date
     */
    @JsonProperty("startDate")
    private String startDate;

    /**
     * State of the test session
     */
    @JsonProperty("state")
    private TestSessionState state;

    /**
     * Title of the test session
     */
    @JsonProperty("title")
    private String title;

    /**
     * Url of Test Session Resource
     */
    @JsonProperty("url")
    private String url;

    public ShallowReference getArea() {
        return area;
    }

    public void setArea(ShallowReference area) {
        this.area = area;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public IdentityRef getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(IdentityRef lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public IdentityRef getOwner() {
        return owner;
    }

    public void setOwner(IdentityRef owner) {
        this.owner = owner;
    }

    public ShallowReference getProject() {
        return project;
    }

    public void setProject(ShallowReference project) {
        this.project = project;
    }

    public PropertyBag getPropertyBag() {
        return propertyBag;
    }

    public void setPropertyBag(PropertyBag propertyBag) {
        this.propertyBag = propertyBag;
    }

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public TestSessionSource getSource() {
        return source;
    }

    public void setSource(TestSessionSource source) {
        this.source = source;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public TestSessionState getState() {
        return state;
    }

    public void setState(TestSessionState state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
