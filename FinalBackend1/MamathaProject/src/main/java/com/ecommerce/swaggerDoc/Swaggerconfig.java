package com.ecommerce.swaggerDoc;


import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swaggerconfig {
	
	@Bean
	    public GroupedOpenApi controllerApi() {
	        return GroupedOpenApi.builder()
	                .group("MamathaProject")
	                .packagesToScan("com.ecommerce.controller") 
	                .build();
		}
	}



