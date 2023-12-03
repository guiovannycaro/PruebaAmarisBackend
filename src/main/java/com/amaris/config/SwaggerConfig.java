package com.amaris.config;

import org.springframework.context.annotation.Bean;

import com.google.common.base.Predicates;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.ApiInfo;


@EnableSwagger2
public class SwaggerConfig {
	
	 @Bean
	 public Docket apis() {
		 return new Docket(DocumentationType.SWAGGER_2)
				 .select()
				 .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
				 .build().apiInfo(apiInfo());
	 }
	 
	 private ApiInfo apiInfo() {
			return new ApiInfoBuilder().title("Documentación Api Amaris ").description("Servicios De Consultas")
					.version("1.0").build();
		}
}
