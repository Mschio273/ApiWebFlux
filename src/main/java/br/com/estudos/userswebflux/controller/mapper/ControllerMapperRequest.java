package br.com.estudos.userswebflux.controller.mapper;

import br.com.estudos.userswebflux.controller.model.UserControllerRequest;
import br.com.estudos.userswebflux.service.model.UserServiceRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ControllerMapperRequest {

    static UserServiceRequest toUserControllerRequest(UserControllerRequest userControllerRequest) {
        return Mappers.getMapper(ControllerMapperRequest.class).mapFromEntityUserController(userControllerRequest);
    }


    UserServiceRequest mapFromEntityUserController(UserControllerRequest userControllerRequest);

}
