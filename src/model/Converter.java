package model;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Converter {


    public double compareCurrency(String currencyOne, String currencyTwo, double value) throws IOException, InterruptedException {
        String address = "https://v6.exchangerate-api.com/v6/a48bc8aff13923049c3ddc23/pair/" + currencyOne + "/" + currencyTwo;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(address)).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        var currencyAns = gson.fromJson(response.body(), CurrencyDTO.class);



        return value * currencyAns.conversion_rate();
    }
}
