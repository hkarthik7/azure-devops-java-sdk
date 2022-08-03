package org.azd.git.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.ItemContentType;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemContent extends BaseAbstractMethod {

	@JsonProperty("content")
	private String content;

	@JsonProperty("contentType")
	private ItemContentType contentType;

	public String getContent() { return content; }

	public void setContent(String content) { this.content = content; }

	public ItemContentType getContentType() { return contentType; }

	public void setContentType(ItemContentType contentType) { this.contentType = contentType; }

}
