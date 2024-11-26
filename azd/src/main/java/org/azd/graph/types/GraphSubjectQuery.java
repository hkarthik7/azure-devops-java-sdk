package org.azd.graph.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Subject to search using the Graph API 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphSubjectQuery extends SerializableEntity {
	/**
 	* Search term to search for Azure Devops users or/and groups 
	**/
	@JsonProperty("query")
	private String query;
	/**
 	* Optional parameter. Specify a non-default scope (collection, project) to search for users or groups within the scope. 
	**/
	@JsonProperty("scopeDescriptor")
	private String scopeDescriptor;
	/**
 	* "User" or "Group" can be specified, both or either 
	**/
	@JsonProperty("subjectKind")
	private String[] subjectKind;

	public String getQuery() { return query; }

	public void setQuery(String query) { this.query = query; }

	public String getScopeDescriptor() { return scopeDescriptor; }

	public void setScopeDescriptor(String scopeDescriptor) { this.scopeDescriptor = scopeDescriptor; }

	public String[] getSubjectKind() { return subjectKind; }

	public void setSubjectKind(String[] subjectKind) { this.subjectKind = subjectKind; }

}