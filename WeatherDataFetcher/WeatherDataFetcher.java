/*
 * WeatherDataFetcher.java
 * Author: Vishal Thakur <vishalthakurx@gmail.com>
 * GitHub: @vishalthakurx
 * Description: Fetches weather data from a public API using Java's HTTP client and parses JSON.
 */
import java.net.http.*;
import java.net.URI;
import java.io.IOException;

public class WeatherDataFetcher {
    public static void main(String[] args) throws IOException, InterruptedException {
        String city = "London";
        // Note: This example uses a free API. For production, you might need an API key
        String url = "https://goweather.herokuapp.com/weather/" + city;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Weather data for " + city + ":\n" + response.body());
    }
}
