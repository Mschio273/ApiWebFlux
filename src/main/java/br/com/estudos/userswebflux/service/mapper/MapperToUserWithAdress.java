package br.com.estudos.userswebflux.service.mapper;

import br.com.estudos.userswebflux.service.entity.UserEntity;
import br.com.estudos.userswebflux.service.model.Address;
import br.com.estudos.userswebflux.service.model.UserServiceRequest;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import reactor.core.publisher.Mono;

@Mapper(componentModel = "spring")
public interface MapperToUserWithAdress {

    static UserEntity mapAddress(UserServiceRequest user, Mono<Address> address) {
        return Mappers.getMapper(MapperToUserWithAdress.class).toCepServiceResponse(user, address);
    }

    @Mapping(target = "address", ignore = true)
    UserEntity toCepServiceResponse(UserServiceRequest user, Mono<Address> address);

    @AfterMapping
    default void mapAddress(@MappingTarget UserEntity.UserEntityBuilder user, Address address) {
        Address addressUser = Address.builder()
                .cep(address.getCep())
                .bairro(address.getBairro())
                .complemento(address.getComplemento())
                .ibge(address.getIbge())
                .localidade(address.getLocalidade())
                .logradouro(address.getLogradouro())
                .uf(address.getUf())
                .build();

        user.address(addressUser);
    }
}
