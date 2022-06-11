package org.azd.interfaces;

import org.azd.exceptions.AzDException;
import org.azd.security.types.*;

public interface SecurityDetails {
    SecurityNamespaces getNamespaces() throws AzDException;

    SecurityNamespaces getNamespaces(boolean localOnly) throws AzDException;

    SecurityNamespace getNamespace(String namespaceId) throws AzDException;

    ACLs getAccessControlLists(String namespaceId) throws AzDException;

    ACLs getAccessControlLists(String namespaceId, String[] descriptors, String token, boolean includeExtendedInfo, boolean recurse) throws AzDException;

    Identities getIdentities(String[] descriptors, String[] identityIds, String[] subjectDescriptors, String filterValue, String queryMembership, String searchFilter) throws AzDException;

    Identities getIdentitiesFromSubjectDescriptors(String... subjectDescriptors) throws AzDException;

    ACEs setAccessControlEntries(String namespaceId, ACEs payload) throws AzDException;

    Void removeAccessControlEntries(String namespaceId, String[] descriptors, String[] tokens) throws AzDException;

    Void setAccessControlList(String namespaceId, ACLs payload) throws AzDException;

    Void removeAccessControlLists(String namespaceId, boolean recurse, String[] tokens) throws AzDException;
}
