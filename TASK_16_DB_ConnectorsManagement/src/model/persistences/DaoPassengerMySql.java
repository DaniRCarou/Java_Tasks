package model.persistences;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Passenger;
import model.persistence.interfaces.DaoPassenger;

public class DaoPassengerMySql implements DaoPassenger{
	
	
	
	
	
	private Connection con;
	
	
	
	
	
	
	
	
	public boolean openConnection() {
		
		String url = "jdbc:mysql://localhost:3306/bbdd";
		String user = "root";
		String password = "";
		
		try {
			
			con = DriverManager.getConnection(url, user, password);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			return false;
		}		
		
		return true;
		
	}
	
	
	
	
	
	
	public boolean closeConnection(){
		
		try {
			
			con.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			return false;
			
		}
		
		return true;
		
	}
	
	
	
	
	
		

	@Override
	public boolean register(Passenger p) {
		
		
		if(!openConnection()){
			return false;
		}
		boolean register = true;
		
		
		String query = "insert into passengers (ID,NAME,AGE,WEIGHT) "
				+ " values(?,?,?,?)";
		
		
		try {


			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, p.getId());
			ps.setString(2, p.getName());
			ps.setInt(3, p.getAge());
			ps.setDouble(4, p.getWeight());
			;
			
			
			int affectedRowsNumber = ps.executeUpdate();
			
			if(affectedRowsNumber == 0) {
				
				register = false;
				
			}
			
		} catch (SQLException e) {
			
			System.out.println("Create -> Error inserting: " + p);			
			
			register = false;
			
			e.printStackTrace();
			
		} finally{
			
			closeConnection();
			
		}
		
		return register;
	}
	

	@Override
	public boolean delete(int id) {
		
		if(!openConnection()){
			return false;
		}
		
		boolean deleted = true;
		
		String query = "delete from passengers where id = ?";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(query);
			
			
			
			ps.setInt(1, id);
			
			int affectedRowsNumber = ps.executeUpdate();
			
			if(affectedRowsNumber == 0)
				
				deleted = false;
			
		} catch (SQLException e) {
			
			System.out.println("delete -> It couldn't be deleted" + " the id: " + id);
			
			e.printStackTrace();
			
		} finally {
			
			closeConnection();
			
		}
		
		return deleted; 
		
	}

	
	
	
	@Override
	public Passenger read(int id) {
		
		if(!openConnection()){
			
			return null;
			
		}		
		
		Passenger p = null;
		
		String query = "select ID,NAME,AGE,WEIGHT,CARID from passengers " + "where id = ?";
	
		try {
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				p = new Passenger();
				
				p.setId(rs.getInt(1));				
				p.setName(rs.getString(2));
				p.setAge(rs.getInt(3));
				p.setWeight(rs.getDouble(4));		
				p.setCarId(rs.getInt(5));
				
			}
			
		} catch (SQLException e) {
			
			System.out.println("read -> Error retrieving the " + "passenger with id: " + id);
			
			e.printStackTrace();
			
		} finally {
			
			closeConnection();
			
		}
		
		
		return p;
	}

	
	
	@Override
	public List<Passenger> list() {


		if(!openConnection()){
			
			return null;
			
		}		
		
		List<Passenger> passList = new ArrayList<>();
		
		
		String query = "select ID,NAME,AGE,WEIGHT,CARID from passengers";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				Passenger p = new Passenger();
				
				p.setId(rs.getInt(1));
				
				p.setName(rs.getString(2));
				
				p.setAge(rs.getInt(3));
				
				p.setWeight(rs.getDouble(4));	
				
				p.setCarId(rs.getInt(5));
				
				passList.add(p);				
				
			}
			
		} catch (SQLException e) {
			
			System.out.println("list -> error al obtener las " + "personas");
			
			e.printStackTrace();
			
		} finally {
			
			closeConnection();
			
		}		
		
		return passList;	
		
	}

	
	
	
	
	
	
	
	
	@Override
	public boolean addPassToCar(int pId, int cId) {
		
		if(!openConnection()){
			
			return false;
			
		}			
		
		boolean added = true;		
		
		
		String query = "UPDATE passengers SET carId = ? WHERE id = ?";
		
		
		try {
			
			PreparedStatement ps = con.prepareStatement(query);		
			
			ps.setInt(1, cId);
		
			ps.setInt(2, pId);
		
			int affectedRowsNumber = ps.executeUpdate();
			
			if(affectedRowsNumber == 0)
				
				added = false;
			
			else
				
				added = true;
			
		} catch (SQLException e) {
			
			
			System.out.println("update -> error by adding the" + " passenger with id: " + pId + " to the car with id: " + cId);
			
			added = false;
			
			e.printStackTrace();
			
		} finally{
			
			closeConnection();
			
		}
		
		return added;
		
	}
		
		
		
		
		


	@Override
	public boolean deletePassFromCar(int pId, int cId) {
		
		
		
		if(!openConnection()){
			
			return false;
			
		}			
		
		boolean deleted = true;		
		
		
		String query = "UPDATE passengers SET carId = NULL WHERE id = ? AND carId = ?";
		
		
		try {
			
			PreparedStatement ps = con.prepareStatement(query);			
			
			ps.setInt(1, pId);
			
			ps.setInt(2, cId);		
		
			int affectedRowsNumber = ps.executeUpdate();
			
			if(affectedRowsNumber == 0)
				
				deleted = false;
			
			else
				
				deleted = true;
			
		} catch (SQLException e) {
			
			
			System.out.println("update -> error by deleting the" + " passenger with id: " + pId + " from the car with id: " + cId);
			
			deleted = false;
			
			e.printStackTrace();
			
		} finally{
			
			closeConnection();
			
		}
		
		return deleted;
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

	@Override
	public List<Passenger> listPassFromCar(int carId) {
		
		
		if(!openConnection()){
			
			return null;
			
		}			
		
		List<Passenger> pList = new ArrayList<>();
		
		
		String query = "SELECT * FROM passengers WHERE carId = ?";
		
		
		try {
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, carId);
		
			ResultSet rs = ps.executeQuery();
				
			while(rs.next()){
					
				Passenger psngr = new Passenger();
					
				psngr.setId(rs.getInt(1));
					
				psngr.setName(rs.getString(2));
					
				psngr.setAge(rs.getInt(3));
				
				psngr.setCarId(rs.getInt(4));
					
				psngr.setWeight(rs.getDouble(5));	
				
				
								
				pList.add(psngr);
					
				}
				
			} catch (SQLException e) {
				
				System.out.println("list -> Error retrieving " + "passengers in the car with id: " + carId);
				
				e.printStackTrace();
				
			} finally {
				
				closeConnection();
				
			}		
			
			return pList;
		
		
		
	}

}
