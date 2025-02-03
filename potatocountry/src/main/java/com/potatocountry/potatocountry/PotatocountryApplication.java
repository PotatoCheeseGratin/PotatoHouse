package com.potatocountry.potatocountry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PotatocountryApplication {

	public static void main(String[] args) {
		System.out.println("args = " + args);
		SpringApplication.run(PotatocountryApplication.class, args);
	}

}
