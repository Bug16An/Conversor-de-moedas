package Conversor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ConversorER {
    private static final String API_KEY;

    static {
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream("config.properties")) {
            prop.load(input);
            API_KEY = prop.getProperty("API_KEY");
        } catch (IOException ex) {
            throw new RuntimeException("Não foi possível carregar a API Key do arquivo de configuração", ex);
        }
    }

public ConversorMoedas convert (String moedaOrigem, String moedaDestino, double valorOrigem){
    URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + moedaOrigem + "/"+ moedaDestino + "/" + valorOrigem);

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(endereco)
            .build();


    try {   HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
        if (jsonResponse.has("error")) {
            System.err.println("API error: " + jsonResponse.get("error").getAsString());
            return null;
        }
                double exchangeRate = jsonResponse.get("conversion_rate").getAsDouble();
                double convertedAmount = valorOrigem * exchangeRate;

                return new ConversorMoedas(moedaOrigem, moedaDestino, valorOrigem, convertedAmount);
            } catch (IOException | InterruptedException e) {
        System.err.println("Erro ao converter moedas: " + e.getMessage());
        return null;
            }
    }
}



