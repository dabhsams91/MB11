package com.mb11.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.mb11.application.config.MB11Properties;

@SpringBootApplication
@EnableConfigurationProperties(MB11Properties.class)
public class MB11App 
{
	
	public static void main(String[] args) {
		SpringApplication.run(MB11App.class, args);
	}
}
