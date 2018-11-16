package com.impetus.ogos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** This class contains the main method invokes the application. */
@SpringBootApplication
//@EnableScheduling
public class ToolInitializer {
	/**
	 * @param args is for command line argument.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ToolInitializer.class, args);
	}
}