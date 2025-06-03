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
 * Represents pipeline permissions
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class PipelinePermission extends SerializableEntity {
	/**
	 * If the permissions is authorized or not
	 */
	@JsonProperty("authorized")
	private Boolean authorized;
	/**
	 * Authorized by
	 */
	@JsonProperty("authorizedBy")
	private Author authorizedBy;
	/**
	 * Authorized on
	 */
	@JsonProperty("authorizedOn")
	private String authorizedOn;
	/**
	 * Id
	 */
	@JsonProperty("id")
	private Integer id;

	public Boolean getAuthorized() { return authorized; }

	public void setAuthorized(Boolean authorized) { this.authorized = authorized; }

	public Author getAuthorizedBy() { return authorizedBy; }

	public void setAuthorizedBy(Author authorizedBy) { this.authorizedBy = authorizedBy; }

	public String getAuthorizedOn() { return authorizedOn; }

	public void setAuthorizedOn(String authorizedOn) { this.authorizedOn = authorizedOn; }

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }
}
