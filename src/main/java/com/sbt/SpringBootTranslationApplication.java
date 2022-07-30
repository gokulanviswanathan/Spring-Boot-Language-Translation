package com.sbt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class,
		UserDetailsServiceAutoConfiguration.class })
@ComponentScan(basePackages = "com.sbt")
public class SpringBootTranslationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTranslationApplication.class, args);
	}
}
