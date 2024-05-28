package br.dev.ryu.ken.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class WebApiConnector {
    private static Duration timeoutDuration;

    public WebApiConnector(int timoutDuration) {
        timeoutDuration = Duration.ofSeconds(30);
    }

    public String getDataFromURL(String url) {
        HttpClient client = buildHttpClient();
        HttpRequest request = buildRequest(url);
        HttpResponse<String> response;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return response.body();
    }

    private HttpClient buildHttpClient() {
        return  HttpClient.newBuilder()
                .connectTimeout(timeoutDuration)
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();
    }

    private HttpRequest buildRequest(String url) {
        return HttpRequest.newBuilder()
                .timeout(timeoutDuration)
                .uri(URI.create(url))
                .build();
    }
}
