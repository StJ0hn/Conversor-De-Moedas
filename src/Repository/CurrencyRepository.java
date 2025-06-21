package Repository;

import Model.ExchangeRateResponse;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyRepository {

    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public ExchangeRateResponse getExchangeRate(String sourceCurrency) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + sourceCurrency))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();

        return gson.fromJson(response.body(), ExchangeRateResponse.class);
    }
}
