package br.com.estudos.userswebflux.service.integration;

import br.com.estudos.userswebflux.service.model.Address;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class CepIntegration {


    public Mono<Address> findByCep(String cep) {
//        String url = "https://viacep.com.br/ws/" + cep + "/json/";
//
//        WebClient webClient = WebClient.builder()
//                .baseUrl(url)
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .build();
//
//        return webClient.get()
//                .retrieve()
//                .bodyToMono(Address.class)
//                .block();

        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        Mono<Address> addressMono = WebClient.create(url)
                .get()
                .retrieve()
                .bodyToMono(Address.class);

        return addressMono.map(a->a);


//        return webclient.get()
//                .retrieve()
//                .bodyToMono(Address.class)
//                .map(a -> a);

//        return CepClient.getRestTemplate().getForObject(url, Address.class);
    }


}
