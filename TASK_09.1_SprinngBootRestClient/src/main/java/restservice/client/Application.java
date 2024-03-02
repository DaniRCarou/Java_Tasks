package restservice.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import restservice.client.entity.VideoGame;
import restservice.client.service.VideoGameProxyService;

// to test this applications it will be used "debug as", to watch it step by step
// f6 -> to watch every step
// f5 -> to go inside the methode






// The interface CommandLineRunner has only one method.
// When we implement an interface, we are obligated to implement all its methods.

@SpringBootApplication
public class Application implements CommandLineRunner {
		
		
	// The annotations @Autowired can only be used with dynamic attributes; 
	// they cannot be used within static attributes
	
	
	
	// With the @Autowired annotation, 
	// it will search for an object of type VideoGameProxyService within the Spring context. 	
	// The Spring Boot application class will inject an object of type VideoGameProxyService.
	
	@Autowired 
	private VideoGameProxyService vps;
		
	
	
	// As the Spring context is also an object, it is posible to make a reference to ApplicationContext, Spring Boot
	// --------- Why do I need a reference to Spring context? ----------------	
	
	@Autowired
	private ApplicationContext context;
		
	
	
	// the RestTemplate object is the most important in this application. 
	// It will allow making calls easily to the Spring Boot Rest controller of exercise_09. 
	// So it is necesary an RestTemplate type object
	// With the annotation @Bean, is posible to create an object only by using the method, without creating a class of this object.
	// All methods created within a class annotated with @SpringBootApplication will be executed. 
	// And the object we return will be registered by the Spring context.
	// The name of this object will be the name or id within the Spring context.
	
	//This object will know how to do the connections with the SpringBootRest project
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		
		return builder.build(); // The object will is going to be built
		
	}
	
	
	
	// This is the only method contained within the interface CommandLineRunner. It is dynamic

	
		
		
	public static void main(String[] args) {
		
		
		System.out.println("Client -> Loading Spring context");
				
		
		/*
		 
		By using the 'run' method, the Spring context will be started, 
		and we will register all the objects configured in our application, 
		along with their dependencies on other objects.
		
		*/		
		
		SpringApplication.run(Application.class, args); // Application is the class that contains the run method.
			
		
		
	}	
	
	
	
	// As this method is dynamic, it can now execute all attributes that the class has.
	// It is a mechanism provided by Spring so that the same class containing a main method can use dependency injections made with its attributes.
	
	@Override
	public void run(String... args) throws Exception {
		
		
		
		
		
	System.out.println("***STARTING THE REST CLIENT***");	
	
	
	
		
	System.out.println("************ Register a video game ************");
	
	
	
	
	VideoGame videoGame = new VideoGame();
	
	videoGame.setName("Best Mafia");
	
	videoGame.setCompany("Columbia");
	
	videoGame.setGrade(9);
	
	
	VideoGame vRegister = vps.register(videoGame);
	
	System.out.println("Registered video game: " + vRegister);
	
	
	
	
	System.out.println("************ Getting the video game ************");
	
	
	
	
	videoGame =vps.obtain(vRegister.getId());
	
	System.out.println("Video game with id 5: " + videoGame);
	
	
	
	
	System.out.println("************ Modify a video game ************");
	
	
	
	
	VideoGame vModify = new VideoGame();
	
	vModify.setId(vRegister.getId());
	vModify.setName("Wonder");
	vModify.setCompany("Taurus GmbH");
	vModify.setGrade(9);
	
	boolean modified = vps.modify(vModify);
	
	System.out.println("Video game modified? " +  modified);
	
	
	
	
	
	System.out.println("************ Delete a video game ************");
	
	
	
	
	boolean deleted = vps.delete(vRegister.getId());
	
	System.out.println("Video game with id 5 deleted? " + deleted);
	
	
	
	
	
	System.out.println("************ List video games ************");
	
	
	
	
	List<VideoGame> videoGamesList = vps.list(null);
	
	videoGamesList.forEach((v) -> System.out.println(v)); // This is a Landa function, functional programming.
	
	
	// videoGameList -> this list hast to be traversed
	// forEach() -> for each element has to be executed this function: ((v) -> System.out.println(v)) 
	// ((v) -> System.out.println(v)) -> this Landa function has or not input parameters "((v) ->" and after that the function we want to execute.
	// (v) -> It is each element of the list.
	
	
	
	
	stopApplication();
	
	
	
	
			
	}
	
	
	
	public void stopApplication() {
		
		SpringApplication.exit(context, () -> 0); // le pasamos una función landa, un código estándar de finalización.
		
	}
	
	
	

}
