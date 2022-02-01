//package br.com.estudos.userswebflux.controller.swagger.annotations;
//
//import br.com.estudos.userswebflux.controller.model.UserControllerResponse;
//import br.com.estudos.userswebflux.exception.StandardError;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//
//import static br.com.estudos.userswebflux.controller.swagger.annotations.ConstantsSwagger.GET_ALL_USERS_DESCRIPTION;
//import static br.com.estudos.userswebflux.controller.swagger.annotations.ConstantsSwagger.GET_ALL_USERS_SUMMARY;
//
//
//@ApiResponses({
//        @ApiResponse(code = 200, message = "Busca realizada com sucesso", response = UserControllerResponse[].class),
//        @ApiResponse(code = 400, message = "Não foi possivel realizar a chamada", response = StandardError.class),
//        @ApiResponse(code = 500, message = "Erro server-side", response = StandardError.class),
//        @ApiResponse(code = 404, message = "Recurso não encontrado", response = StandardError.class)
//})
//@ApiOperation(value = GET_ALL_USERS_SUMMARY, notes = GET_ALL_USERS_DESCRIPTION)
//public @interface UserGetByIdCode {
//}
