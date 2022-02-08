package com.generali.burritoorderingservice.com.generali.burritoorderingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:/application-context.xml")
//@EnableAutoConfiguration(exclude = {WebMvcAutoConfiguration.class })
public class BurritoOrderingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BurritoOrderingServiceApplication.class, args);
	}

}
