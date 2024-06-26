package servicio;

import com.google.gson.Gson;
import modelos.Moneda;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class ConversorDeMonedas {

    public Moneda convertirMoneda(String base_code, String target_code, float conversion_rate) throws UnsupportedEncodingException {

        // https://v6.exchangerate-api.com/v6/%s/pair/%s/%s/%d
        String apiKey = "d4d919918f8225b3d183fdaa";
        String key = URLEncoder.encode(apiKey, StandardCharsets.UTF_8.toString());
        String url = String.format("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s/%.1f",
                key, base_code, target_code, conversion_rate);
        URI direccion = URI.create(url);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion).build();

        try{

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);

        } catch(Exception e){
            throw new RuntimeException("No se encontraron las monedas"+ e.getMessage());
        }
    }
}
