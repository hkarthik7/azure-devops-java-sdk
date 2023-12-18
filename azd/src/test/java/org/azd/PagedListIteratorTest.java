package org.azd;

import org.azd.authentication.PersonalAccessTokenCredential;
import org.azd.build.BuildBaseRequestBuilder;
import org.azd.build.types.Builds;
import org.azd.exceptions.AzDException;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.PageIterator;
import org.azd.serializer.JsonSerializer;
import org.azd.serviceClient.AzDServiceClient;
import org.azd.tasks.PagedListIterator;
import org.azd.utils.InstanceFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class PagedListIteratorTest {
    private static final JsonSerializer serializer = new JsonSerializer();
    private static AzDServiceClient client;
    private static BuildBaseRequestBuilder bb;
    private static AccessTokenCredential pat;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = serializer.deserialize(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        pat = new PersonalAccessTokenCredential(organization, project, token);
        client = new AzDServiceClient(pat);
        bb = client.build();
    }

    @Test
    public void shouldGetTheNextPageFromListOfBuilds() throws AzDException {
        // Get the top 10 builds.
        // This will return continuation token in the header.
        // We then iterate through the list and get next page by PagedListIterator class.
        var allBuilds = bb.builds().listAsync(r -> r.queryParameters.top = 10).join();
//        System.out.println(allBuilds.getContinuationToken());
        System.out.println(bb.builds().listAsync(r -> r.queryParameters.continuationToken = allBuilds.getContinuationToken()).join());

//        var iterator = InstanceFactory.createPageIterator(Builds.class);
//        var nextPage = iterator.getNextPage();
//        allBuilds.getBuildResults().forEach(b -> System.out.println(b.getId()));
//        nextPage.getBuildResults().forEach(b -> System.out.println(b.getId()));
//        iterator.getNextPage().getBuildResults().forEach(b -> System.out.println(b.getId()));
//        iterator.getNextPage().getBuildResults().forEach(b -> System.out.println(b.getId()));
//        iterator.getNextPage().getBuildResults().forEach(b -> System.out.println(b.getId()));

//        assert allBuilds.getBuildResults().size() == nextPage.getBuildResults().size();
    }

    @Test
    public void shouldGetAllBuilds() throws AzDException {
        // Get the top 10 builds.
        // This will return continuation token in the header.
        // We then iterate through the list and get next page by PagedListIterator class.
        var allBuilds = bb.builds().listAsync(r -> r.queryParameters.top = 10).join();

        PageIterator<Builds> iterator = new PagedListIterator<>(Builds.class);
        var allResults = iterator.getResults();

        // All results return the List of Builds; This can be used to iterate;

        allBuilds.getBuildResults();
        allResults.forEach(Builds::getBuildResults);
    }
}
