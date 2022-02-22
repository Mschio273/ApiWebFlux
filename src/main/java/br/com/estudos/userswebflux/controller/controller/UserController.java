package br.com.estudos.userswebflux.controller.controller;

import br.com.estudos.userswebflux.controller.model.UserControllerRequest;
import br.com.estudos.userswebflux.controller.model.UserControllerResponse;
import br.com.estudos.userswebflux.service.model.Address;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/user")
//@Api(value = "API REST de cadastro de usuário")
//@CrossOrigin(origins = "*")
@AllArgsConstructor
public class UserController {

    private final UserControllerFacade controllerFacade;

    @GetMapping
    @ResponseStatus(OK)
//    @UserGetAllCode
    public Flux<UserControllerResponse> findAll() {
        return controllerFacade.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
//    @UserGetByIdCode
    public Mono<UserControllerResponse> findById(@PathVariable String id) {
        return controllerFacade.findById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
//    @SaveCode
    public Mono<UserControllerResponse> save(@RequestBody @Valid UserControllerRequest user) {
        return controllerFacade.save(user);
    }

    @PutMapping("/{id}")
    @ResponseStatus(OK)
//    @UpdateCode
    public Mono<UserControllerResponse> update(@PathVariable String id, @RequestBody @Valid UserControllerRequest user) {
        return controllerFacade.update(id, user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
//    @DeleteCode
    public Mono<Void> delete(@PathVariable String id) {
        return controllerFacade.delete(id);
    }

    @GetMapping("/test")
    public Mono<Address> test(@RequestParam String cep) {

        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        WebClient webclient = WebClient.create(url);

        Mono<Address> addressMono = webclient.get()
                .retrieve()
                .bodyToMono(Address.class);

        System.out.println(addressMono);
        return addressMono;
    }
}