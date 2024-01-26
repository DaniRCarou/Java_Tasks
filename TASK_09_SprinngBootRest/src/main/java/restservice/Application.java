package restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
 
 To ensure that Spring Boot correctly detects all annotations and registers objects properly within the Spring context, 
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
