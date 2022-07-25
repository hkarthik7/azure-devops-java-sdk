package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Folders {
    @JsonProperty("value")
    private List<Folder> folders;

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

    @Override
    public String toString() {
        return "Folders{" +
                "folders=" + folders +
                '}';
    }
}
