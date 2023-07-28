package com.example.football.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Configuration
public class ApplicationBeanConfiguration {
	
	@Bean 
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public Gson getGson() {
		return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
	}
}
