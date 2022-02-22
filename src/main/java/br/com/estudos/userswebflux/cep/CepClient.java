package br.com.estudos.userswebflux.cep;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class CepClient {

    @Bean
    public static RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public WebClient getWebClient() {
        return WebClient.create();
    }
}
