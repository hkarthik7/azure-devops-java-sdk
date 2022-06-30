package org.azd.interfaces;

import org.azd.exceptions.AzDException;
import org.azd.graph.types.*;

public interface GraphDetails {
    GraphUser createUser(String emailId, String userDescriptor) throws AzDException;

    GraphUser addUserToGroup(String emailId, String groupDescriptor) throws AzDException;

    Void deleteUser(String userDescriptor) throws AzDException;

    GraphUser getUser(String userDescriptor) throws AzDException;

    GraphUsers getUsers() throws AzDException;

    GraphUsers getUsers(String continuationToken, String scopeDescriptor, String subjectTypes) throws AzDException;

    GraphGroup getGroup(String groupDescriptor) throws AzDException;

    GraphGroups getGroups() throws AzDException;

    GraphMemberships getGroupMembersOf(String groupDescriptor) throws AzDException;

    GraphMemberships getMemberOfGroups(String subjectDescriptor) throws AzDException;

    GraphMembership addMembership(String subjectDescriptor, String groupDescriptor) throws AzDException;

    Void removeMembership(String subjectDescriptor, String groupDescriptor) throws AzDException;

    GraphMembership createGroup(String displayName, String description) throws AzDException;

    GraphMembership createGroup(String displayName, String description, String projectDescriptor) throws AzDException;

    Void deleteGroup(String groupDescriptor) throws AzDException;

    GraphDescriptor getDescriptor(String storageKey) throws AzDException;

    SubjectLookupResponse subjectLookup(String... descriptors) throws AzDException;
}
