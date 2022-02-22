package br.com.estudos.userswebflux.service.service;

import br.com.estudos.userswebflux.exception.NotFoundException;
import br.com.estudos.userswebflux.service.entity.UserEntity;
import br.com.estudos.userswebflux.service.mapper.UserServiceMapperToResponse;
import br.com.estudos.userswebflux.service.model.UserServiceResponse;
import br.com.estudos.userswebflux.service.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static br.com.estudos.userswebflux.exception.ErrorConstants.ID_NOT_FOUND;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Flux<UserServiceResponse> findAll() {
        return userRepository.findAll()
                .map(UserServiceMapperToResponse::toUserServiceResponse);
    }
    
    public Mono<UserServiceResponse> findById(String id) {
        return userRepository.findById(id)
                .switchIfEmpty(Mono.error(() -> new NotFoundException(ID_NOT_FOUND)))
                .map(UserServiceMapperToResponse::toUserServiceResponse);
    }

    public Mono<UserServiceResponse> save(UserEntity user) {
        return userRepository.save(user)
                .map(UserServiceMapperToResponse::toUserServiceResponse);
    }

    public Mono<UserServiceResponse> update(UserEntity user) {
        return userRepository.save(user)
                .map(UserServiceMapperToResponse::toUserServiceResponse);
    }

    public Mono<Void> deleteById(String id) {
        return userRepository.deleteById(id);
    }
}