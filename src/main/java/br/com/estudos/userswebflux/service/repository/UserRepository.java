package br.com.estudos.userswebflux.service.repository;

import br.com.estudos.userswebflux.service.entity.UserEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<UserEntity, String> {
}
