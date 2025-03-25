import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;


public class UserActivityCLI{
    public static void main(String[] args){

        if (args.length == 0) {
            System.out.println("Please provide a GitHub username as an argument.");
            return;
        }

        String username = args[0];
        String apiUrl = "https://api.github.com/users/" + username + "/events";

          try {
            
            // Create HttpClient and HttpRequest
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .build();
            
            // Send request and get response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

           JSONArray json = new JSONArray(response.body());

           for(Object obj:json){
           JSONObject element = (JSONObject) obj;
           JSONObject payload = element.getJSONObject("payload");
           if (payload.has("commits")) {
           JSONArray commits = payload.getJSONArray("commits");
                for(Object obj1:commits){
                JSONObject commit = (JSONObject) obj1;
                String commitmessage = commit.getString("message");
                System.out.println("- " + commitmessage);
                }
             }
           }
        } catch (IOException | InterruptedException | JSONException e) {
            e.printStackTrace();
        }

    }
}