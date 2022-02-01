package br.com.estudos.userswebflux.controller.mapper;

import br.com.estudos.userswebflux.controller.model.UserControllerResponse;
import br.com.estudos.userswebflux.service.model.UserServiceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ControllerMapperResponse {

    static UserControllerResponse toUserControllerResponse(UserServiceResponse userServiceResponse) {
        return Mappers.getMapper(ControllerMapperResponse.class).mapFromServiceRequestToResponse(userServiceResponse);
    }
    UserControllerResponse mapFromServiceRequestToResponse(UserServiceResponse userServiceResponse);

}
