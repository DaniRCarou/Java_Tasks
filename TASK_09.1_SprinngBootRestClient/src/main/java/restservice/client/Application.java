package restservice.client;

import java.util.List;
import java.util.Scanner;

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
		
	
	
	// We need to initiate this variable to enter the data through the console
	
	static Scanner sc;
	
	
	
	
	
	
	
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
	
	
	
	
	
	public void stopApplication() {
		
		
		/*
		 This application starts a web server, so we need to give the command to stop it when we're done. 
		 To do this, we use the 'exit' method of the 'SpringApplication' class, 
		 which requires both the Spring context and an object implementing the 'ExitCodeGenerator' interface. We can use the lambda function '() -> 0' to simplify.
		*/
		
		
		SpringApplication.exit(context, () -> 0); // le pasamos una funci�n landa, un c�digo est�ndar de finalizaci�n.
		
	}
	
	
	
	
	
	
	
	
	public static int menu() {
		
		sc = new Scanner(System.in);
		
		int option = 0;
		
		
			
		System.out.println("\n" + "Type an option from 1 to 5 or 0 to exit" + "\n");	
		
		System.out.println("1. Register a video game" );
			
		System.out.println("2. Delete a video game by ID");
			
		System.out.println("3. Modify a video game by ID");
		
		System.out.println("4. Get a video game by ID");
		
		System.out.println("5. List all video games" + "\n");		
					
		System.out.println("0. If you wish to exit the application");
		
			
			
		option = sc.nextInt();
		
		/*

		Consume the pending new line before reading user input. In this case, sc.nextLine() is added before the actual reading of the user input. This helps to consume the pending new line after the selected option in the menu.
		After doing this, you should be able to read the user's input correctly without the "You haven't typed anything" message appearing for no apparent reason.
		When working with standard input in Java, especially with Scanner objects, there may be new line characters ('\n') left hanging in the system buffer after reading a numeric value or string. This is common, for example, when you read a number with nextInt() and then perform an additional read with nextLine().

		The line "//Consume pending newline before reading user input" refers to adding an additional nextLine() call to explicitly consume that newline left in the buffer after reading the numeric menu option. This is necessary because after the user enters a number and presses "Enter", the new line character ('\n') remains in the system buffer.
		When you then call nextLine() to read user input (e.g. the ISBN code), if you don't consume that pending newline character, nextLine() could simply read that character and return an empty string.
		Therefore, adding sc.nextLine() before reading actual user input ensures that any outstanding newline characters are consumed before reading user input, preventing unexpected problems with user input.
		
		*/
			
		sc.nextLine();
		
		return option;	
		
		
		
	}	
	
	
	// This is the only method contained within the interface CommandLineRunner. It is dynamic.
	// As this method is dynamic, it can now execute all attributes that the class has.
	// It is a mechanism provided by Spring so that the same class containing a main method can use dependency injections made with its attributes.
	
	@Override
	public void run(String... args) throws Exception {		
		
			
		int option = 0;
		
		do {
			
			
			
			option = menu(); // The menu is displayed in the console, an option must be selected and after that will be saved on this variable (option).
			
			
		
			
		// Now, this option would be compare with every case to display a message and introduce new data to send them to the server.
			
		switch(option) {
		
		
				
			
			case 1:						
				
				
				System.out.println("Selected option: " + option + " -> Please, enter the name of the video game: ");
				
			    String name = sc.nextLine();
			 	
			    System.out.println("Please, enter the name of the company: ");
			    
			    String company = sc.nextLine();

			    System.out.println("Please, enter the rating of the video game: ");
			    
			     int rating = sc.nextInt();sc.nextLine();
			     
			     
			     
			    VideoGame videoGame = new VideoGame();
			    
			 	
			 	videoGame.setName(name);
			 	
			 	videoGame.setCompany(company);
			 	
			 	videoGame.setGrade(rating);	
			 	
			 	
			 	VideoGame vRegister = vps.register(videoGame);
			 				 	
			 	
				System.out.println("Video game registered " + vRegister +"\n");
				
				
				break;   			
				
			
			case 2:				
				
				System.out.println("Selected option: " + option + " -> Please, enter the ID of the video game to delete: ");
				
			    int id = sc.nextInt();sc.nextLine();
			    
				boolean deleted = vps.delete(id);
				
				System.out.println("run -> Video game with id: " + id +" has been deleted: "+ deleted +"\n");
				
				
				
				break;
				
			case 3:				
									
								
				System.out.println("Selected option: " + option + " -> Please, enter the ID of the video game to modify: ");
				
			    id = sc.nextInt();sc.nextLine();

			    System.out.println("Please, enter the name of the video game to modify:");
			    
			    name = sc.nextLine();
			 	
			    System.out.println("Please, enter the name of the company to modify:");
			    
			    company = sc.nextLine();

			    System.out.println("Please, enter the rating of the video game to modify: ");
			    
			    rating = sc.nextInt();sc.nextLine();
			    
			    
			    
			    VideoGame vModify = new VideoGame();
				
				vModify.setId(id);
				
				vModify.setName(name);
				
				vModify.setCompany(company);
				
				vModify.setGrade(rating);
				
				boolean modified = vps.modify(vModify);
				
				
				System.out.println("Video game has benn modified: " +  modified);
			    
			    
			    break;
				
			
			case 4:				
				
				System.out.println("Selected option: " + option + " -> Enter the ID of the video game to consult: ");
				
				id = sc.nextInt();sc.nextLine();  				
				
				videoGame =vps.obtain(id);
				
				System.out.println("Video game with id " + id + ": " + videoGame);			
				
				
				break;
				
			case 5:				
				
				List<VideoGame> videoGamesList = vps.list(null);
				
				videoGamesList.forEach((v) -> System.out.println(v));
				
				
				
				break;
				
			case 0: 
				
				stopApplication();			
				
				break;					
				
							
				default: 
					
					System.out.println("wrong option");
			
			
		}
	
	
			
	} while(option!=0);
		
		System.out.println("Exit done");
		
		
		sc.close();	
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
