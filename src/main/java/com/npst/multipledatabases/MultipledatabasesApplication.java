package com.npst.multipledatabases;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.npst")
@EntityScan("com.npst")
public class MultipledatabasesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultipledatabasesApplication.class, args);
	}

}
