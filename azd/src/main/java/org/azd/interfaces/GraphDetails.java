package org.azd.interfaces;

import org.azd.exceptions.AzDException;
import org.azd.graph.types.GraphGroup;
import org.azd.graph.types.GraphGroups;
import org.azd.graph.types.GraphUser;
import org.azd.graph.types.GraphUsers;

public interface GraphDetails {
    GraphUser createUser(String emailId, String userDescriptor) throws AzDException;

    GraphUser addUserToGroup(String emailId, String groupDescriptor) throws AzDException;

    Void deleteUser(String userDescriptor) throws AzDException;

    GraphUser getUser(String userDescriptor) throws AzDException;

    GraphUsers getUsers() throws AzDException;

    GraphUsers getUsers(String continuationToken, String scopeDescriptor, String subjectTypes) throws AzDException;

    GraphGroup getGroup(String groupDescriptor) throws AzDException;

    GraphGroups getGroups() throws AzDException;
}
