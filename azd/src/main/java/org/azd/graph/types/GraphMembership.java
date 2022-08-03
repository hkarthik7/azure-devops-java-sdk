package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Graph membership entity.
 * This captures the relationship between a container (group) and member (user)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphMembership extends BaseAbstractMethod {
    /***
     * This field contains zero or more interesting links about the graph subject.
     * These links may be invoked to obtain additional relationships or more detailed information about this graph subject.
     */
    @JsonProperty("_links")
    private MembershipReferenceLinks _links;

    /***
     * The descriptor is the primary way to reference the graph subject while the system is running.
     * This field will uniquely identify the same graph subject across both Accounts and Organizations.
     * This identifies the containing object (container).
     */
    @JsonProperty("containerDescriptor")
    private String containerDescriptor;

    /***
     * The descriptor is the primary way to reference the graph subject while the system is running.
     * This field will uniquely identify the same graph subject across both Accounts and Organizations.
     * This identifies the contained object (member).
     */
    @JsonProperty("memberDescriptor")
    private String memberDescriptor;

    public MembershipReferenceLinks get_links() {
        return _links;
    }

    public void set_links(MembershipReferenceLinks _links) {
        this._links = _links;
    }

    public String getContainerDescriptor() {
        return containerDescriptor;
    }

    public void setContainerDescriptor(String containerDescriptor) {
        this.containerDescriptor = containerDescriptor;
    }

    public String getMemberDescriptor() {
        return memberDescriptor;
    }

    public void setMemberDescriptor(String memberDescriptor) {
        this.memberDescriptor = memberDescriptor;
    }

}
