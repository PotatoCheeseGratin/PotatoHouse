package com.potatocountry.potatocountry.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI()
			.components(new Components())
			.info(new Info()
				.title("🥔감자상회 API 문서🧑🏻‍🌾")
				.description("감자상회의 API 명세서")
				.version("1.0.0"));
	}
}
