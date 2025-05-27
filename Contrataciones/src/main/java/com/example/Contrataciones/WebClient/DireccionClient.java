package com.example.Contrataciones.WebClient;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class DireccionClient {
    private final WebClient webClient;

    public DireccionClient(@Value("${direccion-service.url}") String direccionServiceUrl) {
        this.webClient = WebClient.builder().baseUrl(direccionServiceUrl).build();
    }

    // metodo para realizar la consulta al microservicio estado y al usuario
    public Map<String, Object> getDireccionById(Long id) {
        return this.webClient.get()
                .uri("/{id}", id)
                .retrieve()
                .onStatus(status -> status.is4xxClientError(),
                        response -> response.bodyToMono(String.class)
                                .map(body -> new RuntimeException("Direccion no encontrado")))
                .bodyToMono(Map.class)
                .doOnNext(body -> System.out.println("Respuesta Direccion: " + body))
                .block();

    }

}
