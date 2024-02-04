package org.azd.graph.subjectlookup;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.graph.types.GraphSubjectLookup;
import org.azd.graph.types.SubjectLookupResponse;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Graph Subject Lookup Api.
 */
public class SubjectLookupRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public SubjectLookupRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "graph", "4dd4d168-11f2-48c4-83e8-756fa0de027c", ApiVersion.GRAPH);
    }

    /**
     * Resolve descriptors to users, groups or scopes (Subjects) in a batch.
     *
     * @param subjectLookup Subject lookup object that contains list of descriptor to look for.
     * <br/><strong>Example:</strong>
     * <pre>{@code
     * var subjectLookup = new GraphSubjectLookup();
     * var subjectLookupKeys = new ArrayList<GraphSubjectLookupKey>();
     * subjectLookupKeys.add(new GraphSubjectLookupKey("aadgp.Uy0xLTktMTU1MTM3NDI0NS0xMjA0NDAwOTY5LTI0MDI5ODY0MTMtMjE3OTQwODYxNi0zLTE5MTI3MjIxNjAtMjUyNDcwNjM3MC0yNDg2NjA0ODIwLTg2MjI3NjQyNA"));
     * subjectLookupKeys.add(new GraphSubjectLookupKey("aad.NjJhOWYxYmQtNmEwOS03NjQyLTkzYTAtMDFkMTVmZDQ2NDk4"));
     * subjectLookup.setLookupKeys(subjectLookupKeys)
     * }</pre>
     * @return Subject lookup response {@link SubjectLookupResponse}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<SubjectLookupResponse> lookupAsync(GraphSubjectLookup subjectLookup) throws AzDException {
        return builder()
                .POST(subjectLookup)
                .build()
                .executeAsync(SubjectLookupResponse.class);
    }

    /**
     * Resolve descriptors to users, groups or scopes (Subjects) in a batch.
     *
     * @param subjectLookup Subject lookup object that contains list of descriptor to look for.
     * <br/><strong>Example:</strong>
     * <pre>{@code
     * var subjectLookup = new GraphSubjectLookup();
     * var subjectLookupKeys = new List<GraphSubjectLookupKey>();
     * subjectLookupKeys.add(new GraphSubjectLookupKey("aadgp.Uy0xLTktMTU1MTM3NDI0NS0xMjA0NDAwOTY5LTI0MDI5ODY0MTMtMjE3OTQwODYxNi0zLTE5MTI3MjIxNjAtMjUyNDcwNjM3MC0yNDg2NjA0ODIwLTg2MjI3NjQyNA"));
     * subjectLookupKeys.add(new GraphSubjectLookupKey("aad.NjJhOWYxYmQtNmEwOS03NjQyLTkzYTAtMDFkMTVmZDQ2NDk4"));
     * subjectLookup.setLookupKeys(subjectLookupKeys)
     * }</pre>
     * @return Subject lookup response {@link SubjectLookupResponse}
     * @throws AzDException Default Api Exception handler.
     **/
    public SubjectLookupResponse lookup(GraphSubjectLookup subjectLookup) throws AzDException {
        return builder()
                .POST(subjectLookup)
                .build()
                .execute(SubjectLookupResponse.class);
    }
}
