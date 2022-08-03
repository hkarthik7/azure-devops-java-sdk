package org.azd.git.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitUserDate extends BaseAbstractMethod {
	/**
 	* Date of the Git operation. 
	**/
	@JsonProperty("date")
	private String date;
	/**
 	* Email address of the user performing the Git operation. 
	**/
	@JsonProperty("email")
	private String email;
	/**
 	* Url for the user's avatar. 
	**/
	@JsonProperty("imageUrl")
	private String imageUrl;
	/**
 	* Name of the user performing the Git operation. 
	**/
	@JsonProperty("name")
	private String name;

	public String getDate() { return date; }

	public void setDate(String date) { this.date = date; }

	public String getEmail() { return email; }

	public void setEmail(String email) { this.email = email; }

	public String getImageUrl() { return imageUrl; }

	public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

}
