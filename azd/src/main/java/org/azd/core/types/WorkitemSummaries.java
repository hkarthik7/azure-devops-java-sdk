package org.azd.core.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkitemSummaries extends Workitems<WorkitemFieldsSummary> {

}
