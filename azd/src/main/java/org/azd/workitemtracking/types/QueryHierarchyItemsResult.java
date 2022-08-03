package org.azd.workitemtracking.types;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryHierarchyItemsResult extends BaseAbstractMethod {
    /**
     * The count of items.
     */
    @JsonProperty("count")
    private int count;
    /**
     * Indicates if the max return limit was hit but there are still more items
     */
    @JsonProperty("hasMore")
    private boolean hasMore;
    /**
     * The list of items
     */
    @JsonProperty("value")
    private List<QueryHierarchyItem> queryHierarchyItems;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<QueryHierarchyItem> getQueryHierarchyItems() {
        return queryHierarchyItems;
    }

    public void setQueryHierarchyItems(List<QueryHierarchyItem> queryHierarchyItems) {
        this.queryHierarchyItems = queryHierarchyItems;
    }
}
