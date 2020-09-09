package com.ouc.forum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author sunhaojie
 * @version 1.0
 * @date 2020/9/8
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ouc.forum.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("ouc forum backend api")
                .description("ouc forum backend RESTful APIs")
                .termsOfServiceUrl("https://github.com/sunshine2285/ouc-forum")
                .contact(new Contact("ouc-forum backend",
                        "https://github.com/sunshine2285/ouc-forum",
                        "sunshine2285@163.com"))
                .version("1.0")
                .build();
    }
}
