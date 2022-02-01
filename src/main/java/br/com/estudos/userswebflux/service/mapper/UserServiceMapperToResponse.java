package br.com.estudos.userswebflux.service.mapper;

import br.com.estudos.userswebflux.service.entity.UserEntity;
import br.com.estudos.userswebflux.service.model.UserServiceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserServiceMapperToResponse {
    static UserServiceResponse toUserServiceResponse(UserEntity userEntity) {
        return Mappers.getMapper(UserServiceMapperToResponse.class).mapFromResponseToEntity(userEntity);
    }

    UserServiceResponse mapFromResponseToEntity(UserEntity userEntity);
}
