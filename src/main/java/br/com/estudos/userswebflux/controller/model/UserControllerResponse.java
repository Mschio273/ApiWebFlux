package br.com.estudos.userswebflux.controller.model;

import br.com.estudos.userswebflux.service.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserControllerResponse {

    private String id;
    private String name;
    private String cpf;
    private Address address;
}