package org.azd.unittests;

import org.azd.enums.VersionControlChangeType;
import org.azd.exceptions.AzDException;
import org.azd.git.types.GitCommitChanges;
import org.azd.abstractions.serializer.JsonSerializer;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class VersionControlChangeTypeTest {

    @Test
    public void shouldDeserialiseSingleAndMultiValueChangeTypes() throws AzDException {
        String mockJson =
                "{\n" +
                        "  \"changeCounts\": {\n" +
                        "    \"Edit\": 1,\n" +
                        "    \"Delete, SourceRename\": 1\n" +
                        "  },\n" +
                        "  \"changes\": [\n" +
                        "    {\n" +
                        "      \"item\": {\n" +
                        "        \"objectId\": \"abc123\",\n" +
                        "        \"originalObjectId\": \"abc123\",\n" +
                        "        \"gitObjectType\": \"blob\",\n" +
                        "        \"commitId\": \"deadbeef\",\n" +
                        "        \"path\": \"../deleted-file.xml\",\n" +
                        "        \"url\": \"http://example.com\"\n" +
                        "      },\n" +
                        "      \"changeType\": \"delete, sourceRename\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"item\": {\n" +
                        "        \"objectId\": \"def456\",\n" +
                        "        \"originalObjectId\": \"def456\",\n" +
                        "        \"gitObjectType\": \"blob\",\n" +
                        "        \"commitId\": \"cafebabe\",\n" +
                        "        \"path\": \"../edited-file.xml\",\n" +
                        "        \"url\": \"http://example.com\"\n" +
                        "      },\n" +
                        "      \"changeType\": \"edit\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}";

        JsonSerializer serializer = new JsonSerializer();
        GitCommitChanges changes = serializer.deserialize(mockJson, GitCommitChanges.class);

        assertNotNull(changes);
        assertEquals(2, changes.getChanges().size());

        // Check multi-value change type
        List<VersionControlChangeType> multiTypes = changes.getChanges().get(0).getChangeType();
        assertNotNull(multiTypes);
        assertEquals(2, multiTypes.size());
        assertTrue(multiTypes.contains(VersionControlChangeType.DELETE));
        assertTrue(multiTypes.contains(VersionControlChangeType.SOURCERENAME));

        // Check single-value change type
        List<VersionControlChangeType> singleTypes = changes.getChanges().get(1).getChangeType();
        assertNotNull(singleTypes);
        assertEquals(1, singleTypes.size());
        assertTrue(singleTypes.contains(VersionControlChangeType.EDIT));
    }
}
