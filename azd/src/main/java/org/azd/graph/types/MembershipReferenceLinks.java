package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.common.types.Reference;

/***
 * This field contains zero or more interesting links about the graph subject.
 * These links may be invoked to obtain additional relationships or more detailed
 * information about this graph subject.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MembershipReferenceLinks extends BaseAbstractMethod {
    /***
     * self reference url
     */
    @JsonProperty("self")
    private Reference self;
    /***
     * URL of member
     */
    @JsonProperty("member")
    private Reference member;
    /***
     * URL of container containing member
     */
    @JsonProperty("container")
    private Reference container;

    public Reference getSelf() {
        return self;
    }

    public void setSelf(Reference self) {
        this.self = self;
    }

    public Reference getMember() {
        return member;
    }

    public void setMember(Reference member) {
        this.member = member;
    }

    public Reference getContainer() {
        return container;
    }

    public void setContainer(Reference container) {
        this.container = container;
    }

}
