package com.customer.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
 	private String api = "Customer MS";
	private String swaggerInfo = "Customer MS";
	private String termsOfControllerUrl = "http://www.customer.com";
	private String contact = "http://www.customer.com";
	private String version = "1.0.0";
	private String createdBy = "Srijan";
	private String contactMailId = "srijnsai007@gmail.com";
	private String termsOfConditions = "Terms of service";
	
	// method to define swagger configuration for customer ms
	@Bean
	public Docket configswagger() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.customer")).paths(PathSelectors.any())
				.build().apiInfo(defineAPIInfo());
	}
	// method to define swagger configuration with properties
	public ApiInfo defineAPIInfo() {
		return new ApiInfo(api,swaggerInfo,version,termsOfConditions,
				new Contact(createdBy,contactMailId,termsOfControllerUrl),contact,version);	
	}

}
