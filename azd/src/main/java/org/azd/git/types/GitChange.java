package org.azd.git.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.VersionControlChangeType;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitChange extends BaseAbstractMethod {
	/**
 	* ID of the change within the group of changes. 
	**/
	@JsonProperty("changeId")
	private Integer changeId;
	/**
 	* The type of change that was made to the item. 
	**/
	@JsonProperty("changeType")
	private VersionControlChangeType changeType;
	/**
 	* Current version. 
	**/
	@JsonProperty("item")
	private String item;
	/**
 	* Content of the item after the change. 
	**/
	@JsonProperty("newContent")
	private ItemContent newContent;
	/**
 	* New Content template to be used when pushing new changes. 
	**/
	@JsonProperty("newContentTemplate")
	private GitTemplate newContentTemplate;
	/**
 	* Original path of item if different from current path. 
	**/
	@JsonProperty("originalPath")
	private String originalPath;
	/**
 	* Path of the item on the server. 
	**/
	@JsonProperty("sourceServerItem")
	private String sourceServerItem;
	/**
 	* URL to retrieve the item. 
	**/
	@JsonProperty("url")
	private String url;

	public Integer getChangeId() { return changeId; }

	public void setChangeId(Integer changeId) { this.changeId = changeId; }

	public VersionControlChangeType getChangeType() { return changeType; }

	public void setChangeType(VersionControlChangeType changeType) { this.changeType = changeType; }

	public String getItem() { return item; }

	public void setItem(String item) { this.item = item; }

	public ItemContent getNewContent() { return newContent; }

	public void setNewContent(ItemContent newContent) { this.newContent = newContent; }

	public GitTemplate getNewContentTemplate() { return newContentTemplate; }

	public void setNewContentTemplate(GitTemplate newContentTemplate) { this.newContentTemplate = newContentTemplate; }

	public String getOriginalPath() { return originalPath; }

	public void setOriginalPath(String originalPath) { this.originalPath = originalPath; }

	public String getSourceServerItem() { return sourceServerItem; }

	public void setSourceServerItem(String sourceServerItem) { this.sourceServerItem = sourceServerItem; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

}
