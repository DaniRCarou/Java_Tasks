package restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import restservice.model.entity.VideoGame;
import restservice.model.persistence.DaoVideoGame;


// REST (Representational State Transfer)  is a software architecture that defines a set of principles for designing web services that are lightweight, scalable, and easily integrable.

// This is a very important class, where it is defined the "endpoints" of the API REST and specifies how incoming HTTP requests are handled. 
// If I decide to create a data base, in the class DaoVideoGame could be modified to acces in a database (methodes connect to a database), it is not necesary to change the controller class.
// This object allows HTTP requests to be made from clients


@RestController
public class VideoGameController {
	
	
	
	
	
	// This controller needs an object DaoVideoGame, through the @Autowired annotation, To manage dependencies between the components of an application.
	// it is named "dependency injection"
	
	@Autowired
	private DaoVideoGame daoVideoGame;
	
	
	
	
	
	
	
	
	// PATH -> To get a video game by id we will write in the path, {id} to indicate that inside of "{}" will be a number.
	// If there is no braces, it will show all the video games by id
	// Inside the parentheses, you indicate what the input parameter is called and where you should replace it. 
	// In this case, in the path, where there is a variable called {id}.
	// ResponseEntity -> allow us, not only to get a  videoGame object, but also answer code, like "200 OK"
	
	@GetMapping(path="videogames/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VideoGame>getVideoGame(@PathVariable("id") int id){
		
		System.out.println("Looking for a video game with id: " + id);
		
		VideoGame v = daoVideoGame.get(id);
		
		if(v != null) {
			
			return new ResponseEntity<VideoGame>(v,HttpStatus.OK); // 200 OK
			
		}else {
			
			return new ResponseEntity<VideoGame>(v,HttpStatus.NOT_FOUND); // 404 NOT FOUND
			
		}
		
	}
	
	
	
	
	
	
	
	
	// To add a video game, it will be used the POST method. 
	// It produces a JSON message by the server 
	// and the message sent by the client application will be of type JSON too
	
	
	@PostMapping(path="videogames", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VideoGame> registerVideoGame(@RequestBody VideoGame v) {
		
		System.out.println("registerVideoGame: object videoGame: " + v);
		
		daoVideoGame.add(v);
		
		return new ResponseEntity<VideoGame>(v,HttpStatus.CREATED); // 201 CREATED
		
	}
	
	

}
