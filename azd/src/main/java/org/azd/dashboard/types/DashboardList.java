package org.azd.dashboard.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * List of dashboards.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DashboardList extends SerializableCollectionEntity {
    /**
     * List of dashboards.
     */
    @JsonProperty("value")
    private List<Dashboard> dashboards;

    public List<Dashboard> getDashboards() {
        return dashboards;
    }

    public void setDashboards(List<Dashboard> dashboards) {
        this.dashboards = dashboards;
    }
}
