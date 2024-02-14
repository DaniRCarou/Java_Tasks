
package restservice.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

// Being a Spring Boot application, it will be deployed on a server. Therefore, 
// it will have to have a different configuration port (8081) than the TASK_09_SpringBootRest project (8080).


// This class will make all requests to the VideoGameController

// With the annotation @Service, an object of type VideoGameProxyService will be registered within the Spring context.

@Service
public class VideoGameProxyService {
	
	
	// This is the base URL of the VideoGames REST service, which will be used throughout this program.
	
	public static final String URL = "http://localhost:8080/videogames/";
	
	
	
	// the restTemplate type object will be injected here but created on the Application class.
	
	@Autowired
	private RestTemplate restTemplate;

}
