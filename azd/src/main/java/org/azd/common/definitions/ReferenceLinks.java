package org.azd.common.definitions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReferenceLinks {
    @JsonProperty("self")
    private Reference self;
    @JsonProperty("workItemUpdates")
    private Reference workItemUpdates;
    @JsonProperty("workItemRevisions")
    private Reference workItemRevisions;
    @JsonProperty("workItemComments")
    private Reference workItemComments;
    @JsonProperty("html")
    private Reference html;
    @JsonProperty("workItemType")
    private Reference workItemType;
    @JsonProperty("fields")
    private Reference fields;
    @JsonProperty("avatar")
    private Reference avatar;
    @JsonProperty("project")
    private Reference project;
    @JsonProperty("team")
    private Reference team;
    @JsonProperty("teamIteration")
    private Reference teamIteration;
    @JsonProperty("packages")
    private Reference packages;
    @JsonProperty("permissions")
    private Reference permissions;
    @JsonProperty("feed")
    private Reference feed;
    @JsonProperty("sourceVersionDisplayUri")
    private Reference sourceVersionDisplayUri;
    @JsonProperty("timeline")
    private Reference timeline;
    @JsonProperty("badge")
    private Reference badge;
    @JsonProperty("web")
    private Reference web;
    @JsonProperty("editor")
    private Reference editor;

    @Override
    public String toString() {
        return "ReferenceLinks{" +
                "self=" + self +
                ", workItemUpdates=" + workItemUpdates +
                ", workItemRevisions=" + workItemRevisions +
                ", workItemComments=" + workItemComments +
                ", html=" + html +
                ", workItemType=" + workItemType +
                ", fields=" + fields +
                ", avatar=" + avatar +
                ", project=" + project +
                ", team=" + team +
                ", teamIteration=" + teamIteration +
                ", packages=" + packages +
                ", permissions=" + permissions +
                ", feed=" + feed +
                ", sourceVersionDisplayUri=" + sourceVersionDisplayUri +
                ", timeline=" + timeline +
                ", badge=" + badge +
                ", web=" + web +
                ", editor=" + editor +
                '}';
    }

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
