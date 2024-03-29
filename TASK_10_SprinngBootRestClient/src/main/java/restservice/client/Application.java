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

// To test this applications it will be used "debug as", to watch it step by step
// f6 -> to watch every step
// f5 -> to go inside the method






// The interface (An interface is a collection of abstract methods) CommandLineRunner has only one method. The method run, which is dynamic.
// When we implement an interface, we are obligated to implement all its methods. In this case only the method run.

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	
	
		
	// The annotations @Autowired can only be used with dynamic attributes; 
	// they cannot be used within static attributes
	
	
	// You need a reference to the VideoGameProxyService object.
	// With the @Autowired annotation, dependency injection can be applied. 
	// With the @Autowired annotation, it will search for an object of type VideoGameProxyService within the Spring context. 	
	// The Spring Boot application class will inject an object of type VideoGameProxyService.
	
	@Autowired 
	private VideoGameProxyService vps;
		
	
	
	
	
	
	// As the Spring context is also an object, it is possible to make a reference to ApplicationContext, Spring Boot
	// --------- Why do I need a reference to Spring context? ----------------	
	
	@Autowired
	private ApplicationContext context;
		
	
	
	
	
	
	
	
	/*
	 The RestTemplate object is the most important in this application. 
	 
	 It will allow making calls easily to the Spring Boot Rest controller of exercise_09. 
	 So it is necessary an RestTemplate type object
	 With the annotation @Bean, is possible to create an object only by using the method, without creating a class of this object.
	 All methods created within a class annotated with @SpringBootApplication will be executed. 
	 And the object we return will be registered by the Spring context.
	 The name of this object will be the name or id within the Spring context.
	
	 This object will know how to do the connections with the SpringBootRest project
	*/
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) { // This method returns an object of type RestTemplate And the object it returns will be registered in the Spring context.
		
		return builder.build(); // The object is going to be built and returned
		
	}
	
	
	
	
	
	
	
	
	
	
		
	
	// In this main method it is not possible to see the vps object for example, because it is static.
	// Spring doesn't work with nothing static, so the only way to see an object like vps, which is dynamic, is	by implementing the CommandLineRunner interface at the beginning of this class
	// The only method contained within the interface CommandLineRunner is the "run" method, which is dynamic.
	
	public static void main(String[] args) {
		
		
		
		
		
		System.out.println("Client -> Loading Spring context");
				
		
		/*
		 By using the 'run' method, the Spring context will be started, 
		 and we will register all the objects configured in our application, 
		 along with their dependencies on other objects.
		
		 This is the only method contained within the interface CommandLineRunner. It is dynamic.
		 With this method is possible to use the dynamic attribute vps
	    */		
		
		SpringApplication.run(Application.class, args); // Application.class is the class that contains the run method. THIS CLASS WHERE YOU ARE
			
		
		
	}	
	
	
	
	
	
	
	
	
	
	
	// This is the only method contained within the interface CommandLineRunner. It is dynamic.
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
	
	
	// videoGameList -> this list has to be traversed
	// forEach() -> for each element has to be executed this function: ((v) -> System.out.println(v)) 
	// ((v) -> System.out.println(v)) -> this Landa function has or not input parameters "((v) ->" and after that the function we want to execute.
	// (v) -> It is each element of the list.
	
	
	
	
	stopApplication();
	
	
	
	
			
	}
	
	
	
	
	
	
	
	
	
	public void stopApplication() {
		
		
		/*
		 This application starts a web server, so we need to give the command to stop it when we're done. 
		 To do this, we use the 'exit' method of the 'SpringApplication' class, 
		 which requires both the Spring context and an object implementing the 'ExitCodeGenerator' interface. We can use the lambda function '() -> 0' to simplify.
		*/
		
		
		SpringApplication.exit(context, () -> 0); // le pasamos una funci�n landa, un c�digo est�ndar de finalizaci�n.
		
	}
	
	
	

}
