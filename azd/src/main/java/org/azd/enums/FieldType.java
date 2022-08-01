package org.azd.enums;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type of the field. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum FieldType {
	/**
 	* Boolean field type. 
	**/
	@JsonProperty("boolean")
	BOOLEAN,
	/**
 	* Datetime field type. 
	**/
	@JsonProperty("dateTime")
	DATETIME,
	/**
 	* Double field type. 
	**/
	@JsonProperty("double")
	DOUBLE,
	/**
 	* Guid field type. 
	**/
	@JsonProperty("guid")
	GUID,
	/**
 	* History field type. 
	**/
	@JsonProperty("history")
	HISTORY,
	/**
 	* HTML (Multiline) field type. 
	**/
	@JsonProperty("html")
	HTML,
	/**
 	* Identity field type. 
	**/
	@JsonProperty("identity")
	IDENTITY,
	/**
 	* Integer field type. 
	**/
	@JsonProperty("integer")
	INTEGER,
	/**
 	* Double picklist field type. When creating a double picklist field from REST API, use "Double" FieldType. 
	**/
	@JsonProperty("picklistDouble")
	PICKLISTDOUBLE,
	/**
 	* Integer picklist field type. When creating a integer picklist field from REST API, use "Integer" FieldType. 
	**/
	@JsonProperty("picklistInteger")
	PICKLISTINTEGER,
	/**
 	* String picklist field type. When creating a string picklist field from REST API, use "String" FieldType. 
	**/
	@JsonProperty("picklistString")
	PICKLISTSTRING,
	/**
 	* Plain text field type. 
	**/
	@JsonProperty("plainText")
	PLAINTEXT,
	/**
 	* String field type. 
	**/
	@JsonProperty("string")
	STRING,
	/**
 	* Treepath field type. 
	**/
	@JsonProperty("treePath")
	TREEPATH;
}