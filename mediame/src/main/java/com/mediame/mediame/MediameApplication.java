package com.mediame.mediame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan(basePackages = "com.mediame, com.mediame.mediame.entity")
@EnableAutoConfiguration
@EntityScan(basePackages = "com.mediame.mediame.entity")
public class MediameApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediameApplication.class, args);
	}

}
