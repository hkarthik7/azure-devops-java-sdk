package org.azd.workitemtracking.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.LogicalOperation;

import java.util.List;

/**
 * Represents a clause in a work item query. This shows the structure of a work item query. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemQueryClause extends BaseAbstractMethod {
	/**
 	* Child clauses if the current clause is a logical operator 
	**/
	@JsonProperty("clauses")
	private List<WorkItemQueryClause> clauses;
	/**
 	* Field associated with condition 
	**/
	@JsonProperty("field")
	private WorkItemFieldReference field;
	/**
 	* Right side of the condition when a field to field comparison 
	**/
	@JsonProperty("fieldValue")
	private WorkItemFieldReference fieldValue;
	/**
 	* Determines if this is a field to field comparison 
	**/
	@JsonProperty("isFieldValue")
	private boolean isFieldValue;
	/**
 	* Logical operator separating the condition clause 
	**/
	@JsonProperty("logicalOperator")
	private LogicalOperation logicalOperator;
	/**
 	* The field operator 
	**/
	@JsonProperty("operator")
	private WorkItemFieldOperation operator;
	/**
 	* Right side of the condition when a field to value comparison 
	**/
	@JsonProperty("value")
	private String value;

	public List<WorkItemQueryClause> getClauses() { return clauses; }

	public void setClauses(List<WorkItemQueryClause> clauses) { this.clauses = clauses; }

	public WorkItemFieldReference getField() { return field; }

	public void setField(WorkItemFieldReference field) { this.field = field; }

	public WorkItemFieldReference getFieldValue() { return fieldValue; }

	public void setFieldValue(WorkItemFieldReference fieldValue) { this.fieldValue = fieldValue; }

	public boolean getIsFieldValue() { return isFieldValue; }

	public void setIsFieldValue(boolean isFieldValue) { this.isFieldValue = isFieldValue; }

	public LogicalOperation getLogicalOperator() { return logicalOperator; }

	public void setLogicalOperator(LogicalOperation logicalOperator) { this.logicalOperator = logicalOperator; }

	public WorkItemFieldOperation getOperator() { return operator; }

	public void setOperator(WorkItemFieldOperation operator) { this.operator = operator; }

	public String getValue() { return value; }

	public void setValue(String value) { this.value = value; }

}
