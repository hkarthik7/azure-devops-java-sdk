package org.azd.interfaces;

import org.azd.exceptions.AzDException;
import org.azd.exceptions.DefaultParametersException;
import org.azd.graph.types.GraphGroup;
import org.azd.graph.types.GraphGroups;
import org.azd.graph.types.GraphUser;
import org.azd.graph.types.GraphUsers;

public interface GraphDetails {
    GraphUser createUser(String emailId, String userDescriptor) throws DefaultParametersException, AzDException;
    GraphUser addUserToGroup(String emailId, String groupDescriptor) throws DefaultParametersException, AzDException;
    void deleteUser(String userDescriptor) throws DefaultParametersException, AzDException;
    GraphUser getUser(String userDescriptor) throws DefaultParametersException, AzDException;
    GraphUsers getUsers() throws DefaultParametersException, AzDException;
    GraphUsers getUsers(String continuationToken, String scopeDescriptor, String subjectTypes) throws DefaultParametersException, AzDException;
    GraphGroup getGroup(String groupDescriptor) throws DefaultParametersException, AzDException;
    GraphGroups getGroups() throws DefaultParametersException, AzDException;
}
