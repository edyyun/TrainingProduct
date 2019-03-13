package com.training.productweb;

import com.training.productweb.Entity.ApiKeyHandlerMehtodArgumentResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication
public class ProductWebApplication implements WebMvcConfigurer {

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		resolvers.add(new ApiKeyHandlerMehtodArgumentResolver());
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductWebApplication.class, args);
	}

}
