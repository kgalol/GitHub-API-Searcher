import com.google.gson.Gson;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        GitHubClient client = new GitHubClient();
        Gson gson = new Gson();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Username: ");
        String username = scanner.nextLine();

        String listJson = client.get("/users/" + username + "/repos?per_page=5");
        Repo[] repos = gson.fromJson(listJson, Repo[].class);
        System.out.println("\n=== " + username + "'s repos ===");
        for (Repo r : repos) {
            System.out.println(r.name + " — ⭐ " + r.stars);
        }
    }
}