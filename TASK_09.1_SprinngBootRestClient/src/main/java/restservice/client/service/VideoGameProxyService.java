
package restservice.client.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import restservice.client.entity.VideoGame;

// Being a Spring Boot application, it will be deployed on a server. Therefore, 
// it will have to have a different configuration port (8081) than the TASK_09_SpringBootRest project (8080).


// THIS CLASS WILL MAKE ALL REQUEST TO THE VideoGameController
// With the annotation @Service, an object of type VideoGameProxyService will be registered within the Spring context.

@Service
public class VideoGameProxyService {
	
	
	// This is the base URL of the VideoGames REST service, which will be used throughout this program.
	
	public static final String URL = "http://localhost:8080/videogames/";
	
	
	
	// The restTemplate type object will be injected here but created on the Application class.
	// With the annotation @Autowired, dependency injection can be applied.
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	
	
	
	
	
	

	
	public VideoGame obtain(int id){
		
		try {
		
		// It will be worked with ResponseEntity object
		ResponseEntity<VideoGame> re= restTemplate.getForEntity(URL + id, VideoGame.class);
		
		HttpStatus hs= re.getStatusCode();
		
		if(hs == HttpStatus.OK)	{
			
			return re.getBody();			
			
		}else {
			
			System.out.println("Unfinished response");
			return null;
			
		}
		
		}catch(HttpClientErrorException e) {
			
			System.out.println("the video game has not been found");
			System.out.println("Response code: " + e.getStatusCode());
			return null;
		}		
	
	}
	
	
	
	public VideoGame register(VideoGame v) {
		
		try {
			
			ResponseEntity<VideoGame> re = restTemplate.postForEntity(URL, v, VideoGame.class);
			
			System.out.println("Register -> Response code: " + re.getStatusCode());
			
			return re.getBody();
			
		}catch (HttpClientErrorException e) {
			
			System.out.println("Register -> VideoGame was not registered, id: " + v);
			
			System.out.println("Register -> Response code: " + e.getStatusCode());
		
			return null;
			
		}
		
		
	}
	
	
	public boolean modify(VideoGame v) {

		try {
			
			restTemplate.put(URL + v.getId(), v, VideoGame.class);
						
			return true;
			
		}catch (HttpClientErrorException e) {
			
			System.out.println("Register -> VideoGame was not modified, id: " + v);
			
			System.out.println("Register -> Response code: " + e.getStatusCode());
		
			return false;
			
		}
		
		
	}
	
	
	
	public boolean delete(int id) {

		try {
			
			restTemplate.delete(URL + id);
						
			return true;
			
		}catch (HttpClientErrorException e) {
			
			System.out.println("Register -> VideoGame was not deleted, id: " + id);
			
			System.out.println("Register -> Response code: " + e.getStatusCode());
		
			return false;
			
		}
		
		
	}
	
	
	
	
	
	
	public List<VideoGame> list(String name) {

		String queryParams = "";
		
		if(name != null) {
			
			queryParams += "name= " + name;
			
		}
		
		try {
			 
			// With ResponseEntity is not allowed working with ArrayList, it has to be a normal Array
			
			ResponseEntity<VideoGame[]> response = restTemplate.getForEntity(URL + queryParams, VideoGame[].class);
			
			VideoGame[] arrayVideoGames = response.getBody();			
			
			return Arrays.asList(arrayVideoGames); // this methode convert a normal Array in an ArrayList
			
		}catch (HttpClientErrorException e) {
			
			System.out.println("List -> Error while retrieving the list of video games.");
			
			System.out.println("Register -> Response code: " + e.getStatusCode());
		
			return null;
			
		}
		
		
	}
	
	
	

}
