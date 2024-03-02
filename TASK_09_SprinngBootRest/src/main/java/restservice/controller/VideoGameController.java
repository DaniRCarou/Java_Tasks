package restservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import restservice.model.entity.VideoGame;
import restservice.model.persistence.DaoVideoGame;


// REST (Representational State Transfer)  is a software architecture that defines a set of principles for designing web services that are lightweight, scalable, and easily integrable.

// This is a very important class, where it is defined the "endpoints" of the API REST and specifies how incoming HTTP requests are handled. 
// If I decide to create a data base, in the class DaoVideoGame could be modified to acces in a database (methodes connect to a database), it is not necesary to change the controller class.
// This object allows HTTP requests to be made from clients

/*
 
 - @RestController: With this annotation,it is indicated that Spring should register an object named VideoGameController.
 
 - It indicates, that the methods of this class (endpoints) will be used as "endpoints" for our server.
 
 
 
 
 */





@RestController
public class VideoGameController {
	
	
	
	
	
	// This controller needs an object DaoVideoGame, through the @Autowired annotation, To manage dependencies between the components of an application.
	// it is named "dependency injection"
	
	@Autowired
	private DaoVideoGame daoVideoGame;
	
	
	
	
	
	// IT IS NOT POSIBLE TO HAVE IN THE SAME SERVICE, TWO MAPPED METHODES WITH THE SAME PATH AND THE SAME VERB (GET, POST,..) 
	
	
	// PATH -> To get a video game by id we will write in the path, {id} to indicate that inside of "{}" will be a number.
	// If there is no braces, it will show all the video games by id
	// Inside the parentheses, you indicate what the input parameter is called and where you should replace it. 
	// In this case, in the path, where there is a variable called {id}.
	// Produces -> It will be the kind of message the cliente will see.
	// ResponseEntity -> allow us, not only to get a  videoGame object, but also answer code, like "200 OK"
	
	@GetMapping(path="videogames/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VideoGame> getVideoGame(@PathVariable("id") int id){
		
		System.out.println("Looking for a video game with id: " + id);
		
		VideoGame v = daoVideoGame.get(id);
		
		if(v != null) {
			
			return new ResponseEntity<VideoGame>(v,HttpStatus.OK); // 200 OK
			
		}else {
			
			return new ResponseEntity<VideoGame>(v,HttpStatus.NOT_FOUND); // 404 NOT FOUND
			
		}
		
	}
	
	
	
	
	
	
	// This method only could be tested through Postman app, and it is only posible to introduce the Person datai as a JSON message without the id, because DaoVideoGame introduces itself the id.
	// To add a video game, it will be used the POST method. 
	// It produces a JSON message by the server 
	// and the message sent by the client application will be of type JSON too
	// As parameter, it will be introduce a Person type object. 

	// @RequestBody -> When this endpoint receives the request, tries to convert the request body to a Person type object, thanks Jackson libraries
	// 
	
	@PostMapping(path="videogames", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VideoGame> registerVideoGame(@RequestBody VideoGame v) {
		
		System.out.println("registerVideoGame: object videoGame without id: " + v);
					
		
		// It has to be checked if the list which return the method listByName(String Name), from the class DaoVideoGame, is empty.
		// If the list is empty, means that it doesn´t exist a video game with the same name
		// So it will be created
		
		if (daoVideoGame.listByName(v.getName()).isEmpty()) {
		
			daoVideoGame.add(v);
			
			return new ResponseEntity<VideoGame>(v,HttpStatus.CREATED); // 201 CREATED	
			
			
		}else {
		
			System.out.println("The name entered already exists");
			
			return new ResponseEntity<VideoGame>(HttpStatus.ALREADY_REPORTED); // 208 Already Reported.
		
		}
		
	}
	
	
	
	
	
	
	
	// Example for this get method -> http://localhost:8080/videogames?name=xxxx
	// required=false -> Means that it is not mandatory to write the name, if it´s true, it is mandatory to write a name
	
	@GetMapping(path="videogames", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VideoGame>> listVideoGames(@RequestParam(name="name", required= false) String name){
		
	List<VideoGame>	videoGameList = null;
		
	if(name == null) {
		
		System.out.println("Listing the people");
		
		videoGameList = daoVideoGame.list();
		
	}else {
		
		System.out.println("Listing the people by name: " + name);
		
		videoGameList = daoVideoGame.listByName(name);
		
		
	}
		
		System.out.println(videoGameList);
		
		return new ResponseEntity<List<VideoGame>>(videoGameList,HttpStatus.OK);
					
	}
	
	
	
	
	
	
	
	
	// Modify -> If it we want to modify by ID, it is necessary the ID for the video game I want to change and the information I want to introduce
	// id will be introduce as a path param, and the video game data in the body of the http message
	// @PathVariable("id") int id -> it converts the id from path to "int id"
	// @RequestBody VideoGame v -> The JSON video game from the body will be converted to a VideoGame type object.  
	
	@PutMapping(path="videogames/{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VideoGame> modifyVideoGame(@PathVariable("id") int id, @RequestBody VideoGame v) {
		
	System.out.println("ID to modify: " + id);	
		
	System.out.println("Datai to modify: " + v);	
	
	v.setId(id);
	
	if (daoVideoGame.listByName(v.getName()).isEmpty()) {
	
	VideoGame vUpdate = daoVideoGame.update(v);	
	
	
	if(vUpdate != null) {
		
		return new ResponseEntity<VideoGame>(HttpStatus.OK); // 200 OK	
		
	}else {
		
		return new ResponseEntity<VideoGame>(HttpStatus.NOT_FOUND); // 404 NOT FOUND
		
	}
	
	}else
		
		System.out.println("The name entered already exists");
	
		return new ResponseEntity<VideoGame>(HttpStatus.ALREADY_REPORTED); // 208 Already Reported.
	
	
	}
	
	
	
	
	
	
	
	@DeleteMapping(path="videogames/{id}")
	public ResponseEntity<VideoGame> deleteVideoGame(@PathVariable("id") int id) {
		
		System.out.println("ID to delete: " + id);
		
		VideoGame v = daoVideoGame.delete(id);
		
		if(v != null) {
			
			return new ResponseEntity<VideoGame>(v,HttpStatus.OK);//200 OK
		
		}else {
		
			return new ResponseEntity<VideoGame>(HttpStatus.NOT_FOUND);//404 NOT FOUND
		
		}
		
	}
	
	
	
	

}
