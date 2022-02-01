package br.com.estudos.userswebflux.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserControllerRequest {

    private String id;
    @NotNull
    private String name;
    @CPF
    private String cpf;
    @Email
    private String email;
    @NotNull
    private String password;
    @Size(min = 8, max = 9)
    private String cep;
}