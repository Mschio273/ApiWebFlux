package br.com.estudos.userswebflux.service.service;

import br.com.estudos.userswebflux.service.integration.CepIntegration;
import br.com.estudos.userswebflux.service.model.UserServiceRequest;
import br.com.estudos.userswebflux.service.model.UserServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static br.com.estudos.userswebflux.service.mapper.MapperToUserWithAdress.mapAddress;

@AllArgsConstructor
@Component
public class UserServiceFacade {

    final UserService userService;
    final CepIntegration cepIntegration;

    public Flux<UserServiceResponse> findAll() {
        return userService.findAll();
    }

    public Mono<UserServiceResponse> findById(String id) {
        return userService.findById(id);
    }

    public Mono<UserServiceResponse> save(UserServiceRequest user) {
        return userService.save(mapAddress(user, cepIntegration.findByCep(user.getCep())));
    }

    public Mono<UserServiceResponse> update(UserServiceRequest user) {
        return userService.update(mapAddress(user, cepIntegration.findByCep(user.getCep())));
    }

    public Mono<Void> deleteById(String id) {
        return userService.findById(id)
                .flatMap(x -> userService.deleteById(x.getId()));
    }
}