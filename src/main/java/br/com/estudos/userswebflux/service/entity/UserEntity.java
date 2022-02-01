package br.com.estudos.userswebflux.service.entity;

import br.com.estudos.userswebflux.service.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("userEntity")
public class UserEntity {

    @Id
    private String id;
    private String name;
    private String cpf;
    private String email;
    private String password;
    private Address address;
}