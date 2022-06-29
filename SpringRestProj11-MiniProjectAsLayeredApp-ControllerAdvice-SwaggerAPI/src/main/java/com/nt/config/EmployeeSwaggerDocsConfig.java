package com.nt.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Api;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Api("Swagger Documentation for Employee :")
public class EmployeeSwaggerDocsConfig {

	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.nt.rest"))
				.paths(PathSelectors.regex("/emp.*")).build().useDefaultResponseMessages(true)
				.apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		Contact contact = new Contact("Nazeer", "https://www.KRTile.com", "krtiles@gmail.com");
		return new ApiInfo("EmployeeAPI", "Provides CURD operations on Employee", "1.0.RELEASE", "http://KRTiles.com",
				contact, "GNU Public", "https:/KRTiles.com/lisence/gnu", Collections.emptyList());
	}

}
