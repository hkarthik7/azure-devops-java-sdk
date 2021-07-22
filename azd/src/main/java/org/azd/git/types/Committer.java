package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Represents the committer to the repository
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Committer {
    /***
     * Name of the committer
     */
    @JsonProperty("name")
    private String name;
    /***
     * Email
     */
    @JsonProperty("email")
    private String email;
    /***
     * Date when committed
     */
    @JsonProperty("date")
    private String date;

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
            this.date = date;
        }
}
