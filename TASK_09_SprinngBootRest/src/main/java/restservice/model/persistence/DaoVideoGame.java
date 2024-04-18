package restservice.model.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import restservice.model.entity.VideoGame;




 // DAO (Data Access Object), repository or persistence class. 
 // This DAO object will allow doing the persistence. 
 // In this case the DAO is simulated, created at the same DAO class
 // But the methods of this class could be modified to access a database, and the controller class would remain the same.
 // This is what allows layer programming.


 // Using the @Component annotation indicates that an object will be registered in the spring context

@Component
public class DaoVideoGame {
	
	
 
	public List<VideoGame> videoGameList;
	
	public int counter;
	
	
	
	
	
	

	public DaoVideoGame() {
	super();	
	
		System.out.println("DaoVideoGame -> Creating the Video game list");
		
		
		// This object, VideoGameList will be created within the JVM and not within the Spring context, because a "new" has been done.
		// Since this ArrayList object will be referenced by another object, DaoVideoGame, within the Spring context, 
		// it will last as long as the DaoVideoGame object lasts.
		
		videoGameList = new ArrayList<VideoGame>();
		
		
		
		
		// Five objects will be created to be added to the VideoGameList
		// These objects, VideoGame will be created within the JVM and not within the Spring context, because a "new" has been done.
		
		VideoGame v1 = new VideoGame(counter++, "It takes two", "Mi casa", 10); // ID: 0
		VideoGame v2 = new VideoGame(counter++, "Worms", "Tu casa", 6); // ID: 1
		VideoGame v3 = new VideoGame(counter++, "The last campfire", "Amigo", 7); // ID: 2
		VideoGame v4 = new VideoGame(counter++, "Darksiders", "Vicio", 8); // ID: 3
		VideoGame v5 = new VideoGame(counter++, "Monster energy supercross", "Star", 7); // ID: 4
		
		
		// Every VideoGame will be added at the VideoGameList
		
		videoGameList.add(v1);
		videoGameList.add(v2);
		videoGameList.add(v3);
		videoGameList.add(v4);
		videoGameList.add(v5);
		
		
	}
	
	
	
	
	
	
	
	
	
       // Returns a video game based on the array position.
	 	
	public VideoGame get(int position) { 
		
		try {
			
			return videoGameList.get(position);
			
		}catch(IndexOutOfBoundsException iobe) {
			
			System.out.println("Video game out of range");
			
			return null;
			
		}		
		
	}
	
	
	
	
	
	
	
	
	// This method returns the video game list.
	
	public List<VideoGame> list(){
		
		return videoGameList;
		
	}
	
	
	
	
	
	
	
	// This method enters a video game at the end of the list.
	
	public void add(VideoGame v) {
		
		v.setId(counter++);
		
		videoGameList.add(v);
		
	}
	
	
	
	
	
	
	
	// This method deletes the video game which is in the position that is entered by parameter
	
	public VideoGame delete(int position) {
		
		try {
		
			return videoGameList.remove(position);
		
		}catch (IndexOutOfBoundsException iobe) {
			
			System.out.println("Delete -> Video game out of range");
			
			return null;
			
		}
		
		
	}
	
	
	
		
	
	
	// This method modifies a Video game. 
	// I introduce a new video game with all its new information, but with the ID from the video game I want to update from the list.
	
	public VideoGame update(VideoGame v) {
		
	try {
		
		VideoGame vAux = videoGameList.get(v.getId()); // With the ID, I should know which one I want to update, when I introduce the new video game, the Video game is located and saved in vAux variable. 
		
		vAux.setName(v.getName());
			
		vAux.setCompany(v.getCompany());
			
		vAux.setGrade(v.getGrade());			
				
		return vAux;		
		
	}catch(IndexOutOfBoundsException iobe) {
		
		System.out.println("Update -> Video game out of range");
		
		return null;	
		
		}	
		
	}
		
	
	
	
	
		
	
	// This method lists by name
	
	public List<VideoGame> listByName(String Name){
		
		List<VideoGame> VideoGameListAux = new ArrayList<VideoGame>();
		
		for(VideoGame v : videoGameList) {
			
			if(v.getName().equalsIgnoreCase(Name)) { // with "contains" would check to if every video game of the VideoGameList includes this name.
				
				VideoGameListAux.add(v);
				
			}			
			
		}
		
		return VideoGameListAux;
		
	}
	
	
}