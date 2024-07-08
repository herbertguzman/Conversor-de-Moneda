import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ConsultasDeAPI {

    private final HttpClient client;
    private final Gson gson;

    public ConsultasDeAPI() {
        client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        gson = new Gson();
    }

    public double obtenerTasaDeCambio(String monedaOrigen, String monedaDestino) {
        String url = String.format("https://v6.exchangerate-api.com/v6/5217152bd1a35094a38aafa8/pair/%s/%s", monedaOrigen, monedaDestino);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                ExchangeRateResponse exchangeRateResponse = gson.fromJson(response.body(), ExchangeRateResponse.class);
                return exchangeRateResponse.getConversionRate();
            } else {
                String errorMessage = String.format("Error al obtener la tasa de cambio: %d para %s a %s", response.statusCode(), monedaOrigen, monedaDestino);
                System.out.println(errorMessage);
                guardarError(errorMessage, new Exception("HTTP error: " + response.statusCode()));
                return 0.0;
            }
        } catch (IOException | InterruptedException e) {
            String errorMessage = String.format("Excepción al obtener la tasa de cambio para %s a %s", monedaOrigen, monedaDestino);
            e.printStackTrace();
            guardarError(errorMessage, e);
            return 0.0;
        }
    }

    private void guardarError(String mensaje, Exception e) {
        try (FileWriter file = new FileWriter("errores.txt", true)) {
            file.write(mensaje + "\n");
            for (StackTraceElement element : e.getStackTrace()) {
                file.write("\t" + element.toString() + "\n");
            }
        } catch (IOException ex) {
            System.out.println("Error al guardar el mensaje de error: " + ex.getMessage());
        }
    }
}