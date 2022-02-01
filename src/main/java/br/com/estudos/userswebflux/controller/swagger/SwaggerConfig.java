//package br.com.estudos.userswebflux.controller.swagger;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.service.VendorExtension;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.ArrayList;
//
//import static springfox.documentation.builders.PathSelectors.regex;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//    @Bean
//    public Docket productApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("br.com.estudos.userswebflux"))
//                .paths(regex("/api/v1/user.*"))
//                .build()
//                .apiInfo(metaInfo());
//    }
//
//    private ApiInfo metaInfo() {
//        ApiInfo apiInfo = new ApiInfo(
//                "Users API REST",
//                "API REST de cadastro de usuários",
//                "1.0",
//                "Terms of service",
//                new Contact("Matheus Schio",
//                        "https://www.linkedin.com/in/matheus-schio-05556a1a3/",
//                        "matheus.schiod@gmail.com"),
//                "Apache License Version 2.0",
//                "https://www.apache.org/license.html", new ArrayList<VendorExtension>()
//        );
//        return apiInfo;
//    }
//}
