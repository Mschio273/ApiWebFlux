package br.com.estudos.userswebflux.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserServiceRequest {

    private String id;
    private String name;
    private String cpf;
    private String email;
    private String password;
    private String cep;
    private Address address;
}