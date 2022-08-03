package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;
import org.azd.common.types.BaseAbstractMethod;

import java.util.HashMap;
import java.util.Map;

/***
 * Represents a Work item internal field elements
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemFields extends BaseAbstractMethod {
    // for non-system (custom) fields
    Map<String, Object> otherFields = new HashMap<>();
    @JsonProperty("System.Id")
    private int systemId;
    @JsonProperty("System.AreaId")
    private int systemAreaId;
    @JsonProperty("System.AreaPath")
    private String systemAreaPath;
    @JsonProperty("System.TeamProject")
    private String systemTeamProject;
    @JsonProperty("System.NodeName")
    private String systemNodeName;
    @JsonProperty("System.AreaLevel1")
    private String systemAreaLevel1;
    @JsonProperty("System.Rev")
    private int systemRev;
    @JsonProperty("System.AuthorizedDate")
    private String systemAuthorizedDate;
    @JsonProperty("System.RevisedDate")
    private String systemRevisedDate;
    @JsonProperty("System.IterationId")
    private int systemIterationId;
    @JsonProperty("System.IterationPath")
    private String systemIterationPath;
    @JsonProperty("System.IterationLevel1")
    private String systemIterationLevel1;
    @JsonProperty("System.WorkItemType")
    private String systemWorkItemType;
    @JsonProperty("System.State")
    private String systemState;
    @JsonProperty("System.Reason")
    private String systemReason;
    @JsonProperty("System.AssignedTo")
    private Author systemAssignedTo;
    @JsonProperty("System.CreatedDate")
    private String SystemCreatedDate;
    @JsonProperty("System.CreatedBy")
    private Author systemCreatedBy;
    @JsonProperty("System.ChangedDate")
    private String systemChangedDate;
    @JsonProperty("System.ChangedBy")
    private Author systemChangedBy;
    @JsonProperty("System.AuthorizedAs")
    private Author systemAuthorizedAs;
    @JsonProperty("System.PersonId")
    private int systemPersonId;
    @JsonProperty("System.Watermark")
    private int systemWatermark;
    @JsonProperty("System.CommentCount")
    private int systemCommentCount;
    @JsonProperty("System.Title")
    private String systemTitle;
    @JsonProperty("System.BoardColumn")
    private String systemBoardColumn;
    @JsonProperty("System.BoardColumnDone")
    private boolean systemBoardColumnDone;
    @JsonProperty("Microsoft.VSTS.Scheduling.StoryPoints")
    private double storyPoints;
    @JsonProperty("Microsoft.VSTS.Common.StateChangeDate")
    private String stateChangeDate;
    @JsonProperty("Microsoft.VSTS.Common.ActivatedDate")
    private String activatedDate;
    @JsonProperty("Microsoft.VSTS.Common.ActivatedBy")
    private Author activatedBy;
    @JsonProperty("Microsoft.VSTS.Common.Priority")
    private int priority;
    @JsonProperty("Microsoft.VSTS.Common.Risk")
    private String risk;
    @JsonProperty("System.Description")
    private String systemDescription;
    @JsonProperty("Microsoft.VSTS.Common.AcceptanceCriteria")
    private String acceptanceCriteria;
    @JsonProperty("System.Tags")
    private String systemTags;

    // Capture all other fields that Jackson do not match other members
    @JsonAnyGetter
    public Map<String, Object> getOtherFields() {
        return otherFields;
    }

    public void setOtherFields(Map<String, Object> otherFieldsParam) {
        otherFields = otherFieldsParam;
    }

    @JsonAnySetter
    public void setOtherField(String name, Object value) {
        // TODO the value could be mappable to a reference, like a user/author
        otherFields.put(name, value);
    }

    public int getSystemAreaId() {
        return systemAreaId;
    }

    public void setSystemAreaId(int systemAreaId) {
        this.systemAreaId = systemAreaId;
    }

    public String getSystemAreaPath() {
        return systemAreaPath;
    }

    public void setSystemAreaPath(String systemAreaPath) {
        this.systemAreaPath = systemAreaPath;
    }

    public String getSystemTeamProject() {
        return systemTeamProject;
    }

    public void setSystemTeamProject(String systemTeamProject) {
        this.systemTeamProject = systemTeamProject;
    }

    public String getSystemNodeName() {
        return systemNodeName;
    }

    public void setSystemNodeName(String systemNodeName) {
        this.systemNodeName = systemNodeName;
    }

    public String getSystemAreaLevel1() {
        return systemAreaLevel1;
    }

    public void setSystemAreaLevel1(String systemAreaLevel1) {
        this.systemAreaLevel1 = systemAreaLevel1;
    }

    public int getSystemRev() {
        return systemRev;
    }

    public void setSystemRev(int systemRev) {
        this.systemRev = systemRev;
    }

    public String getSystemAuthorizedDate() {
        return systemAuthorizedDate;
    }

    public void setSystemAuthorizedDate(String systemAuthorizedDate) {
        this.systemAuthorizedDate = systemAuthorizedDate;
    }

    public String getSystemRevisedDate() {
        return systemRevisedDate;
    }

    public void setSystemRevisedDate(String systemRevisedDate) {
        this.systemRevisedDate = systemRevisedDate;
    }

    public int getSystemIterationId() {
        return systemIterationId;
    }

    public void setSystemIterationId(int systemIterationId) {
        this.systemIterationId = systemIterationId;
    }

    public String getSystemIterationPath() {
        return systemIterationPath;
    }

    public void setSystemIterationPath(String systemIterationPath) {
        this.systemIterationPath = systemIterationPath;
    }

    public String getSystemIterationLevel1() {
        return systemIterationLevel1;
    }

    public void setSystemIterationLevel1(String systemIterationLevel1) {
        this.systemIterationLevel1 = systemIterationLevel1;
    }

    public String getSystemWorkItemType() {
        return systemWorkItemType;
    }

    public void setSystemWorkItemType(String systemWorkItemType) {
        this.systemWorkItemType = systemWorkItemType;
    }

    public String getSystemState() {
        return systemState;
    }

    public void setSystemState(String systemState) {
        this.systemState = systemState;
    }

    public String getSystemReason() {
        return systemReason;
    }

    public void setSystemReason(String systemReason) {
        this.systemReason = systemReason;
    }

    public Author getSystemAssignedTo() {
        return systemAssignedTo;
    }

    public void setSystemAssignedTo(Author systemAssignedTo) {
        this.systemAssignedTo = systemAssignedTo;
    }

    public String getSystemCreatedDate() {
        return SystemCreatedDate;
    }

    public void setSystemCreatedDate(String systemCreatedDate) {
        SystemCreatedDate = systemCreatedDate;
    }

    public Author getSystemCreatedBy() {
        return systemCreatedBy;
    }

    public void setSystemCreatedBy(Author systemCreatedBy) {
        this.systemCreatedBy = systemCreatedBy;
    }

    public String getSystemChangedDate() {
        return systemChangedDate;
    }

    public void setSystemChangedDate(String systemChangedDate) {
        this.systemChangedDate = systemChangedDate;
    }

    public Author getSystemChangedBy() {
        return systemChangedBy;
    }

    public void setSystemChangedBy(Author systemChangedBy) {
        this.systemChangedBy = systemChangedBy;
    }

    public Author getSystemAuthorizedAs() {
        return systemAuthorizedAs;
    }

    public void setSystemAuthorizedAs(Author systemAuthorizedAs) {
        this.systemAuthorizedAs = systemAuthorizedAs;
    }

    public int getSystemPersonId() {
        return systemPersonId;
    }

    public void setSystemPersonId(int systemPersonId) {
        this.systemPersonId = systemPersonId;
    }

    public int getSystemWatermark() {
        return systemWatermark;
    }

    public void setSystemWatermark(int systemWatermark) {
        this.systemWatermark = systemWatermark;
    }

    public int getSystemCommentCount() {
        return systemCommentCount;
    }

    public void setSystemCommentCount(int systemCommentCount) {
        this.systemCommentCount = systemCommentCount;
    }

    public String getSystemTitle() {
        return systemTitle;
    }

    public void setSystemTitle(String systemTitle) {
        this.systemTitle = systemTitle;
    }

    public String getSystemBoardColumn() {
        return systemBoardColumn;
    }

    public void setSystemBoardColumn(String systemBoardColumn) {
        this.systemBoardColumn = systemBoardColumn;
    }

    public boolean isSystemBoardColumnDone() {
        return systemBoardColumnDone;
    }

    public void setSystemBoardColumnDone(boolean systemBoardColumnDone) {
        this.systemBoardColumnDone = systemBoardColumnDone;
    }

    public double getStoryPoints() {
        return storyPoints;
    }

    public void setStoryPoints(double storyPoints) {
        this.storyPoints = storyPoints;
    }

    public String getStateChangeDate() {
        return stateChangeDate;
    }

    public void setStateChangeDate(String stateChangeDate) {
        this.stateChangeDate = stateChangeDate;
    }

    public String getActivatedDate() {
        return activatedDate;
    }

    public void setActivatedDate(String activatedDate) {
        this.activatedDate = activatedDate;
    }

    public Author getActivatedBy() {
        return activatedBy;
    }

    public void setActivatedBy(Author activatedBy) {
        this.activatedBy = activatedBy;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public String getSystemDescription() {
        return systemDescription;
    }

    public void setSystemDescription(String systemDescription) {
        this.systemDescription = systemDescription;
    }

    public String getAcceptanceCriteria() {
        return acceptanceCriteria;
    }

    public void setAcceptanceCriteria(String acceptanceCriteria) {
        this.acceptanceCriteria = acceptanceCriteria;
    }

    public String getSystemTags() {
        return systemTags;
    }

    public void setSystemTags(String systemTags) {
        this.systemTags = systemTags;
    }


    public int getSystemId() {
        return systemId;
    }

    public void setSystemId(int systemId) {
        this.systemId = systemId;
    }

}
