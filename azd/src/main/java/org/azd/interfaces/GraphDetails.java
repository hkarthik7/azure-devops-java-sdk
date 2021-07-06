package org.azd.interfaces;

import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.graph.types.GraphGroup;
import org.azd.graph.types.GraphGroups;
import org.azd.graph.types.GraphUser;
import org.azd.graph.types.GraphUsers;

public interface GraphDetails {
    GraphUser createUser(String emailId, String userDescriptor) throws ConnectionException, AzDException;
    GraphUser addUserToGroup(String emailId, String groupDescriptor) throws ConnectionException, AzDException;
    void deleteUser(String userDescriptor) throws ConnectionException, AzDException;
    GraphUser getUser(String userDescriptor) throws ConnectionException, AzDException;
    GraphUsers getUsers() throws ConnectionException, AzDException;
    GraphUsers getUsers(String continuationToken, String scopeDescriptor, String subjectTypes) throws ConnectionException, AzDException;
    GraphGroup getGroup(String groupDescriptor) throws ConnectionException, AzDException;
    GraphGroups getGroups() throws ConnectionException, AzDException;
}
