package com.example.Contrataciones.WebClient;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class UsuarioClient {

    private final WebClient webClient;

    public UsuarioClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://localhost:8081/api/v1/usuarios").build();
    }

    public UsuarioClient obtenerUsuarioPorId(Long id) {
        return webClient.get()
            .uri("/{id}", id)
            .retrieve()
            .bodyToMono(UsuarioClient.class)
            .block();
    }
}
