package com.example.conserto_p2_prw3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class ConsertoP2Prw3Application {

	public static void main(String[] args) {
		SpringApplication.run(ConsertoP2Prw3Application.class, args);
	}

}
