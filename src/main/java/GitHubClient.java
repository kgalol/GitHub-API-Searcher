import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest;
import java.net.URI;

public class GitHubClient {

    public static final String BASE_URL = "https://api.github.com";

    private final HttpClient client = HttpClient.newHttpClient();

    public String get(String endpoint) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + endpoint))
                .header("Accept", "appication/vnd.github+json")
                .GET()
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        if (response.statusCode() != 200) {
            throw new RuntimeException("Github API Response Error: " + response.statusCode());
        }

        if (response.statusCode() == 200) {
            System.out.println("\nSuccessfully connected to Github API.");
        }

        return response.body();

    }
}
