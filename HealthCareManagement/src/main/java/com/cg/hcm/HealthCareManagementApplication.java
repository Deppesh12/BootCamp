package com.cg.hcm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.builders.RequestHandlerSelectors;

@SpringBootApplication
//declaring class as springBootApplicaiton
@EnableSwagger2
public class HealthCareManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthCareManagementApplication.class, args);
	}
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	@Bean
    public Docket produceApi()
    {
    	return new Docket(DocumentationType.SWAGGER_2).select().
    			apis(RequestHandlerSelectors.basePackage("com.cg.hcm")).build(); 
    }

}
