package restservice.model.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import restservice.model.entity.VideoGame;




 // DAO (Data Access Object), repository or persistence class.
 // This is an CRUD object (Create, Read, Update, Delete), responsible for handling connections to the database.
 // using the @Component annotation indicates that an object will be registered in the spring context

@Component
public class DaoVideoGame {
	
	
	
	public List<VideoGame> VideoGameList;
	
	public int counter;
	
	
	
	
	
	

	public DaoVideoGame() {
	super();	
	
		System.out.println("DaoVideoGame -> Creating the Video game list");
		
		VideoGameList = new ArrayList<VideoGame>();
		
		VideoGame v1 = new VideoGame(counter++, "It takes two", "Mi casa", 10); // ID: 0
		VideoGame v2 = new VideoGame(counter++, "Worms", "Tu casa", 6); // ID: 1
		VideoGame v3 = new VideoGame(counter++, "The last campfire", "Amigo", 7); // ID: 2
		VideoGame v4 = new VideoGame(counter++, "Darksiders", "Vicio", 8); // ID: 3
		VideoGame v5 = new VideoGame(counter++, "Monster energy supercross", "Star", 7); // ID: 4
		
		VideoGameList.add(v1);
		VideoGameList.add(v2);
		VideoGameList.add(v3);
		VideoGameList.add(v4);
		VideoGameList.add(v5);
		
		
	}
	
	
	
	
	
	
	
	// ESTO HAY QUE MODIFICARLO, LOS PARÁMETROS DE ENTRADA
	
	public VideoGame get(int position) { 
		
		try {
			
			return VideoGameList.get(position);
			
		}catch(IndexOutOfBoundsException iobe) {
			
			System.out.println("Video game out of range");
			
			return null;
			
		}		
		
	}
	
	
	
	
	
	
	
	
	// This method returns the video game list.
	
	public List<VideoGame> list(){
		
		return VideoGameList;
		
	}
	
	
	
	
	
	
	
	// This method enters a video game at the end of the list.
	
	public void add(VideoGame v) {
		
		v.setId(counter++);
		VideoGameList.add(v);
		
	}
	
	
	
	
	
	
	
	// This method deletes the video game which is in the position that is entered by parameter
	
	public VideoGame delete(int position) {
		
		try {
		
			return VideoGameList.remove(position);
		
		}catch (IndexOutOfBoundsException iobe) {
			
			System.out.println("Delete -> Video game out of range");
			
			return null;
			
		}
		
		
	}
	
	
	
		
	
	
	// This method modifies a Video game. 
	// I introduce a new video game with all its new information, but with the ID from the video game I want to update from the list.
	
	public VideoGame update(VideoGame v) {
		
	try {
		
		VideoGame vAux = VideoGameList.get(v.getId()); // With the ID, I should know which one I want to update, when I introduce the new video game, the Video game is located and saved in vAux variable. 
		
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
		
		for(VideoGame v : VideoGameList) {
			
			if(v.getName().equalsIgnoreCase(Name)) { // with "contains" would check to if every video game of the VideoGameList includes this name.
				
				VideoGameListAux.add(v);
				
			}			
			
		}
		
		return VideoGameListAux;
		
	}
	
	
}