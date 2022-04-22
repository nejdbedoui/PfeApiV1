package com.bprice.bpapipos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EntityScan(basePackages={"com.bprice.persistance.model"})
@SpringBootApplication
public class BpApiPosApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BpApiPosApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(BpApiPosApplication.class);
	}
}
