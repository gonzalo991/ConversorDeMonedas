package servicio;

import com.google.gson.Gson;
import modelos.Moneda;
import modelos.Resultado;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class ConversorDeMonedas {

    public Moneda convertirMoneda(String source, String target, int quantity) throws UnsupportedEncodingException {
        // source, target, quantity. format=jason
        String key = URLEncoder.encode("52724|ibzSVVtem5DDjbrm30hX", StandardCharsets.UTF_8.toString());
        String url = String.format("https://api.cambio.today/v1/quotes/%s/%s/json?quantity=%d&key=%s",
                source, target, quantity, key);
        URI direccion = URI.create(url);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion).build();

        try{

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Resultado resultado = new Gson().fromJson(response.body(), Resultado.class);
            return resultado.getResult();

        } catch(Exception e){
            throw new RuntimeException("No se encontraron las monedas");
        }
    }
}
