package restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



/*

 This is the entry point of our application. Spring web, will start the Tomcat server.

	- @SpringBootApplication: With this annotation, Spring search for Spring annotations to register objects and inject dependencies.

	- It will look for methods within this class with the @Bean annotation, to register them as objects within the Spring context.
  
	- To ensure that Spring Boot correctly detects all annotations and registers objects properly within the Spring context, 
      all classes must be in the same package or in a child package of the application's root package.
 
*/


@SpringBootApplication
public class Application {
	

	public static void main(String[] args) {
				
		
		
		
		System.out.println("Rest Service -> Loading Spring context");
		
		
		
		
		/*
		 
		By using the 'run' method, the Spring context will be started, 
		and we will register all the objects configured in our application, 
		along with their dependencies on other objects.
		
		*/		
		
		SpringApplication.run(Application.class, args);
		
		
		
		
		
		
		
		System.out.println("Rest Service -> Spring context Loaded");
		
		
		
		
		
	}

}
