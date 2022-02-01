package br.com.estudos.userswebflux.controller.controller;

import br.com.estudos.userswebflux.controller.mapper.ControllerMapperResponse;
import br.com.estudos.userswebflux.controller.model.UserControllerRequest;
import br.com.estudos.userswebflux.controller.model.UserControllerResponse;
import br.com.estudos.userswebflux.exception.NotFoundException;
import br.com.estudos.userswebflux.service.model.UserServiceRequest;
import br.com.estudos.userswebflux.service.service.UserServiceFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static br.com.estudos.userswebflux.controller.mapper.ControllerMapperRequest.toUserControllerRequest;
import static br.com.estudos.userswebflux.controller.mapper.ControllerMapperRequestWithId.toUserControllerRequestWithId;

//todo criar testes facade, controller, service
@AllArgsConstructor
@Component
public class UserControllerFacade {

    private final UserServiceFacade serviceFacade;

    public Flux<UserControllerResponse> findAll() {
        return serviceFacade.findAll()
                .map(ControllerMapperResponse::toUserControllerResponse);
    }

    public Mono<UserControllerResponse> findById(String id) {
        return serviceFacade.findById(id)
                .map(ControllerMapperResponse::toUserControllerResponse);
    }

    public Mono<UserControllerResponse> save(UserControllerRequest userControllerRequest) {
        UserServiceRequest userServiceRequest = toUserControllerRequest(userControllerRequest);
        return serviceFacade.save(userServiceRequest)
                .map(ControllerMapperResponse::toUserControllerResponse);
    }

    public Mono<UserControllerResponse> update(String id, UserControllerRequest userControllerRequest) {
        return serviceFacade.findById(id)
                .flatMap(x -> serviceFacade.update(toUserControllerRequestWithId(userControllerRequest, x.getId())))
                .map(ControllerMapperResponse::toUserControllerResponse);
    }

    public Mono<Void> delete(String id) {
        return serviceFacade.deleteById(id);
    }
}