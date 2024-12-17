import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Conversor {
    public double converterMoeda(double valor, String moedaOrigem, String moedaDestino) {
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/7dc993cbb14ebace8823dea1/latest/" + moedaOrigem);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject jsonResponse = new Gson().fromJson(response.body(), JsonObject.class);
            double taxaDeCambio = jsonResponse.getAsJsonObject("conversion_rates").get(moedaDestino).getAsDouble();

            return valor * taxaDeCambio;
        } catch (Exception e) {
            throw new RuntimeException("Não consegui obter os dados a partir desta moeda.");
        }
    }
}
