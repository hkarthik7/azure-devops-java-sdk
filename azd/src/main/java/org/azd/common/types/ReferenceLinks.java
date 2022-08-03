package org.azd.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Represents all reference links commonly used across the services
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReferenceLinks extends BaseAbstractMethod {
    /***
     * Service link
     */
    @JsonProperty("self")
    private Reference self;
    /***
     * Represents a work item update link
     */
    @JsonProperty("workItemUpdates")
    private Reference workItemUpdates;
    /***
     * Work item revision link
     */
    @JsonProperty("workItemRevisions")
    private Reference workItemRevisions;
    /***
     * Work item comments link
     */
    @JsonProperty("workItemComments")
    private Reference workItemComments;
    /***
     * Html reference link
     */
    @JsonProperty("html")
    private Reference html;
    /***
     * Work item type link
     */
    @JsonProperty("workItemType")
    private Reference workItemType;
    /***
     * Link to fields
     */
    @JsonProperty("fields")
    private Reference fields;
    /***
     * Avatar
     */
    @JsonProperty("avatar")
    private Reference avatar;
    /***
     * Project link
     */
    @JsonProperty("project")
    private Reference project;
    /***
     * Team project link
     */
    @JsonProperty("team")
    private Reference team;
    /***
     * Team iteration link
     */
    @JsonProperty("teamIteration")
    private Reference teamIteration;
    /***
     * Packages link
     */
    @JsonProperty("packages")
    private Reference packages;
    /***
     * Permissions
     */
    @JsonProperty("permissions")
    private Reference permissions;
    /***
     * Link to Artifacts feed
     */
    @JsonProperty("feed")
    private Reference feed;
    /***
     * Source version display uri link
     */
    @JsonProperty("sourceVersionDisplayUri")
    private Reference sourceVersionDisplayUri;
    /***
     * Time line link
     */
    @JsonProperty("timeline")
    private Reference timeline;
    /***
     * Badge
     */
    @JsonProperty("badge")
    private Reference badge;
    /***
     * Web
     */
    @JsonProperty("web")
    private Reference web;
    /***
     * Editor
     */
    @JsonProperty("editor")
    private Reference editor;


    public Reference getSourceVersionDisplayUri() {
        return sourceVersionDisplayUri;
    }

    public void setSourceVersionDisplayUri(Reference sourceVersionDisplayUri) {
        this.sourceVersionDisplayUri = sourceVersionDisplayUri;
    }

    public Reference getTimeline() {
        return timeline;
    }

    public void setTimeline(Reference timeline) {
        this.timeline = timeline;
    }

    public Reference getBadge() {
        return badge;
    }

    public void setBadge(Reference badge) {
        this.badge = badge;
    }

    public Reference getWeb() {
        return web;
    }

    public void setWeb(Reference web) {
        this.web = web;
    }

    public Reference getFeed() {
        return feed;
    }

    public void setFeed(Reference feed) {
        this.feed = feed;
    }

    public Reference getPackages() {
        return packages;
    }

    public void setPackages(Reference packages) {
        this.packages = packages;
    }

    public Reference getPermissions() {
        return permissions;
    }

    public void setPermissions(Reference permissions) {
        this.permissions = permissions;
    }

    public Reference getProject() {
        return project;
    }

    public void setProject(Reference project) {
        this.project = project;
    }

    public Reference getTeam() {
        return team;
    }

    public void setTeam(Reference team) {
        this.team = team;
    }

    public Reference getTeamIteration() {
        return teamIteration;
    }

    public void setTeamIteration(Reference teamIteration) {
        this.teamIteration = teamIteration;
    }

    public Reference getAvatar() {
        return avatar;
    }

    public void setAvatar(Reference avatar) {
        this.avatar = avatar;
    }

    public Reference getSelf() {
        return self;
    }

    public void setSelf(Reference self) {
        this.self = self;
    }

    public Reference getWorkItemUpdates() {
        return workItemUpdates;
    }

    public void setWorkItemUpdates(Reference workItemUpdates) {
        this.workItemUpdates = workItemUpdates;
    }

    public Reference getWorkItemRevisions() {
        return workItemRevisions;
    }

    public void setWorkItemRevisions(Reference workItemRevisions) {
        this.workItemRevisions = workItemRevisions;
    }

    public Reference getWorkItemComments() {
        return workItemComments;
    }

    public void setWorkItemComments(Reference workItemComments) {
        this.workItemComments = workItemComments;
    }

    public Reference getHtml() {
        return html;
    }

    public void setHtml(Reference html) {
        this.html = html;
    }

    public Reference getWorkItemType() {
        return workItemType;
    }

    public void setWorkItemType(Reference workItemType) {
        this.workItemType = workItemType;
    }

    public Reference getFields() {
        return fields;
    }

    public void setFields(Reference fields) {
        this.fields = fields;
    }

    public Reference getEditor() {
        return editor;
    }

    public void setEditor(Reference fields) {
        this.editor = editor;
    }

}
