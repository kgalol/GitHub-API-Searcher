import com.google.gson.annotations.SerializedName;

import java.io.Serial;

public class Repo {

    public String name;
    public String description;

    @SerializedName("stargazers_count")
    public int stars;

    @SerializedName("open_issues_count")
    public int openIssues;

    @SerializedName("html_url")
    public String url;

    @SerializedName("")

    @Override
    public String toString() {
                return "Name: " + name + "\n" +
                        "URL: " + url + "\n" +
                        "Stars: " + stars + "\n" +
                        "Open issues: " + openIssues + "\n" +
                        "Description: " + description;
    }
}
