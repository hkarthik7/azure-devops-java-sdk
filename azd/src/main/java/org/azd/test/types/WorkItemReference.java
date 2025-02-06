package org.azd.test.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * WorkItem reference Details.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemReference extends SerializableEntity {
    /**
     * WorkItem ID.
     */
    @JsonProperty("id")
    private String id;

    /**
     * WorkItem Name.
     */
    @JsonProperty("name")
    private String name;

    /**
     * WorkItem Type.
     */
    @JsonProperty("type")
    private String type;

    /**
     * WorkItem Url. Valid Values : (Bug, Task, User Story, Test Case)
     */
    @JsonProperty("url")
    private String url;

    /**
     * WorkItem WebUrl.
     */
    @JsonProperty("webUrl")
    private String webUrl;

 public String getId() {
  return id;
 }

 public void setId(String id) {
  this.id = id;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getType() {
  return type;
 }

 public void setType(String type) {
  this.type = type;
 }

 public String getUrl() {
  return url;
 }

 public void setUrl(String url) {
  this.url = url;
 }

 public String getWebUrl() {
  return webUrl;
 }

 public void setWebUrl(String webUrl) {
  this.webUrl = webUrl;
 }
}
