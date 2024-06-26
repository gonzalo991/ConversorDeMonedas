package servicio;

import com.google.gson.Gson;
import modelos.Moneda;
import modelos.Temperatura;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

/**
 * Clase que maneja la conversión de moneda utilizando una API externa.
 */
public class Conversor {

    /**
     * Convierte una cantidad de una moneda a otra utilizando una API externa de tipo Exchange Rate.
     *
     * @param base_code        Código de la moneda base (por ejemplo, "USD" para dólares estadounidenses).
     * @param target_code      Código de la moneda objetivo (por ejemplo, "EUR" para euros).
     * @param conversion_rate  Tasa de conversión entre las monedas.
     * @return Objeto Moneda que representa la conversión realizada.
     * @throws UnsupportedEncodingException Si ocurre un problema al codificar la API key.
     * @throws RuntimeException             Si ocurre un error durante la solicitud HTTP o al procesar la respuesta.
     */
    public Moneda convertirMoneda(String base_code, String target_code, float conversion_rate) throws UnsupportedEncodingException {
        // URL base para la API de conversión de moneda
        String apiKey = "d4d919918f8225b3d183fdaa";
        String key = URLEncoder.encode(apiKey, StandardCharsets.UTF_8.toString());
        String url = String.format("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s/%.1f",
                key, base_code, target_code, conversion_rate);
        URI direccion = URI.create(url);

        // Cliente HTTP para realizar la solicitud
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            // Enviar la solicitud HTTP y recibir la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Parsear la respuesta JSON a un objeto Moneda utilizando Gson
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir durante la solicitud o parseo de la respuesta
            throw new RuntimeException("Error al realizar la conversión de moneda: " + e.getMessage());
        }
    }
}
