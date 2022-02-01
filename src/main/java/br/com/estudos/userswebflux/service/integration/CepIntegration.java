package br.com.estudos.userswebflux.service.integration;

import br.com.estudos.userswebflux.cep.CepClient;
import br.com.estudos.userswebflux.service.model.Address;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CepIntegration {

    public Address findByCep(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        return CepClient.getRestTemplate().getForObject(url, Address.class);
    }
}
