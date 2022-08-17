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
 * Type of object (Commit, Tree, Blob, Tag) 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class FileContentMetadata extends BaseAbstractMethod {

	@JsonProperty("contentType")
	private String contentType;

	@JsonProperty("encoding")
	private Integer encoding;

	@JsonProperty("extension")
	private String extension;

	@JsonProperty("fileName")
	private String fileName;

	@JsonProperty("isBinary")
	private boolean isBinary;

	@JsonProperty("isImage")
	private boolean isImage;

	@JsonProperty("vsLink")
	private String vsLink;

	public String getContentType() { return contentType; }

	public void setContentType(String contentType) { this.contentType = contentType; }

	public Integer getEncoding() { return encoding; }

	public void setEncoding(Integer encoding) { this.encoding = encoding; }

	public String getExtension() { return extension; }

	public void setExtension(String extension) { this.extension = extension; }

	public String getFileName() { return fileName; }

	public void setFileName(String fileName) { this.fileName = fileName; }

	public boolean getIsBinary() { return isBinary; }

	public void setIsBinary(boolean isBinary) { this.isBinary = isBinary; }

	public boolean getIsImage() { return isImage; }

	public void setIsImage(boolean isImage) { this.isImage = isImage; }

	public String getVsLink() { return vsLink; }

	public void setVsLink(String vsLink) { this.vsLink = vsLink; }

}