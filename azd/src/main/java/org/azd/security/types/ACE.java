package org.azd.security.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * ACL acesDictionary entry
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ACE extends BaseAbstractMethod {
    /***
     * descriptor identifier
     */
    @JsonProperty("descriptor")
    private String descriptor;
    /***
     * allow value
     */
    @JsonProperty("allow")
    private long allow;
    /***
     * deny value
     */
    @JsonProperty("deny")
    private long deny;

    @JsonProperty("extendedInfo")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ExtendedInfo extendedInfo;

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public long getAllow() {
        return allow;
    }

    public void setAllow(long allow) {
        this.allow = allow;
    }

    public long getDeny() {
        return deny;
    }

    public void setDeny(long deny) {
        this.deny = deny;
    }

    @JsonProperty(value = "includeExtendedInfo")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean isIncludeExtendedInfo() {
        return extendedInfo == null ? null : true;
    }

    public ExtendedInfo getExtendedInfo() {
        return extendedInfo;
    }

    public void setExtendedInfo(ExtendedInfo extendedInfo) {
        this.extendedInfo = extendedInfo;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public class ExtendedInfo extends BaseAbstractMethod {
        @JsonProperty("inheritedAllow")
        private Long inheritedAllow;
        @JsonProperty("effectiveAllow")
        private Long effectiveAllow;

        public Long getInheritedAllow() {
            return inheritedAllow;
        }

        public void setInheritedAllow(Long inheritedAllow) {
            this.inheritedAllow = inheritedAllow;
        }

        public Long getEffectiveAllow() {
            return effectiveAllow;
        }

        public void setEffectiveAllow(Long effectiveAllow) {
            this.effectiveAllow = effectiveAllow;
        }

    }
}
