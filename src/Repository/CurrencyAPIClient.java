package Repository;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class CurrencyAPIClient {
    String endereco = "https://v6.exchangerate-api.com/v6/1f230b72ed7a16eea7410111/latest/USD";
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
}
