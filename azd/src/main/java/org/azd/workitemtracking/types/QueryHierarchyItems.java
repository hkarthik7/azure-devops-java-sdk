package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryHierarchyItems extends SerializableCollectionEntity {
    @JsonProperty("value")
    private List<QueryHierarchyItem> queryHierarchyItems;

    public List<QueryHierarchyItem> getQueryHierarchyItems() {
        return queryHierarchyItems;
    }

    public void setQueryHierarchyItems(List<QueryHierarchyItem> queryHierarchyItems) {
        this.queryHierarchyItems = queryHierarchyItems;
    }
}
