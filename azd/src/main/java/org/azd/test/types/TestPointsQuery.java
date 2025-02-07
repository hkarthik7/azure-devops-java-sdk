package org.azd.test.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * Test point query class.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestPointsQuery extends SerializableCollectionEntity {
    /**
     * Order by results.
     */
    @JsonProperty("orderBy")
    private String orderBy;
    /**
     * List of test points
     */
    @JsonProperty("points")
    private List<TestPoint> points;
    /**
     * Filter
     */
    @JsonProperty("pointsFilter")
    private PointsFilter pointsFilter;
    /**
     * List of workitem fields to get.
     */
    @JsonProperty("witFields")
    private List<String> witFields;

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public List<TestPoint> getPoints() {
        return points;
    }

    public void setPoints(List<TestPoint> points) {
        this.points = points;
    }

    public PointsFilter getPointsFilter() {
        return pointsFilter;
    }

    public void setPointsFilter(PointsFilter pointsFilter) {
        this.pointsFilter = pointsFilter;
    }

    public List<String> getWitFields() {
        return witFields;
    }

    public void setWitFields(List<String> witFields) {
        this.witFields = witFields;
    }
}
