package com.wavesdev.session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
public class SpringSessionJdbcDemoApplication extends SpringBootServletInitializer {


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringSessionJdbcDemoApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringSessionJdbcDemoApplication.class, args);
	}
}
