import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ConsultasDeAPI {

    private HttpClient client;

    public ConsultasDeAPI() {
        client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();
    }

    public void realizarConsulta() {
        // Crear una instancia de HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/5217152bd1a35094a38aafa8/latest/USD"))
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        try {
            // Enviar la solicitud y obtener una instancia de HttpResponse
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Imprimir el código de estado de la respuesta
            System.out.println("Código de estado: " + response.statusCode());

            // Imprimir el cuerpo de la respuesta
            System.out.println("Cuerpo de la respuesta: " + response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}