package br.com.estudos.userswebflux.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserServiceResponse {

    private String id;
    private String name;
    private String cpf;
    private Address address;
}