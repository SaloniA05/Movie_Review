package com.project.Movies;

import org.springframework.boot.SpringApplication; //spring application is a class - contains a method called run
import org.springframework.boot.autoconfigure.SpringBootApplication; //imports the spring boot application annotation
//annotations help the compiler know what the class does

@SpringBootApplication
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args); //calling the run method of spring application class
		// and pass your application class to it
	}

}
