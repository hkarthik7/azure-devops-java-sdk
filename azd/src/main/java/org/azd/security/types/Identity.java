package org.azd.security.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;
import java.util.Map;

/***
 * identity returned by API identities descriptor lookup
 *
 * {
 *   "count": 1,
 *   "value": [
 *     {
 *       "id": "81fa6389-0872-6fdd-a451-7ba7880f566a",
 *       "descriptor": "Microsoft.IdentityModel.Claims.ClaimsIdentity;7a394543-62fd-4274-a7d2-8fac775942b6\\jtseng@vscsi.us",
 *       "subjectDescriptor": "aad.MDA0NzBlMzQtZGE2MS03YTY5LWJkOTYtNDg3YTg0OWVjNTU4",
 *       "providerDisplayName": "Jia-hao Tseng",
 *       "isActive": true,
 *       "members": [],
 *       "memberOf": [],
 *       "memberIds": [],
 *       "properties": {
 *         "SchemaClassName": {
 *           "$type": "System.String",
 *           "$value": "User"
 *         },
 *         "Description": {
 *           "$type": "System.String",
 *           "$value": ""
 *         },
 *         "Domain": {
 *           "$type": "System.String",
 *           "$value": "7a394543-62fd-4274-a7d2-8fac775942b6"
 *         },
 *         "Account": {
 *           "$type": "System.String",
 *           "$value": "jtseng@vscsi.us"
 *         },
 *         "DN": {
 *           "$type": "System.String",
 *           "$value": ""
 *         },
 *         "Mail": {
 *           "$type": "System.String",
 *           "$value": "jtseng@vscsi.us"
 *         },
 *         "SpecialType": {
 *           "$type": "System.String",
 *           "$value": "Generic"
 *         },
 *         "Alias": {
 *           "$type": "System.String",
 *           "$value": "jtseng"
 *         },
 *         "PUID": {
 *           "$type": "System.String",
 *           "$value": "aad:100FAFF21C1B5261"
 *         },
 *         "ComplianceValidated": {
 *           "$type": "System.DateTime",
 *           "$value": "2020-04-23T00:00:00Z"
 *         },
 *         "http://schemas.microsoft.com/identity/claims/objectidentifier": {
 *           "$type": "System.String",
 *           "$value": "55c8c7b6-7ace-43bc-918f-304dfa2b6317"
 *         },
 *         "MetadataUpdateDate": {
 *           "$type": "System.DateTime",
 *           "$value": "2018-07-10T16:11:40Z"
 *         },
 *         "DirectoryAlias": {
 *           "$type": "System.String",
 *           "$value": "jtseng"
 *         }
 *       },
 *       "resourceVersion": 2,
 *       "metaTypeId": 0
 *     }
 *   ]
 * }
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Identity extends BaseAbstractMethod {
    private String id;
    private String descriptor;
    private String subjectDescriptor;
    private String providerDisplayName;
    private boolean isActive;
    private List<Object> members;
    private List<Object> memberOf;
    private List<Object> memberIds;
    private Map<String, Object> properties;
    private Integer resourceVersion;
    private Integer metaTypeId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public String getSubjectDescriptor() {
        return subjectDescriptor;
    }

    public void setSubjectDescriptor(String subjectDescriptor) {
        this.subjectDescriptor = subjectDescriptor;
    }

    public String getProviderDisplayName() {
        return providerDisplayName;
    }

    public void setProviderDisplayName(String providerDisplayName) {
        this.providerDisplayName = providerDisplayName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<Object> getMembers() {
        return members;
    }

    public void setMembers(List<Object> members) {
        this.members = members;
    }

    public List<Object> getMemberOf() {
        return memberOf;
    }

    public void setMemberOf(List<Object> memberOf) {
        this.memberOf = memberOf;
    }

    public List<Object> getMemberIds() {
        return memberIds;
    }

    public void setMemberIds(List<Object> memberIds) {
        this.memberIds = memberIds;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    public Integer getResourceVersion() {
        return resourceVersion;
    }

    public void setResourceVersion(Integer resourceVersion) {
        this.resourceVersion = resourceVersion;
    }

    public Integer getMetaTypeId() {
        return metaTypeId;
    }

    public void setMetaTypeId(Integer metaTypeId) {
        this.metaTypeId = metaTypeId;
    }

}
