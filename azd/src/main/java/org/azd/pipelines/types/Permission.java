package org.azd.pipelines.types;

/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.common.types.Author;


/**
 * Represents the pipeline permission
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Permission extends SerializableEntity {
	/**
	 * If the request is authorized or not
	 */
	@JsonProperty("authorized")
	private Boolean authorized;
	/**
	 * Pipeline permissions authorized
	 */
	@JsonProperty("authorizedBy")
	private Author authorizedBy;
	/**
	 * Date time authorized on
	 */
	@JsonProperty("authorizedOn")
	private String authorizedOn;

	public Boolean getAuthorized() { return authorized; }

	public void setAuthorized(Boolean authorized) { this.authorized = authorized; }

	public Author getAuthorizedBy() { return authorizedBy; }

	public void setAuthorizedBy(Author authorizedBy) { this.authorizedBy = authorizedBy; }

	public String getAuthorizedOn() { return authorizedOn; }

	public void setAuthorizedOn(String authorizedOn) { this.authorizedOn = authorizedOn; }
}
